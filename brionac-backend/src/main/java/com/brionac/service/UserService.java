package com.brionac.service;

import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brionac.entity.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.brionac.entity.requests.UserLoginRequest;
import com.brionac.entity.requests.UserUpdateRequest;
import com.brionac.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;

/**
* @author 亚修的小破机
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2023-12-23 01:07:09
*/
public interface UserService extends IService<User> {

    boolean register(UserLoginRequest userLoginRequest);

    User login(UserLoginRequest userLoginRequest, HttpServletRequest request);

    /**
     * 全部顾客
     * @return
     */
    Page<User> customerList();

    /**
     * 顾客详情
     * @param id
     * @return
     */
    User customerDetail(String id);

    /**
     * 删除顾客
     * @param id
     * @return
     */
    boolean customerDelete(String id);

    User updateBasicInfo(UserUpdateRequest userUpdateRequest, HttpServletRequest request);
}
