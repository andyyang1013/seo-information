package com.yxy.dch.seo.information.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yxy.dch.seo.information.entity.Article;
import com.yxy.dch.seo.information.vo.ArticleVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文章mapper接口
 *
 * @author yangzhen
 */
public interface ArticleMapper extends BaseMapper<Article> {
    ArticleVO selectArticleById(@Param("id") String id);

    List<ArticleVO> selectArticleList(Article article);

    List<ArticleVO> selectHottestArticles(@Param("limit") Integer limit);

    List<ArticleVO> selectNewestArticles(@Param("limit") Integer limit);

    List<ArticleVO> selectRecommendedArticles(@Param("limit") Integer limit);

    List<Article> selectArticlesByColumnId(String columnId);

    List<ArticleVO> getArticlesByColNamePinyin(String namePinyin);

    List<ArticleVO> dayTopArticles();

    List<ArticleVO> weekTopArticles();

    List<ArticleVO> getArticlesByTagId(String tagId);

    ArticleVO selectLastArticle(@Param("columnId") String columnId, @Param("id") String id);

    ArticleVO selectNextArticle(@Param("columnId") String columnId, @Param("id") String id);

    List<ArticleVO> recommendedByColumn(@Param("columnId") String columnId, @Param("limit") Integer limit);

    List<ArticleVO> newestByColumn(@Param("columnId") String columnId, @Param("limit") Integer limit);
}
