package com.yxy.dch.seo.information.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * banner表
 *
 * @author yangzhen
 */
@Data
@TableName("t_seo_banner")
public class Banner extends Model<Banner> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;
    /**
     * 频道id
     */
    @TableField("channel_id")
    private String channelId;
    /**
     * banner名称
     */
    @TableField("name")
    private String name;
    /**
     * 显示状态,1显示/0不显示
     */
    @TableField("visible")
    private Integer visible;
    /**
     * 跳转地址
     */
    @TableField("url")
    private String url;
    /**
     * 摘要
     */
    @TableField("summary")
    private String summary;
    /**
     * 点击数
     */
    @TableField("click_num")
    private Integer clickNum;
    /**
     * 排序
     */
    @TableField("order_num")
    private Integer orderNum;
    /**
     * 图片URl
     */
    @TableField("picture_url")
    private String pictureUrl;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 创建用户id
     */
    @TableField("create_uid")
    private String createUid;
    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;
    /**
     * 更新用户id
     */
    @TableField("update_uid")
    private String updateUid;
    /**
     * 创建人用户名
     */
    @TableField("create_uaccount")
    private String createUaccount;
    /**
     * 修改人用户名
     */
    @TableField("update_uaccount")
    private String updateUaccount;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

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
