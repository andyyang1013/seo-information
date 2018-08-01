package com.yxy.dch.seo.information.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * 文章表
 *
 * @author yangzhen
 */
@Data
@TableName("t_seo_article")
public class Article extends Model<Article> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;
    /**
     * 标题
     */
    @Size(max = 50, message = "文章标题不能超过50位")
    @TableField("title")
    private String title;
    /**
     * 关键词
     */
    @Size(max = 50, message = "文章关键词不能超过50位")
    @TableField("keyword")
    private String keyword;
    /**
     * 描述
     */
    @TableField("desc")
    private String desc;
    /**
     * 栏目id
     */
    @TableField("column_id")
    private String columnId;
    /**
     * 文章名称
     */
    @TableField("name")
    private String name;
    /**
     * 文章内容
     */
    @TableField("content")
    private String content;
    /**
     * 文章内容URL
     */
    @TableField("content_url")
    private String contentUrl;
    /**
     * 是否推荐,1推荐/0不推荐
     */
    @TableField("recommend")
    private Integer recommend;
    /**
     * 阅读数
     */
    @TableField("reading_num")
    private Integer readingNum;
    /**
     * 文章状态,0下架/1上架
     */
    @TableField("state")
    private Integer state;
    /**
     * 上架时间
     */
    @TableField("up_time")
    private Date upTime;
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
     * 更新用户id
     */
    @TableField("update_time")
    private Date updateTime;
    /**
     * 更新用户id
     */
    @TableField("update_uid")
    private String updateUid;
    /**
     * 文章标签,用逗号分隔
     */
    @TableField("tags")
    private String tags;
    /**
     * 相关文章,用逗号分隔
     */
    @TableField("relate_article_ids")
    private String relateArticleIds;
    /**
     * 文章页
     */
    @TableField("href")
    private String href;
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
