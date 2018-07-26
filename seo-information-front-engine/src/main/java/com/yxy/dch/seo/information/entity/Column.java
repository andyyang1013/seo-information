package com.yxy.dch.seo.information.entity;

import lombok.Data;

/**
 * 栏目表
 *
 * @author yangzhen
 */
@Data
@Table
public class Column {

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
     * 频道id
     */
    private Long channelId;
    /**
     * 栏目名称
     */
    private String name;
    /**
     * 栏目路径
     */
    private String url;
    /**
     * 导航显示,1显示/0隐藏
     */
    private Integer visible;
    /**
     * 排序
     */
    private Integer orderNum;
    /**
     * 图片URL
     */
    private String pictureUrl;
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
        return "Column{" +
                ", id=" + id +
                ", title=" + title +
                ", keyword=" + keyword +
                ", desc=" + desc +
                ", channelId=" + channelId +
                ", name=" + name +
                ", url=" + url +
                ", visible=" + visible +
                ", orderNum=" + orderNum +
                ", pictureUrl=" + pictureUrl +
                ", createTime=" + createTime +
                ", createUid=" + createUid +
                ", updateTime=" + updateTime +
                ", updateUid=" + updateUid +
                "}";
    }
}
