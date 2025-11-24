package com.ly.weblog.web.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author: 骆洋
 * @date: 2025/11/24 10:20
 * @description: Knife4jConfig
// **/
@Configuration
@Profile("dev") // 只在dev 环境中开启
public class OpenApiConfig {
    @Bean
    public GroupedOpenApi webApi(){
return GroupedOpenApi.builder()
        .group("Web 前台接口")
        .packagesToScan("com.ly.weblog.web.controller")
        .pathsToMatch("/**")
        .build();
    }


    public OpenAPI weblogOpenApi(){
        return  new OpenAPI()
                .info(new Info()
                        .title("Weblog 博客前台接口文档")
                        .description("Weblog是一款由 Spring Boot+ Vue 3.2 + Vite 4.3 开发的前后端分离博客。")
                        .version("1.0")
                        .contact(new Contact()
                                .name("骆洋")
                                .url("799014986@qq.com")
                                .email("799014986@qq.com")
                        )
                );
    }
}
