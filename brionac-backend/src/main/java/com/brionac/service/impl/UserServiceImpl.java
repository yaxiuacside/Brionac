package com.brionac.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brionac.entity.domain.User;
import com.brionac.entity.requests.UserLoginRequest;
import com.brionac.service.UserService;
import com.brionac.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import static com.brionac.common.common.SALT;

/**
* @author 亚修的小破机
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2023-12-23 01:07:09
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{



    @Override
    public boolean register(UserLoginRequest userLoginRequest) {
        User user = new User();

        String originPwd = userLoginRequest.getPassword();
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT+originPwd).getBytes());

        BeanUtil.copyProperties(userLoginRequest,user);
        user.setPassword(encryptPassword);
        User res = this.getOne(Wrappers.<User>lambdaQuery().eq(User::getAccountNumber, user.getAccountNumber()));
        if (res == null){
            this.save(user);
            return true;
        }
        return false;
    }

    @Override
    public User login(UserLoginRequest userLoginRequest) {
        User user = new User();

        String originPwd = userLoginRequest.getPassword();
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT+originPwd).getBytes());

        BeanUtil.copyProperties(userLoginRequest,user);
        user.setPassword(encryptPassword);
        user = this.getOne(Wrappers.<User>lambdaQuery()
                .eq(User::getAccountNumber, user.getAccountNumber())
                .eq(User::getPassword, user.getPassword())
        );
        if(ObjectUtil.isNull(user)){
            throw new RuntimeException("用户名或密码错误");
        }
        return user;
    }
}




