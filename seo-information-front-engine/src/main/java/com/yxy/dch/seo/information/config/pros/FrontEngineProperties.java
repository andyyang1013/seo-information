package com.yxy.dch.seo.information.config.pros;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "front.engine")
public class FrontEngineProperties {
    /**
     * html文件输出路径
     */
    private String htmlPath;

    /**
     * 热门文章数据源URL
     */
    private String sourceHottestUrl;

    /**
     * 最新文章数据源URL
     */
    private String sourceNewestUrl;

    /**
     * 推荐文章数据源URL
     */
    private String sourceRecommendedUrl;

    /**
     * 查询文章数据源URL
     */
    private String sourceArticleViewUrl;

    public String getHtmlPath() {
        return htmlPath;
    }

    public void setHtmlPath(String htmlPath) {
        this.htmlPath = htmlPath;
    }

    public String getSourceHottestUrl() {
        return sourceHottestUrl;
    }

    public void setSourceHottestUrl(String sourceHottestUrl) {
        this.sourceHottestUrl = sourceHottestUrl;
    }

    public String getSourceNewestUrl() {
        return sourceNewestUrl;
    }

    public void setSourceNewestUrl(String sourceNewestUrl) {
        this.sourceNewestUrl = sourceNewestUrl;
    }

    public String getSourceRecommendedUrl() {
        return sourceRecommendedUrl;
    }

    public void setSourceRecommendedUrl(String sourceRecommendedUrl) {
        this.sourceRecommendedUrl = sourceRecommendedUrl;
    }

    public String getSourceArticleViewUrl() {
        return sourceArticleViewUrl;
    }

    public void setSourceArticleViewUrl(String sourceArticleViewUrl) {
        this.sourceArticleViewUrl = sourceArticleViewUrl;
    }
}
