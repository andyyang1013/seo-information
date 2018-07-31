package com.yxy.dch.seo.information.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户账号绑定关系表
 *
 * @author yangzhen
 */
@Data
@TableName("t_user_bind_relation")
public class UserBindRelation extends Model<UserBindRelation> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;
    /**
     * 当前用户id
     */
    @TableField("user_id")
    private String userId;
    /**
     * 绑定的用户id集合，中间用逗号分隔
     */
    @TableField("bind_user_ids")
    private String bindUserIds;
    /**
     * 删除状态，0 未删除 1 已删除 默认 0
     */
    @TableField("del_flag")
    private Integer delFlag;
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
