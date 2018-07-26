package com.yxy.dch.seo.information.entity;

import lombok.Data;

/**
 * 标签表
 *
 * @author yangzhen
 */
@Data
public class Tag {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Long id;
    /**
     * 标签名称
     */
    private String name;
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

}
