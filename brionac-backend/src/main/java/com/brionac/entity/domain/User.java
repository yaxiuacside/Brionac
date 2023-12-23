package com.brionac.entity.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 用户表
 * @TableName user
 */
@TableName(value ="user")
@Data
@Schema(name = "用户信息",description = "用户信息表")
public class User implements Serializable {
    /**
     * 用户id
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    @Schema(description = "用户id")
    private Integer userId;

    /**
     * 用户账号
     */
    @TableField(value = "account_number")
    @Schema(description = "用户账户")
    private String accountNumber;

    /**
     * 用户昵称
     */
    @TableField(value = "user_name")
    @Schema(description = "用户昵称")
    private String userName;

    /**
     * 用户密码
     */
    @TableField(value = "password")
    @Schema(description = "用户密码")
    private String password;

    /**
     * 用户性别
     */
    @TableField(value = "user_sex")
    @Schema(description = "用户性别")
    private String userSex;

    /**
     * 用户手机号
     */
    @TableField(value = "telephone")
    @Schema(description = "用户手机号")
    private String telephone;

    /**
     * 注册时间
     */
    @TableField(value = "creat_time")
    @Schema(description = "注册时间")
    private Date creatTime;

    /**
     * 用户状态
     */
    @TableField(value = "user_state")
    @Schema(description = "用户状态")
    private Integer userState;

    /**
     * 个人简介
     */
    @TableField(value = "summary")
    @Schema(description = "个人简介")
    private String summary;

    /**
     * 用户地址
     */
    @TableField(value = "user_address")
    @Schema(description = "用户地址")
    private String userAddress;

    /**
     * 用户头像
     */
    @TableField(value = "avatar_url")
    @Schema(description = "用户头像")
    private String avatarUrl;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", accountNumber=").append(accountNumber);
        sb.append(", userName=").append(userName);
        sb.append(", password=").append(password);
        sb.append(", userSex=").append(userSex);
        sb.append(", telephone=").append(telephone);
        sb.append(", creatTime=").append(creatTime);
        sb.append(", userState=").append(userState);
        sb.append(", summary=").append(summary);
        sb.append(", userAddress=").append(userAddress);
        sb.append(", avatarUrl=").append(avatarUrl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}