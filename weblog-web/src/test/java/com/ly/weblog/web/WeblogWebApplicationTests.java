package com.ly.weblog.web;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class WeblogWebApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testLog(){
        log.info("这是一行 Info 级别日志");
        log.warn("这是一行 warn 级别日志");
        log.error("这是一行 error 级别日志");

        //占位符
        String author = "洋哥";
        log.info("作者的名字是 {}", author);
    }
}
