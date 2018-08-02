package com.yxy.dch.seo.information.service.front;

import com.baomidou.mybatisplus.service.IService;
import com.yxy.dch.seo.information.entity.Article;
import com.yxy.dch.seo.information.vo.ArticleVO;

import java.util.List;

public interface IFrontArticleService extends IService<Article> {
    List<ArticleVO> hottest();

    List<ArticleVO> newest();

    List<ArticleVO> recommended();

    ArticleVO view(ArticleVO param);

    List<ArticleVO> getArticlesByColNamePinyin(String namePinyin);

    List<ArticleVO> dayTopArticles();

    List<ArticleVO> weekTopArticles();

    List<ArticleVO> getArticlesByTagId(String tagId);

    ArticleVO selectLastArticle(String id);

    ArticleVO selectNextArticle(String id);
}
