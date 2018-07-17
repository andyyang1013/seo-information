package com.yxy.dch.seo.information.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yxy.dch.seo.information.entity.Article;
import com.yxy.dch.seo.information.exception.BizException;
import com.yxy.dch.seo.information.exception.CodeMsg;
import com.yxy.dch.seo.information.mapper.ArticleMapper;
import com.yxy.dch.seo.information.mapper.ArticleTagMapper;
import com.yxy.dch.seo.information.mapper.TagMapper;
import com.yxy.dch.seo.information.service.IArticleService;
import com.yxy.dch.seo.information.vo.ArticleVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 文章service实现类
 *
 * @author yangzhen
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private TagMapper tagMapper;
    @Autowired
    private ArticleTagMapper articleTagMapper;

    @Override
    public ArticleVO create(ArticleVO param) {

        // 保存文章
        Article article = new Article();
        BeanUtils.copyProperties(param, article);
        articleMapper.insert(article);

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
        List<Article> articleList = articleMapper.selectList(new EntityWrapper<>(article));
        List<ArticleVO> articleVOList = new ArrayList<>();
        for (Article entity : articleList) {
            ArticleVO vo = new ArticleVO();
            BeanUtils.copyProperties(entity, vo);
            articleVOList.add(vo);
        }
        return articleVOList;
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

        ArticleVO articleVO = new ArticleVO();
        BeanUtils.copyProperties(article, articleVO);
        return articleVO;
    }
}
