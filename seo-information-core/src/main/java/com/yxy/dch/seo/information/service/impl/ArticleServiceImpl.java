package com.yxy.dch.seo.information.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yxy.dch.seo.information.entity.Article;
import com.yxy.dch.seo.information.entity.ArticleRelate;
import com.yxy.dch.seo.information.entity.ArticleTagMapping;
import com.yxy.dch.seo.information.entity.Tag;
import com.yxy.dch.seo.information.exception.BizException;
import com.yxy.dch.seo.information.exception.CodeMsg;
import com.yxy.dch.seo.information.mapper.ArticleMapper;
import com.yxy.dch.seo.information.mapper.ArticleRelateMapper;
import com.yxy.dch.seo.information.mapper.ArticleTagMapper;
import com.yxy.dch.seo.information.mapper.TagMapper;
import com.yxy.dch.seo.information.service.IArticleService;
import com.yxy.dch.seo.information.util.Toolkit;
import com.yxy.dch.seo.information.vo.ArticleVO;
import io.minio.MinioClient;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 文章service实现类
 *
 * @author yangzhen
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

    private Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private TagMapper tagMapper;
    @Autowired
    private ArticleTagMapper articleTagMapper;
    @Autowired
    private ArticleRelateMapper articleRelateMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ArticleVO create(ArticleVO param) {

        // 保存文章
        Article article = new Article();
        BeanUtils.copyProperties(param, article);
        articleMapper.insert(article);

        // 保存文章标签
        if (StringUtils.isNotBlank(param.getTags())) {
            String[] tagNames = StringUtils.split(param.getTags(), ",");
            for (String tagName : tagNames) {
                Tag entity = new Tag();
                entity.setName(tagName);
                Tag tag = tagMapper.selectOne(entity);
                if (tag == null) {
                    tagMapper.insert(entity);
                    tag = new Tag();
                    BeanUtils.copyProperties(entity, tag);
                }
                ArticleTagMapping entityMapping = new ArticleTagMapping();
                entityMapping.setTagId(tag.getId());
                entityMapping.setArticleId(article.getId());
                ArticleTagMapping articleTagMapping = articleTagMapper.selectOne(entityMapping);
                if (articleTagMapping == null) {
                    articleTagMapper.insert(entityMapping);
                }
            }
        }

        // 保存相关文章
        if (StringUtils.isNotBlank(param.getRelateArticleIds())) {
            String[] articleRelateIds = StringUtils.split(param.getRelateArticleIds(), ",");
            for (String articleRelateId : articleRelateIds) {
                ArticleRelate entity = new ArticleRelate();
                entity.setArticleId(article.getId());
                entity.setRelateArticleId(Long.valueOf(articleRelateId));
                ArticleRelate articleRelate = articleRelateMapper.selectOne(entity);
                if (articleRelate == null) {
                    articleRelateMapper.insert(entity);
                }
            }
        }

        // 查询保存后的文章
        Article createdArticle = articleMapper.selectById(article.getId());
        ArticleVO createdArticleVO = new ArticleVO();
        BeanUtils.copyProperties(createdArticle, createdArticleVO);
        return createdArticleVO;
    }

    @Override
    public Boolean remove(ArticleVO param) {
        Article article = articleMapper.selectById(param.getId());
        if (article == null) {
            throw new BizException(CodeMsg.record_not_exist);
        }

        // 删除文章标签关联
        ArticleTagMapping articleTagMapping=new ArticleTagMapping();
        articleTagMapping.setArticleId(article.getId());
        articleTagMapper.delete(new EntityWrapper<>(articleTagMapping));

        // 删除相关文章关联
        articleRelateMapper.deleteArticleRelate(article.getId());

        // 删除文章内容
        // TODO:删除文章内容

        // 删除文章
        articleMapper.deleteById(param.getId());
        return true;
    }

    @Override
    public ArticleVO modify(ArticleVO param) {
        Article article = articleMapper.selectById(param.getId());
        if (article == null) {
            throw new BizException(CodeMsg.record_not_exist);
        }
        BeanUtils.copyProperties(param, article);
        articleMapper.updateById(article);
        Article modifiedArticle = articleMapper.selectById(param.getId());
        ArticleVO modifiedArticleVO = new ArticleVO();
        BeanUtils.copyProperties(modifiedArticle, modifiedArticleVO);
        return modifiedArticleVO;
    }

    @Override
    public ArticleVO view(ArticleVO param) {
        Article article = articleMapper.selectById(param.getId());
        if (article == null) {
            throw new BizException(CodeMsg.record_not_exist);
        }
        ArticleVO articleVO = new ArticleVO();
        BeanUtils.copyProperties(article, articleVO);
        return articleVO;
    }

    @Override
    public ArticleVO up(ArticleVO param) {
        Article article = articleMapper.selectById(param.getId());
        if (article == null) {
            throw new BizException(CodeMsg.record_not_exist);
        }
        article.setState(1);
        article.setUpTime(Toolkit.getCurDate());
        articleMapper.updateById(article);
        Article upArticle = articleMapper.selectById(article.getId());
        ArticleVO upArticleVO = new ArticleVO();
        BeanUtils.copyProperties(upArticle, upArticleVO);
        return upArticleVO;
    }

    @Override
    public ArticleVO down(ArticleVO param) {
        Article article = articleMapper.selectById(param.getId());
        if (article == null) {
            logger.error("下架的文章不存在");
            throw new BizException(CodeMsg.record_not_exist);
        }
        article.setState(0);
        articleMapper.updateById(article);
        Article upArticle = articleMapper.selectById(article.getId());
        ArticleVO upArticleVO = new ArticleVO();
        BeanUtils.copyProperties(upArticle, upArticleVO);
        return upArticleVO;
    }

    @Override
    public List<ArticleVO> listBy(ArticleVO param) {
        Article article = new Article();
        BeanUtils.copyProperties(param, article);
        return articleMapper.selectArticleList(article);
    }

    @Override
    public List<ArticleVO> hottest() {
        Article article = new Article();
        List<Article> articleList = articleMapper.selectList(new EntityWrapper<>(article).orderBy("readingNum", false));
        List<ArticleVO> articleVOList = new ArrayList<>();
        for (Article entity : articleList) {
            ArticleVO vo = new ArticleVO();
            BeanUtils.copyProperties(entity, vo);
            articleVOList.add(vo);
        }
        return articleVOList;
    }

    @Override
    public List<ArticleVO> newest() {
        Article article = new Article();
        List<Article> articleList = articleMapper.selectList(new EntityWrapper<>(article).orderBy("updateTime", false));
        List<ArticleVO> articleVOList = new ArrayList<>();
        for (Article entity : articleList) {
            ArticleVO vo = new ArticleVO();
            BeanUtils.copyProperties(entity, vo);
            articleVOList.add(vo);
        }
        return articleVOList;
    }

    @Override
    public List<ArticleVO> recommended() {
        Article article = new Article();
        List<Article> articleList = articleMapper.selectList(new EntityWrapper<>(article).where("recommend={0}", 1));
        List<ArticleVO> articleVOList = new ArrayList<>();
        for (Article entity : articleList) {
            ArticleVO vo = new ArticleVO();
            BeanUtils.copyProperties(entity, vo);
            articleVOList.add(vo);
        }
        return articleVOList;
    }

    @Override
    public List<ArticleVO> filterByColumn(ArticleVO param) {
        Article article = new Article();
        List<Article> articleList = articleMapper.selectList(new EntityWrapper<>(article).where("column_id={0}", param.getColumnId()));
        List<ArticleVO> articleVOList = new ArrayList<>();
        for (Article entity : articleList) {
            ArticleVO vo = new ArticleVO();
            BeanUtils.copyProperties(entity, vo);
            articleVOList.add(vo);
        }
        return articleVOList;
    }

    @Override
    public List<ArticleVO> filterByTag(ArticleVO param) {
        Article article = new Article();
        List<Article> articleList = articleMapper.selectList(new EntityWrapper<>(article).like("tags", "%" + param.getTags() + "%"));
        List<ArticleVO> articleVOList = new ArrayList<>();
        for (Article entity : articleList) {
            ArticleVO vo = new ArticleVO();
            BeanUtils.copyProperties(entity, vo);
            articleVOList.add(vo);
        }
        return articleVOList;
    }

    @Override
    public ArticleVO read(ArticleVO param) {
        Article article = articleMapper.selectById(param.getId());
        if (article == null) {
            throw new BizException(CodeMsg.record_not_exist);
        }

        // 阅读数+1
        article.setReadingNum(article.getReadingNum() + 1);
        articleMapper.updateById(article);

        return articleMapper.selectArticleById(article.getId());
    }
}
