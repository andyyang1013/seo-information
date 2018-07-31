package com.yxy.dch.seo.information.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息临时表，为了接收历史数据
 *
 * @author yangzhen
 */
@Data
@TableName("t_user_temp")
public class UserTemp extends Model<UserTemp> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户名/账号
     */
    private String account;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 密码
     */
    @TableField("pwd")
    private String password;
    /**
     * 加密盐，只对新账号有效
     */
    private String salt;
    /**
     * 子公司标识
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
     * 真实姓名
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

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
