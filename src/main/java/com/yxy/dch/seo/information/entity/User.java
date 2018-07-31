package com.yxy.dch.seo.information.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * 账户认证表
 *
 * @author yangzhen
 */
@Data
@TableName("t_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;
    /**
     * 用户基础信息id
     */
    @TableField("user_info_id")
    private String userInfoId;
    /**
     * 用户名/账号
     */
    @Size(max = 50, message = "用户名/账号不能超过20位")
    private String account;
    /**
     * 邮箱
     */
    @Size(max = 50, message = "邮箱不能超过50位")
    @Email(message = "邮箱格式有误")
    private String email;

    /**
     * 手机号
     */
    @Pattern(regexp = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0-9])|(19[0-9]))\\d{8}$", message = "手机号码格式有误")
    private String phone;
    /**
     * 密码
     * 益彩(128)：PBKDF2
     * 一比分：MD5
     * 电竞：sha1+md5
     */
    @Size(max = 128, message = "密码最长128位")
    @TableField("pwd")
    private String password;
    /**
     * 加密盐，只对新账号有效
     */
    private String salt;
    /**
     * 加密类型
     */
    @TableField("encrypt_type")
    private String encryptType;
    /**
     * 子公司标识，注册来源
     */
    @TableField("subsidiary_code")
    private String subsidiaryCode;

    /**
     * 子公司用户id，新注册的和主键保持一致
     */
    @TableField("subsidiary_user_id")
    private String subsidiaryUserId;
    /**
     * 注册时间
     */
    @TableField("reg_time")
    private Date regTime;
    /**
     * 最近登录时间
     */
    @TableField("last_login_time")
    private Date lastLoginTime;
    /**
     * 删除状态，0 未删除 1 已删除 默认 0
     */
    @TableField("del_flag")
    private Integer delFlag;
    /**
     * 创建时间
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @TableField("create_time")
    private Date createTime;
    /**
     * 创建用户Id
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @TableField("create_uid")
    private String createUid;
    /**
     * 更新时间
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @TableField("update_time")
    private Date updateTime;
    /**
     * 更新用户id
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @TableField("update_uid")
    private String updateUid;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "User{" +
                ", id=" + id +
                ", userInfoId=" + userInfoId +
                ", account=" + account +
                ", email=" + email +
                ", phone=" + phone +
                ", password=" + password +
                ", salt=" + salt +
                ", encryptType=" + encryptType +
                ", subsidiaryCode=" + subsidiaryCode +
                ", subsidiaryUserId=" + subsidiaryUserId +
                ", regTime=" + regTime +
                ", lastLoginTime=" + lastLoginTime +
                ", delFlag=" + delFlag +
                ", createTime=" + createTime +
                ", createUid=" + createUid +
                ", updateTime=" + updateTime +
                ", updateUid=" + updateUid +
                "}";
    }
}
