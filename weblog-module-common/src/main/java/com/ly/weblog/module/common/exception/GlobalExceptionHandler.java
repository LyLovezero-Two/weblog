package com.ly.weblog.module.common.exception;

import com.ly.weblog.module.common.enums.ResponseCodeEnum;
import com.ly.weblog.module.common.utils.Response;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Optional;
import java.util.Scanner;

/**
 * @author: 骆洋
 * @date: 2025/11/23 17:26
 * @description: 全局异常处理
 **/
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 捕获自定义异常类
     * @return
     */
    @ExceptionHandler({BizException.class})
    public Response<Object> handleBizException(HttpServletRequest request,BizException e){
        log.warn("{} request fail,errorCode: {}, errorMessage: {}",request.getRequestURI(),e.getErrorCode(),e.getErrorMessage());
        return Response.fail(e);
    }
    /**
     * 其他类型异常
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler({Exception.class})
    public Response<Object> handleOtherException(HttpServletRequest request,Exception e){
log.error("{} request error,",request.getRequestURI(),e);
return Response.fail(ResponseCodeEnum.SYSTEM_ERROR);
    }
    /**
     * 捕获参数校验异常
     * @return
     */
    @ExceptionHandler({ MethodArgumentNotValidException.class})
public Response<Object> handleMethodArgumentNotValidException(HttpServletRequest request,MethodArgumentNotValidException e){
        // 参数错误异常码
        String errorCode = ResponseCodeEnum.PARAM_NOT_VALID.getErrorCode();
        // 获取 BindingResult
        BindingResult bindingResult = e.getBindingResult();
        StringBuilder sb = new StringBuilder();
        // 获取校验不通过的字段，并组合错误信息，格式为： email 邮箱格式不正确, 当前值: '123124qq.com';
        Optional.ofNullable(bindingResult.getFieldErrors()).ifPresent(errors ->{
errors.forEach(error ->
        sb.append(error.getField())
                .append(" ")
                .append(error.getDefaultMessage())
                .append(",当前值: '")
                .append(error.getRejectedValue())
                .append("'; ")
        );
        });
        String errorMessage = sb.toString();
        log.warn("{} request error, errorCode: {}, errorMessage: {}", request.getRequestURI(), errorCode, errorMessage);
        return Response.fail(errorCode, errorMessage);
    }
}
