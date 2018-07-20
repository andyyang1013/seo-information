package com.yxy.dch.seo.information.vo;

import com.yxy.dch.seo.information.entity.Article;
import com.yxy.dch.seo.information.entity.Tag;

import java.util.List;

/**
 * 文章VO
 *
 * @author yangzhen
 */
public class ArticleVO extends Article {
    /**
     * 文章标签列表
     */
    private List<Tag> tagList;
    /**
     * 相关文章列表
     */
    private List<Article> relateArticleList;

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public List<Article> getRelateArticleList() {
        return relateArticleList;
    }

    public void setRelateArticleList(List<Article> relateArticleList) {
        this.relateArticleList = relateArticleList;
    }
}
