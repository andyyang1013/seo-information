package com.yxy.dch.seo.information.service.front.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yxy.dch.seo.information.entity.Article;
import com.yxy.dch.seo.information.entity.ArticleReadRecord;
import com.yxy.dch.seo.information.entity.Tag;
import com.yxy.dch.seo.information.exception.BizException;
import com.yxy.dch.seo.information.exception.CodeMsg;
import com.yxy.dch.seo.information.mapper.ArticleMapper;
import com.yxy.dch.seo.information.mapper.ArticleReadRecordMapper;
import com.yxy.dch.seo.information.service.front.IFrontArticleService;
import com.yxy.dch.seo.information.vo.ArticleVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class FrontArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IFrontArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private ArticleReadRecordMapper articleReadRecordMapper;

    @Override
    public List<ArticleVO> hottest(Integer limit) {
        return articleMapper.selectHottestArticles(limit);
    }

    @Override
    public List<ArticleVO> newest(Integer limit) {
        return articleMapper.selectNewestArticles(limit);
    }

    @Override
    public List<ArticleVO> recommended(Integer limit) {
        return articleMapper.selectRecommendedArticles(limit);
    }

    @Override
    public List<ArticleVO> getArticlesByColNamePinyin(String namePinyin) {
        return articleMapper.getArticlesByColNamePinyin(namePinyin);
    }

    @Override
    public List<ArticleVO> dayTopArticles() {
        return articleMapper.dayTopArticles();
    }

    @Override
    public List<ArticleVO> weekTopArticles() {
        return articleMapper.weekTopArticles();
    }

    @Override
    public List<ArticleVO> getArticlesByTagId(String tagId) {
        List<ArticleVO> articleList = articleMapper.getArticlesByTagId(tagId);
        for (ArticleVO article : articleList) {
            String tags = article.getTags();
            if (StringUtils.isNotBlank(tags)) {
                String[] tagArray = StringUtils.split(tags, ",");
                if (tagArray != null && tagArray.length > 0) {
                    List<Tag> tagList = new ArrayList<>();
                    for (String tagName : tagArray) {
                        Tag tag = new Tag();
                        tag.setName(tagName);
                        tagList.add(tag);
                    }
                    article.setTagList(tagList);
                }
            }
        }
        return articleList;
    }

    @Override
    public ArticleVO selectLastArticle(String columnId, String id) {
        return articleMapper.selectLastArticle(columnId, id);
    }

    @Override
    public ArticleVO selectNextArticle(String columnId, String id) {
        return articleMapper.selectNextArticle(columnId, id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ArticleVO view(ArticleVO param) {
        ArticleVO articleVO = articleMapper.selectArticleById(param.getId());
        if (articleVO == null) {
            throw new BizException(CodeMsg.record_not_exist);
        }
        // 阅读数+1
        articleVO.setReadingNum(articleVO.getReadingNum() + 1);
        articleMapper.updateById(articleVO);
        // 保存文章阅读记录
        ArticleReadRecord articleReadRecord = new ArticleReadRecord();
        articleReadRecord.setArticleId(articleVO.getId());
        articleReadRecord.setArticleName(articleVO.getName());
        articleReadRecord.setClientIp(param.getClientIp());
        articleReadRecordMapper.insert(articleReadRecord);
        return articleVO;
    }
}
