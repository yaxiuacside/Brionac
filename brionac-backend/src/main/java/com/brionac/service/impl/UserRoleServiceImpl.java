package com.brionac.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brionac.entity.domain.UserRole;
import com.brionac.service.UserRoleService;
import com.brionac.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

/**
* @author 亚修的小破机
* @description 针对表【user_role(用户角色表)】的数据库操作Service实现
* @createDate 2023-12-23 01:07:09
*/
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole>
    implements UserRoleService{

}




