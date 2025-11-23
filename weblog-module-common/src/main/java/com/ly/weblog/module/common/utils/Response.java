package com.ly.weblog.module.common.utils;

import com.ly.weblog.module.common.exception.BaseExceptionInterface;
import com.ly.weblog.module.common.exception.BizException;
import lombok.Data;

/**
 * @author: 骆洋
 * @date: 2025/11/23 16:13
 * @description: 响应参数工具类
 **/
@Data
public class Response<T> {
    //是否成功 默认为true
    private boolean success = true;
    //响应信息
    private String message;
    //异常码
    private String errorCode;
    //响应数据
    private T data;

    //成功响应
    public static <T> Response<T> success() {
        Response<T> response = new Response<>();
        return response;
    }

    public static <T> Response<T> success(T data) {
        Response<T> response = new Response<>();
        response.setData(data);
        return response;
    }

    //失败响应
    public static <T> Response<T> fail() {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        return response;
    }

    public static <T> Response<T> fail(String errorMessage) {
        Response<T> response = new Response<>();
        response.setMessage(errorMessage);
        response.setSuccess(false);
        return response;
    }

    public static <T> Response<T> fail(String errorCode, String errorMessage) {
        Response<T> response = new Response<>();
        response.setErrorCode(errorCode);
        response.setMessage(errorMessage);
        response.setSuccess(false);
        return response;
    }

    public static <T> Response<T> fail(BizException bizException) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setErrorCode(bizException.getErrorCode());
        response.setMessage(bizException.getErrorMessage());
        return response;
    }
    public static <T> Response<T> fail(BaseExceptionInterface baseExceptionInterface) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setErrorCode(baseExceptionInterface.getErrorCode());
        response.setMessage(baseExceptionInterface.getErrorMessage());
        return response;
    }
}
