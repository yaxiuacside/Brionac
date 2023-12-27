package com.brionac.service;

import com.brionac.entity.domain.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 亚修的小破机
* @description 针对表【role(角色表)】的数据库操作Service
* @createDate 2023-12-23 01:07:09
*/
public interface RoleService extends IService<Role> {


    List<String> getRole(Integer userId);

}
