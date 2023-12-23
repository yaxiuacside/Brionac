package com.brionac.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brionac.entity.domain.Role;
import com.brionac.service.RoleService;
import com.brionac.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author 亚修的小破机
* @description 针对表【role(角色表)】的数据库操作Service实现
* @createDate 2023-12-23 01:07:09
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




