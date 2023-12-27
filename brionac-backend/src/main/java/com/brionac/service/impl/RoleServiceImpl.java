package com.brionac.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brionac.entity.domain.Role;
import com.brionac.entity.domain.UserRole;
import com.brionac.mapper.RoleMapper;
import com.brionac.service.RoleService;
import com.brionac.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
* @author 亚修的小破机
* @description 针对表【role(角色表)】的数据库操作Service实现
* @createDate 2023-12-23 01:07:09
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

    @Autowired
    UserRoleService userRoleService;

    @Override
    public List<String> getRole(Integer userId) {

        List<UserRole> userRoles = userRoleService.list(Wrappers.<UserRole>lambdaQuery().eq(UserRole::getUserId, userId));

        List<Integer> roleIds = userRoles.stream().map(UserRole::getRoleId).collect(Collectors.toList());

        List<Role> roles = this.list(Wrappers.<Role>lambdaQuery().in(Role::getRoleId,roleIds));

        List<String> roleNames = roles.stream().map(Role::getRoleName).collect(Collectors.toList());

        return roleNames;

    }
}




