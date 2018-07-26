package com.yxy.dch.seo.information.vo;

import com.yxy.dch.seo.information.entity.Article;
import com.yxy.dch.seo.information.entity.Column;
import com.yxy.dch.seo.information.entity.Tag;
import lombok.Data;

import java.util.List;

/**
 * 文章VO
 *
 * @author yangzhen
 */
@Data
public class ArticleVO extends Article {
    /**
     * 文章所属栏目
     */
    private Column column;
    /**
     * 文章标签列表
     */
    private List<Tag> tagList;
    /**
     * 相关文章列表
     */
    private List<Article> relateArticleList;
}
