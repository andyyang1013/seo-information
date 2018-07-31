package com.yxy.dch.seo.information.service;

import com.baomidou.mybatisplus.service.IService;
import com.yxy.dch.seo.information.entity.Article;
import com.yxy.dch.seo.information.vo.ArticleVO;

import java.util.List;

/**
 * 文章service接口
 *
 * @author yangzhen
 */
public interface IArticleService extends IService<Article> {
    ArticleVO create(ArticleVO param);

    Boolean remove(ArticleVO param);

    ArticleVO modify(ArticleVO param);

    ArticleVO view(ArticleVO param);

    ArticleVO up(ArticleVO param);

    ArticleVO down(ArticleVO param);

    List<ArticleVO> listBy(ArticleVO param);

    List<ArticleVO> hottest();

    List<ArticleVO> newest();

    List<ArticleVO> recommended();

    ArticleVO read(ArticleVO param);

    void save(String articleId, String relateArticleIds);

    List<ArticleVO> getArticlesByColNamePinyin(String namePinyin);

    List<ArticleVO> dayTopArticles();

    List<ArticleVO> weekTopArticles();

    List<ArticleVO> getArticlesByTagId(String tagId);

    void removeByColumnId(String columnId);
}
