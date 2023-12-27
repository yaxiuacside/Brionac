package com.brionac.config;

import com.brionac.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 亚修的小破机
 * Description:
 * ClassName: WebConfig
 * date: 2023/12/24
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //放行白名单
        String[] patterns =
                {"/favicon.ico",
                "/doc.html",
                "/webjars/**",
                "/**/v2/api-docs-ext",
                "/swagger-resources",
                "/**/v2/api-docs",
                "/swagger-ui.html",
                "/swagger-resources/configuration/ui",
                "/swagger-resources/configuration/security",
                "/**/v3/api-docs",
                "/**/v3/api-docs/swagger-config",
                "/**/v3/api-docs/**",
                "/swagger-ui/index.html",
                "/**/login",
                "/**/register",
                "/customer/product/**"
                };

        //完成拦截器的注册
        registry.addInterceptor(new LoginInterceptor()).
                //拦截所有请求
                addPathPatterns("/**")
                //不拦截路由
                .excludePathPatterns(patterns);

    }

}
