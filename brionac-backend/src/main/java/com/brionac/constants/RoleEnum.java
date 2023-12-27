package com.brionac.constants;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 亚修的小破机
 * Description:
 * ClassName: RoleEnum
 * date: 2023/12/27
 */

@Getter
public enum RoleEnum {

    Developers("1", "开发者"),
    //运营商
    Operator("2", "运营商"),
    //店铺
    Shop("3", "店铺"),
    //顾客
    Customer("4", "顾客"),
    //一般浏览者
    Visitor("5", "浏览者");


    String roleId;
    String roleName;
    RoleEnum(String roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

}
