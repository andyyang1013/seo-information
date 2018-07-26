package com.yxy.dch.seo.information.entity;

import lombok.Data;

/**
 * 相关文章
 *
 * @author yangzhen
 */
@Data
public class ArticleRelate {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Long id;
    /**
     * 文章id
     */
    private Long articleId;
    /**
     * 相关文章id
     */
    private Long relateArticleId;
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

    @Override
    public String toString() {
        return "Article{" +
                ", id=" + id +
                ", articleId=" + articleId +
                ", relateArticleId=" + relateArticleId +
                ", createTime=" + createTime +
                ", createUid=" + createUid +
                ", updateTime=" + updateTime +
                ", updateUid=" + updateUid +
                "}";
    }
}
