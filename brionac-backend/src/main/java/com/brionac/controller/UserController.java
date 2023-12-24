package com.brionac.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brionac.common.PageResult;
import com.brionac.common.Result;
import com.brionac.entity.domain.User;
import com.brionac.entity.requests.UserLoginRequest;
import com.brionac.entity.requests.UserUpdateRequest;
import com.brionac.service.UserService;
import com.brionac.utils.PageResultUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.brionac.common.common.USER_SESSION_KEY;

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
    public Result<?> login(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request){
        User user = userService.login(userLoginRequest,request);
        return Result.success(user);
    }

    @Operation(summary = "用户退出",description = "当前登录用户退出")
    @GetMapping("/logout")
    public Result<?> logout(HttpServletRequest request){
        request.getSession().removeAttribute(USER_SESSION_KEY);
        return Result.success("退出成功");
    }

    //顾客管理
    @Operation(summary = "顾客列表",description = "查询出全部顾客",tags = "运行商顾客管理")
    @GetMapping("/customer/list")
    public Result<PageResult> customerList(){

        Page<User> page = userService.customerList();

        PageResult<Object> pageResult = new PageResult<>();
        BeanUtil.copyProperties(page,pageResult);
        return Result.success(pageResult);
    }

    @Operation(summary = "顾客列表 - 过滤",description = "根据用户姓名过滤",tags = "运行商顾客管理")
    @GetMapping("/customer/list/filter")
    public Result<PageResult<User>> findPage(@RequestParam(name = "当前页",defaultValue = "1") Integer pageNum,
                              @RequestParam(name = "每页页数",defaultValue = "10") Integer pageSize,
                              @RequestParam(name = "用户名",defaultValue = "") String userNameSearch) {
        //新建分页对象
        Page<User> page = new Page<>(pageNum, pageSize);
        //新建模糊查询对象,这里有个注意事项，你模糊项查询的对应项不能为null，为null就查不出来
        LambdaQueryWrapper<User> queryWrapper = Wrappers.lambdaQuery();
        if (!userNameSearch.isEmpty())
            queryWrapper.like(User::getUserName,userNameSearch);
        Page<User> userPage = userService.page(page, queryWrapper);

        return Result.success(PageResultUtil.getPageResult(userPage));
    }

    @Operation(summary = "顾客详情",description = "根据顾客id查询顾客详情",tags = "运行商顾客管理")
    @Parameter(name = "id",description = "用户id",in = ParameterIn.PATH)
    @GetMapping("/customer/{id}")
    public Result<User> customerDetail(@PathVariable("id") String id){
        User user = userService.customerDetail(id);
        return Result.success(user);
    }

    @Operation(summary = "顾客删除",description = "根据顾客id删除顾客",tags = "运行商顾客管理")
    @Parameter(name = "id",description = "用户id",in = ParameterIn.PATH)
    @DeleteMapping("/customer/{id}")
    public Result<?> customerDelete(@PathVariable("id") String id){
        userService.customerDelete(id);
        return Result.success();
    }
    //顾客管理 end


    //个人管理
    @Operation(summary = "查询当前登录用户",description = "查询当前登录用户",tags = "个人管理")
    @GetMapping("/current")
    public Result<?> current(HttpServletRequest request){
        return Result.success(request.getSession().getAttribute(USER_SESSION_KEY));
    }

    @Operation(summary = "当前登录用户基本信息修改",description = "当前登录用户基本信息修改",tags = "个人管理")
    @PutMapping
    public Result<?> update(@RequestBody UserUpdateRequest userUpdateRequest, HttpServletRequest request){
        userService.updateBasicInfo(userUpdateRequest,request);
        return Result.success();
    }



}