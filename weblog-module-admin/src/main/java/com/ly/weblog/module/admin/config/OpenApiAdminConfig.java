package com.ly.weblog.module.admin.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author: 骆洋
 * @date: 2025/11/24 14:40
 * @description: Knife4j 配置
 **/
@Configuration
@Profile("dev") // 只在dev 环境中开启
public class OpenApiAdminConfig {

    @Bean("adminWebApi")
    public GroupedOpenApi webApi() {
        return GroupedOpenApi.builder()
                .group("Admin 后台接口")
                .packagesToScan("com.ly.weblog.module.admin.controller")
                .pathsToMatch("/**")
                .build();
    }


    public OpenAPI weblogOpenApi(){
        return  new OpenAPI().info(new Info()
                .title("Weblog 博客后台接口文档")
                .description("Weblog是一款 Spring Boot+ Vue 3.2 + Vite 4.3 搭建的后台管理系统。")
                .termsOfService("799014986@qq.com")
                .contact(new Contact()
                                .name("骆洋")
                                .email("799014986@qq.com")
                        )
        );
    }
}
