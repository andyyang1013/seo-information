package com.yxy.dch.seo.information.config.pros;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * html生成配置
 *
 * @author yangzhen
 */
@ConfigurationProperties("html")
public class HtmlProperties {
    /**
     * html生成路径
     */
    private String dir;

    /**
     * 频道首页
     */
    private String basePath;

    /**
     * 栏目页
     */
    private String columnHref;

    /**
     * 文章页
     */
    private String articleHref;

    /**
     * 标签首页
     */
    private String tagHref;

    /**
     * 标签详细页
     */
    private String tagDetailHref;

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getColumnHref() {
        return columnHref;
    }

    public void setColumnHref(String columnHref) {
        this.columnHref = columnHref;
    }

    public String getArticleHref() {
        return articleHref;
    }

    public void setArticleHref(String articleHref) {
        this.articleHref = articleHref;
    }

    public String getTagHref() {
        return tagHref;
    }

    public void setTagHref(String tagHref) {
        this.tagHref = tagHref;
    }

    public String getTagDetailHref() {
        return tagDetailHref;
    }

    public void setTagDetailHref(String tagDetailHref) {
        this.tagDetailHref = tagDetailHref;
    }
}
