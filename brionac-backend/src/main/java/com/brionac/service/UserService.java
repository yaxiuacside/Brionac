package com.brionac.service;

import com.brionac.entity.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.brionac.entity.requests.UserLoginRequest;

/**
* @author 亚修的小破机
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2023-12-23 01:07:09
*/
public interface UserService extends IService<User> {

    boolean register(UserLoginRequest userLoginRequest);

    User login(UserLoginRequest userLoginRequest);
}
