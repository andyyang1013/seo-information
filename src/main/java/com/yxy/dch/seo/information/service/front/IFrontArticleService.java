package com.yxy.dch.seo.information.service.front;

import com.baomidou.mybatisplus.service.IService;
import com.yxy.dch.seo.information.entity.Article;
import com.yxy.dch.seo.information.vo.ArticleVO;

import java.util.List;

public interface IFrontArticleService extends IService<Article> {
    List<ArticleVO> hottest(Integer limit);

    List<ArticleVO> newest(Integer limit);

    List<ArticleVO> recommended(Integer limit);

    ArticleVO view(ArticleVO param);

    List<ArticleVO> getArticlesByColNamePinyin(String namePinyin);

    List<ArticleVO> dayTopArticles();

    List<ArticleVO> weekTopArticles();

    List<ArticleVO> getArticlesByTagId(String tagId);

    ArticleVO selectLastArticle(String columnId, String id);

    ArticleVO selectNextArticle(String columnId, String id);
}
