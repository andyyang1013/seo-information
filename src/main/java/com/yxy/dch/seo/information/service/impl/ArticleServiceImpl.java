package com.yxy.dch.seo.information.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yxy.dch.seo.information.entity.*;
import com.yxy.dch.seo.information.exception.BizException;
import com.yxy.dch.seo.information.exception.CodeMsg;
import com.yxy.dch.seo.information.mapper.ArticleMapper;
import com.yxy.dch.seo.information.mapper.ArticleRelateMapper;
import com.yxy.dch.seo.information.mapper.ArticleTagMapper;
import com.yxy.dch.seo.information.mapper.TagMapper;
import com.yxy.dch.seo.information.service.IArticleService;
import com.yxy.dch.seo.information.service.IChannelService;
import com.yxy.dch.seo.information.service.IColumnService;
import com.yxy.dch.seo.information.service.ITagService;
import com.yxy.dch.seo.information.util.JacksonUtil;
import com.yxy.dch.seo.information.util.Toolkit;
import com.yxy.dch.seo.information.vo.ArticleRelateVO;
import com.yxy.dch.seo.information.vo.ArticleVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private ITagService tagService;
    @Autowired
    private IColumnService columnService;
    @Autowired
    private IChannelService channelService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ArticleVO create(ArticleVO param) {

        // 栏目是否存在
        Column column = columnService.selectById(param.getColumnId());
        if (column == null) {
            logger.error("栏目不存在({})", param.getColumnId());
            throw new BizException(CodeMsg.record_not_exist);
        }

        // 保存文章
        Article article = new Article();
        BeanUtils.copyProperties(param, article);
        articleMapper.insert(article);

        // 保存文章标签
        tagService.save(article.getId(), article.getTags());

        // 保存相关文章
        this.save(article.getId(), article.getRelateArticleIds());

        // 查询保存后的文章
        return articleMapper.selectArticleById(article.getId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean remove(ArticleVO param) {
        Article article = articleMapper.selectById(param.getId());
        if (article == null) {
            throw new BizException(CodeMsg.record_not_exist);
        }

        // 删除文章标签关联
        ArticleTagMapping articleTagMapping = new ArticleTagMapping();
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
    @Transactional(rollbackFor = Exception.class)
    public ArticleVO modify(ArticleVO param) {
        Article article = articleMapper.selectById(param.getId());
        if (article == null) {
            throw new BizException(CodeMsg.record_not_exist);
        }

        BeanUtils.copyProperties(param, article);
        articleMapper.updateById(article);

        // 保存文章标签
        tagService.save(article.getId(), article.getTags());

        // 保存相关文章
        this.save(article.getId(), article.getRelateArticleIds());

        return articleMapper.selectArticleById(article.getId());
    }

    @Override
    public ArticleVO view(ArticleVO param) {
        ArticleVO articleVO = articleMapper.selectArticleById(param.getId());
        if (articleVO == null) {
            throw new BizException(CodeMsg.record_not_exist);
        }
        return articleVO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ArticleVO up(ArticleVO param) {
        Article article = articleMapper.selectById(param.getId());
        if (article == null) {
            throw new BizException(CodeMsg.record_not_exist);
        }

        article.setState(1);
        article.setUpTime(Toolkit.getCurDate());
        articleMapper.updateById(article);

        return articleMapper.selectArticleById(article.getId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ArticleVO down(ArticleVO param) {
        Article article = articleMapper.selectById(param.getId());
        if (article == null) {
            logger.error("下架的文章不存在");
            throw new BizException(CodeMsg.record_not_exist);
        }

        article.setState(0);
        articleMapper.updateById(article);

        return articleMapper.selectArticleById(article.getId());
    }

    @Override
    public List<ArticleVO> listBy(ArticleVO param) {
        Article article = new Article();
        BeanUtils.copyProperties(param, article);
        return articleMapper.selectArticleList(article);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> read(ArticleVO param) {
        if (param == null || StringUtils.isBlank(param.getId())) {
            logger.error("阅读文章参数错误,param={}",JacksonUtil.toJson(param));
            throw new BizException(CodeMsg.param_note_blank);
        }
        Article article = this.selectById(param.getId());
        if (article == null) {
            logger.error("阅读文章错误{}",CodeMsg.record_not_exist.getMsg());
            throw new BizException(CodeMsg.record_not_exist);
        }

        // 文章id
        String articleId = article.getId();

        // 阅读数+1
        article.setReadingNum(article.getReadingNum() + 1);
        articleMapper.updateById(article);

        Map<String,Object> model = new HashMap<>();
        ArticleVO articleVO = articleMapper.selectArticleById(articleId);
        model.put("article",articleVO);

        // 频道id
        String channelId=articleVO.getColumn().getChannelId();
        Channel channel = channelService.selectById(channelId);
        model.put("channel",channel);

        return model;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(String articleId, String relateArticleIds) {
        if (StringUtils.isBlank(articleId)) {
            throw new BizException(CodeMsg.param_note_blank);
        }
        if (StringUtils.isBlank(relateArticleIds)) {
            // 删除所有相关文章
            ArticleRelate entity = new ArticleRelate();
            entity.setArticleId(articleId);
            articleRelateMapper.delete(new EntityWrapper<>(entity));
            return;
        }
        // 查询文章现有相关文章
        List<ArticleRelateVO> relateList = articleRelateMapper.selectRelateList(articleId);
        // 保存相关文章关系
        String[] relateArray = relateArticleIds.split(",");
        for (String relateId : relateArray) {
            boolean exist = false;
            for (ArticleRelateVO vo : relateList) {
                if (relateId.equals(vo.getRelateArticleId())) {
                    exist = true;
                    break;
                }
            }
            if (!exist) {
                ArticleRelate articleRelate = new ArticleRelate();
                articleRelate.setArticleId(articleId);
                articleRelate.setRelateArticleId(relateId);
                articleRelateMapper.insert(articleRelate);
            }
        }
    }

    @Override
    public void removeByColumnId(String columnId) {
        if (StringUtils.isBlank(columnId)) {
            throw new BizException(CodeMsg.param_note_blank);
        }
        Article param = new Article();
        param.setColumnId(columnId);
        List<Article> articleList = articleMapper.selectList(new EntityWrapper<>(param));
        if (articleList == null || articleList.size() == 0) {
            return;
        }
        for (Article obj : articleList) {
            ArticleVO article = new ArticleVO();
            article.setId(obj.getId());
            this.remove(article);
        }

    }
}
