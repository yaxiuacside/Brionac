package com.brionac.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brionac.constants.RoleEnum;
import com.brionac.entity.domain.Store;
import com.brionac.entity.domain.User;
import com.brionac.entity.domain.UserRole;
import com.brionac.entity.requests.UserLoginRequest;
import com.brionac.entity.requests.UserUpdateRequest;
import com.brionac.mapper.UserRoleMapper;
import com.brionac.service.RoleService;
import com.brionac.service.StoreService;
import com.brionac.service.UserService;
import com.brionac.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static com.brionac.constants.Common.*;
import static com.brionac.utils.CommonUtil.getNullPropertyNames;

/**
* @author 亚修的小破机
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2023-12-23 01:07:09
*/
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRoleMapper userRoleMapper;

    @Autowired
    RoleService roleService;

    @Autowired
    StoreService storeService;

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
    public User login(UserLoginRequest userLoginRequest, HttpServletRequest request) {
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
        log.info("登录成功, 用户信息注入session: "+user);
        request.getSession().setAttribute(USER_SESSION_KEY,user);

        List<String> roles = roleService.getRole(user.getUserId());

        if(CollectionUtil.contains(roles, RoleEnum.Shop.getRoleName())){

            Store store = storeService.detail(user.getUserId());
            log.info("登录用户为店铺, 店铺信息注入session: "+store);
            request.getSession().setAttribute(STORE_SESSION_KEY,store);

        }
        //身份注入
        request.getSession().setAttribute(USER_ROLE, roles);

        return user;
    }


    @Override
    public Page<User> customerList() {
        Page<User> userPage = new Page<>();

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.inSql(User::getUserId, "SELECT user_id FROM user_role WHERE role_id = 4"); // 查询角色为顾客的用户

        Page<User> page = this.page(userPage,queryWrapper);
        return page;
    }

    @Override
    public User customerDetail(String id) {

        return this.getById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean customerDelete(String id) {
        //删除user_role表中的信息
        userRoleMapper.delete(Wrappers.<UserRole>lambdaQuery().eq(UserRole::getUserId, Integer.getInteger(id)));

        // 删除用户表中的数据
        boolean result = this.removeById(id);
        return result;
    }

    @Override
    public User updateBasicInfo(UserUpdateRequest userUpdateRequest, HttpServletRequest request) {
        // 获取当前登录用户
        User loginUser = (User)request.getSession().getAttribute(USER_SESSION_KEY);
        String originPwd = userUpdateRequest.getPassword();
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT+originPwd).getBytes());

        userUpdateRequest.setPassword(encryptPassword);

        BeanUtil.copyProperties(userUpdateRequest, loginUser,getNullPropertyNames(userUpdateRequest));

        this.updateById(loginUser);

        return loginUser;
    }
}




