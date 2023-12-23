package com.brionac.entity.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
@Schema(name = "用户注册登录信息request",description = "用户注册登录信息request")
public class UserLoginRequest {

    /**
     * 用户账号
     */
    @Schema(description = "用户账户")
    @NotBlank
    private String accountNumber;


    /**
     * 用户密码
     */
    @Schema(description = "用户密码")
    @NotBlank
    private String password;

}