package com.yxy.dch.seo.information.config.pros;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * minio配置属性
 *
 * @author yangzhen
 */
@ConfigurationProperties(prefix = "minio")
public class MinioProperties {
    /**
     * accessKey
     */
    private String accessKey;
    /**
     * secretKey
     */
    private String secretKey;
    /**
     * endpoint
     */
    private String endpoint;
    /**
     * bucket name
     */
    private String bucketName;
    /**
     * column picture base dir
     */
    private String columnPictureBaseDir;
    /**
     * article content base dir
     */
    private String articleContentBaseDir;
    /**
     * article content img base dir
     */
    private String articleContentImgBaseDir;
    /**
     * channel banner picture base dir
     */
    private String channelBannerPictureBaseDir;

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getColumnPictureBaseDir() {
        return columnPictureBaseDir;
    }

    public void setColumnPictureBaseDir(String columnPictureBaseDir) {
        this.columnPictureBaseDir = columnPictureBaseDir;
    }

    public String getArticleContentBaseDir() {
        return articleContentBaseDir;
    }

    public void setArticleContentBaseDir(String articleContentBaseDir) {
        this.articleContentBaseDir = articleContentBaseDir;
    }

    public String getArticleContentImgBaseDir() {
        return articleContentImgBaseDir;
    }

    public void setArticleContentImgBaseDir(String articleContentImgBaseDir) {
        this.articleContentImgBaseDir = articleContentImgBaseDir;
    }

    public String getChannelBannerPictureBaseDir() {
        return channelBannerPictureBaseDir;
    }

    public void setChannelBannerPictureBaseDir(String channelBannerPictureBaseDir) {
        this.channelBannerPictureBaseDir = channelBannerPictureBaseDir;
    }
}
