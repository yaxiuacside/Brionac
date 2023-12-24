package com.brionac.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.brionac.common.common.USER_SESSION_KEY;

/**定义一个拦截器**/
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("登录拦截器 -- 拦截请求 -- "+ request.getRequestURL());

        // HttpServletRequest对象来获取session对象
        Object obj = request.getSession().getAttribute(USER_SESSION_KEY);
        if(obj==null){
            throw new RuntimeException("请先登录");
        }
        log.info("登录用户 -- >"+obj);
        //请求放行
        return true;
    }

}