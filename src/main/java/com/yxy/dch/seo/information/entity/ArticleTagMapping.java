package com.yxy.dch.seo.information.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章标签关联表
 *
 * @author yangzhen
 */
@Data
@TableName("t_seo_article_tag_mapping")
public class ArticleTagMapping extends Model<ArticleTagMapping> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;
    /**
     * 文章id
     */
    @TableField("article_id")
    private String articleId;
    /**
     * 标签id
     */
    @TableField("tag_id")
    private String tagId;
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
