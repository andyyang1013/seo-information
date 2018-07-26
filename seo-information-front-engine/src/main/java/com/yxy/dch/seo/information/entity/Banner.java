package com.yxy.dch.seo.information.entity;

import lombok.Data;

/**
 * banner表
 *
 * @author yangzhen
 */
@Data
public class Banner {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Long id;
    /**
     * 频道id
     */
    private Long channelId;
    /**
     * banner名称
     */
    private String name;
    /**
     * 显示状态,1显示/0不显示
     */
    private Integer visible;
    /**
     * 跳转地址
     */
    private String url;
    /**
     * 摘要
     */
    private String summary;
    /**
     * 点击数
     */
    private Integer clickNum;
    /**
     * 排序
     */
    private Integer orderNum;
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
        return "Banner{" +
                ", id=" + id +
                ", channelId=" + channelId +
                ", name=" + name +
                ", visible=" + visible +
                ", url=" + url +
                ", summary=" + summary +
                ", clickNum=" + clickNum +
                ", orderNum=" + orderNum +
                ", createTime=" + createTime +
                ", createUid=" + createUid +
                ", updateTime=" + updateTime +
                ", updateUid=" + updateUid +
                "}";
    }
}
