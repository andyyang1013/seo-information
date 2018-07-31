package com.yxy.dch.seo.information.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息修改记录表
 *
 * @author yangzhen
 */
@Data
@TableName("t_user_modify_record")
public class UserModifyRecord extends Model<UserModifyRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;
    /**
     * 修改用户id
     */
    @TableField("user_id")
    private String userId;
    /**
     * 原对象内容
     */
    @TableField("resource_content")
    private String resourceContent;
    /**
     * 修改后的内容
     */
    @TableField("modify_content")
    private String modifyContent;
    /**
     * 子公司标识
     */
    @TableField("subsidiary_code")
    private String subsidiaryCode;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 创建用户Id
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

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
