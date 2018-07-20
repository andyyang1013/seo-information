package com.yxy.dch.seo.information.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章表
 *
 * @author yangzhen
 */
@TableName("t_seo_article")
public class Article extends Model<Article> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Long id;
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
     * 栏目id
     */
    @TableField("column_id")
    private Long columnId;
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
    private Long createUid;
    /**
     * 更新用户id
     */
    @TableField("update_time")
    private Date updateTime;
    /**
     * 更新用户id
     */
    @TableField("update_uid")
    private Long updateUid;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getColumnId() {
        return columnId;
    }

    public void setColumnId(Long columnId) {
        this.columnId = columnId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    public Integer getReadingNum() {
        return readingNum;
    }

    public void setReadingNum(Integer readingNum) {
        this.readingNum = readingNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateUid() {
        return createUid;
    }

    public void setCreateUid(Long createUid) {
        this.createUid = createUid;
    }

    public Long getUpdateUid() {
        return updateUid;
    }

    public void setUpdateUid(Long updateUid) {
        this.updateUid = updateUid;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getRelateArticleIds() {
        return relateArticleIds;
    }

    public void setRelateArticleIds(String relateArticleIds) {
        this.relateArticleIds = relateArticleIds;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }

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
