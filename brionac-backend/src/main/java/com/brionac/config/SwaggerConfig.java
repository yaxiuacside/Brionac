/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.brionac.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 * 创建Swagger配置
 * @since:knife4j-springdoc-openapi-demo 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2020/03/15 20:40
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                // 接口文档标题
                .info(new Info().title("Knife4j OpenApi 3")
                        // 接口文档描述
                        .description("Knife4j OpenApi 3 example application")
                        // 接口文档版本
                        .version("v1.0")
                        // 开发者联系方式
                        .contact(new Contact().name("Flying9001").url("https://github.com/Flying9001")))
                .externalDocs(new ExternalDocumentation()
                        // 额外补充说明
                        .description("Github example code")
                        // 额外补充链接
                        .url("https://github.com/Flying9001/springBootDemo/demo-knife4j-openapi3"));
    }


}
