package com.brionac.aop;

import java.lang.annotation.*;

/**
 * @author 亚修的小破机
 * Description:
 * ClassName: HasRole
 * date: 2023/12/27
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HasRole {
    String[] value();
}
