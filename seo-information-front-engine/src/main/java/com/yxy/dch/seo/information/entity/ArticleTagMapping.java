package com.yxy.dch.seo.information.entity;

import lombok.Data;

/**
 * 文章标签关联表
 *
 * @author yangzhen
 */
@Data
public class ArticleTagMapping {

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
     * 标签id
     */
    private Long tagId;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 创建用户id
     */
    private Long createUid;
    /**
     * 更新时间
     */
    private String updateTime;
    /**
     * 更新用户id
     */
    private Long updateUid;

    @Override
    public String toString() {
        return "ArticleTagMapping{" +
                ", id=" + id +
                ", articleId=" + articleId +
                ", tagId=" + tagId +
                ", createTime=" + createTime +
                ", createUid=" + createUid +
                ", updateTime=" + updateTime +
                ", updateUid=" + updateUid +
                "}";
    }
}
