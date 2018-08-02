package com.yxy.dch.seo.information.service.front.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yxy.dch.seo.information.entity.Article;
import com.yxy.dch.seo.information.exception.BizException;
import com.yxy.dch.seo.information.exception.CodeMsg;
import com.yxy.dch.seo.information.mapper.ArticleMapper;
import com.yxy.dch.seo.information.service.front.IFrontArticleService;
import com.yxy.dch.seo.information.vo.ArticleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FrontArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IFrontArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<ArticleVO> hottest() {
        return articleMapper.selectHottestArticles();
    }

    @Override
    public List<ArticleVO> newest() {
        return articleMapper.selectNewestArticles();
    }

    @Override
    public List<ArticleVO> recommended() {
        return articleMapper.selectRecommendedArticles();
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
        return articleMapper.getArticlesByTagId(tagId);
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
    public ArticleVO view(ArticleVO param) {
        ArticleVO articleVO = articleMapper.selectArticleById(param.getId());
        if (articleVO == null) {
            throw new BizException(CodeMsg.record_not_exist);
        }
        // 阅读数+1
        articleVO.setReadingNum(articleVO.getReadingNum() + 1);
        articleMapper.updateById(articleVO);
        return articleVO;
    }
}
