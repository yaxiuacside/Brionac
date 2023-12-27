package com.brionac.entity.requests;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息修改request
 */
@Data
@Schema(name = "用户信息修改request",description = "用户信息修改request")
public class UserUpdateRequest{

    /**
     * 用户账号
     */
    @Schema(description = "用户账户")
    private String accountNumber;

    /**
     * 用户昵称
     */
    @Schema(description = "用户昵称")
    private String userName;

    /**
     * 用户密码
     */
    @Schema(description = "用户密码")
    private String password;

    /**
     * 用户性别
     */
    @Schema(description = "用户性别")
    private String userSex;

    /**
     * 用户手机号
     */
    @Schema(description = "用户手机号")
    @Length(min = 11,max = 11,message = "手机号格式错误")
    private String telephone;


    /**
     * 个人简介
     */
    @Schema(description = "个人简介")
    private String summary;

    /**
     * 用户地址
     */
    @Schema(description = "用户地址")
    private String userAddress;

    /**
     * 用户头像
     */
    @Schema(description = "用户头像")
    private String avatarUrl;

}