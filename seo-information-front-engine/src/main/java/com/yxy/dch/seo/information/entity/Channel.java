package com.yxy.dch.seo.information.entity;

import lombok.Data;

/**
 * 频道表
 *
 * @author yangzhen
 */
@Data
public class Channel {

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
        return "Channel{" +
                ", id=" + id +
                ", title=" + title +
                ", keyword=" + keyword +
                ", desc=" + desc +
                ", createTime=" + createTime +
                ", createUid=" + createUid +
                ", updateTime=" + updateTime +
                ", updateUid=" + updateUid +
                "}";
    }
}
