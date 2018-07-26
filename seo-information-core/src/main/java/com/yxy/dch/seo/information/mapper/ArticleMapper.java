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

    List<ArticleVO> selectHottestArticles();
}
