package com.yxy.dch.seo.information.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章阅读记录
 *
 * @author yangzhen
 */
@Data
@TableName("t_seo_article_read_record")
public class ArticleReadRecord extends Model<ArticleReadRecord> {
    /**
     * 主键ID
     */
    private String id;

    /**
     * 文章ID
     */
    @TableField("article_id")
    private String articleId;

    /**
     * 文章名称
     */
    @TableField("article_name")
    private String articleName;

    /**
     * 客户端IP
     */
    @TableField("client_ip")
    private String clientIp;

    /**
     * 阅读时间
     */
    @TableField("read_time")
    private Date readTime;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
