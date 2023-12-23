package com.brionac.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.brionac.common.Result;
import com.brionac.entity.domain.User;
import com.brionac.entity.requests.UserLoginRequest;
import com.brionac.mapper.UserMapper;
import com.brionac.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@Tag(name = "用户模块")
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @Operation(summary = "注册用户",description = "账号密码注册")
    @PostMapping("/register")
    public Result<?> register(@RequestBody UserLoginRequest userLoginRequest){
        return userService.register(userLoginRequest) ? Result.success() : Result.error("401","用户名已经存在，请重新输入");
    }

    @Operation(summary = "用户登录",description = "账号密码登录")
    @PostMapping("/login")
    public Result<?> login(@RequestBody UserLoginRequest userLoginRequest){
        User user = userService.login(userLoginRequest);
        return Result.success(user);
    }

    @Operation(summary = "创建用户",description = "根据姓名创建用户")
    @GetMapping("/create")
    public Result<String> create(String name){
        return Result.success(name);
    }

    @Operation(summary = "创建用户-createOne",description = "根据姓名创建用户1")
    @PostMapping("/createOne")
    public Result<User> createOne(@RequestBody User user){
        return Result.success(user);
    }


    @Operation(summary = "body请求")
    @Parameter(name = "deviceId",description = "设备id",in = ParameterIn.PATH)
    @PostMapping("/{deviceId}/body")
    public Result<User> bodyRequest(@PathVariable("deviceId") String deviceId, @RequestBody Object object){
        System.out.println("deviceId:"+deviceId);
        System.out.println("body:"+object.toString());
        return Result.success(new User());
    }

}