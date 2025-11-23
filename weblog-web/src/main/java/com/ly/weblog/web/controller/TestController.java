package com.ly.weblog.web.controller;

import com.ly.weblog.module.common.aspect.ApiOperationLog;
import com.ly.weblog.module.common.enums.ResponseCodeEnum;
import com.ly.weblog.module.common.exception.BizException;
import com.ly.weblog.module.common.utils.Response;
import com.ly.weblog.web.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

/**
 * @author: 骆洋
 * @date: 2025/11/22 15:06
 * @description: TestController
 **/
@RestController
@Slf4j
public class TestController {
    @PostMapping("/test")
    // 测试日志
    @ApiOperationLog(description = "测试接口")
    public Response test(@RequestBody @Validated User user) {

        return Response.success(user);
    }
}
