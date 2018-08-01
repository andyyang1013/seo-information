package com.yxy.dch.seo.information.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 栏目表
 *
 * @author yangzhen
 */
@Data
@TableName("t_seo_column")
public class Column extends Model<Column> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;
    /**
     * 标题
     */
    @TableField("title")
    private String title;
    /**
     * 关键词
     */
    @TableField("keyword")
    private String keyword;
    /**
     * 描述
     */
    @TableField("desc")
    private String desc;
    /**
     * 频道id
     */
    @TableField("channel_id")
    private String channelId;
    /**
     * 栏目名称
     */
    @TableField("name")
    private String name;
    /**
     * 栏目名称拼音
     */
    @TableField("name_pinyin")
    private String namePinyin;
    /**
     * 栏目页
     */
    @TableField("href")
    private String href;
    /**
     * 导航显示,1显示/0隐藏
     */
    @TableField("visible")
    private Integer visible;
    /**
     * 排序
     */
    @TableField("order_num")
    private Integer orderNum;
    /**
     * 图片URL
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
        return "Column{" +
                ", id=" + id +
                ", title=" + title +
                ", keyword=" + keyword +
                ", desc=" + desc +
                ", channelId=" + channelId +
                ", name=" + name +
                ", href=" + href +
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
