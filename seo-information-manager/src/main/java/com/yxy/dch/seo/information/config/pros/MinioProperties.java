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
     * column picture dir
     */
    private String columnPictureDir;
    /**
     * article content dir
     */
    private String articleContentDir;

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

    public String getColumnPictureDir() {
        return columnPictureDir;
    }

    public void setColumnPictureDir(String columnPictureDir) {
        this.columnPictureDir = columnPictureDir;
    }

    public String getArticleContentDir() {
        return articleContentDir;
    }

    public void setArticleContentDir(String articleContentDir) {
        this.articleContentDir = articleContentDir;
    }
}
