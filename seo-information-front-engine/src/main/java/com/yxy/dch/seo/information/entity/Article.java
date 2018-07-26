package com.yxy.dch.seo.information.entity;

import lombok.Data;

import java.util.Date;

/**
 * 文章表
 *
 * @author yangzhen
 */
@Data
public class Article {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Long id;
    /**
     * 标题
     */
    private String title;
    /**
     * 关键词
     */
    private String keyword;
    /**
     * 描述
     */
    private String desc;
    /**
     * 栏目id
     */
    private Long columnId;
    /**
     * 文章名称
     */
    private String name;
    /**
     * 文章内容
     */
    private String content;
    /**
     * 文章内容URL
     */
    private String contentUrl;
    /**
     * 是否推荐,1推荐/0不推荐
     */
    private Integer recommend;
    /**
     * 阅读数
     */
    private Integer readingNum;
    /**
     * 文章状态,0下架/1上架
     */
    private Integer state;
    /**
     * 上架时间
     */
    private Date upTime;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 创建用户id
     */
    private Long createUid;
    /**
     * 更新用户id
     */
    private String updateTime;
    /**
     * 更新用户id
     */
    private Long updateUid;
    /**
     * 文章标签,用逗号分隔
     */
    private String tags;
    /**
     * 相关文章,用逗号分隔
     */
    private String relateArticleIds;

    @Override
    public String toString() {
        return "Article{" +
                ", id=" + id +
                ", title=" + title +
                ", keyword=" + keyword +
                ", desc=" + desc +
                ", columnId=" + columnId +
                ", name=" + name +
                ", contentUrl=" + contentUrl +
                ", recommend=" + recommend +
                ", readingNum=" + readingNum +
                ", createTime=" + createTime +
                ", createUid=" + createUid +
                ", updateTime=" + updateTime +
                ", updateUid=" + updateUid +
                "}";
    }
}
