package com.yxy.dch.seo.information.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 账户扩展信息表
 *
 * @author yangzhen
 */
@Data
@TableName("t_user_info")
public class UserInfo extends Model<UserInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;
    /**
     * 用户昵称
     */
    @TableField("nick_name")
    private String nickName;
    /**
     * 性别,0 保密1 男 2 女 默认为0
     */
    private Integer sex;
    /**
     * 头像url地址
     */
    private String image;
    /**
     * 真实姓名,为了应对dba脚本检查，直接改映射
     */
    @TableField("true_name")
    private String name;
    /**
     * 身份证号
     */
    @TableField("id_number")
    private String idNumber;
    /**
     * 身份证号验证状态,0 未验证 1已验证 默认 0
     */
    @TableField("id_number_state")
    private Integer idNumberState;
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
