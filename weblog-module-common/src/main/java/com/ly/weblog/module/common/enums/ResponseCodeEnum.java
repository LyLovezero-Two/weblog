package com.ly.weblog.module.common.enums;

import com.ly.weblog.module.common.exception.BaseExceptionInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: 骆洋
 * @date: 2025/11/23 17:04
 * @description: 响应异常码
 **/
@Getter
@AllArgsConstructor
public enum ResponseCodeEnum implements BaseExceptionInterface {
//    通用状态异常码
    SYSTEM_ERROR("10000","系统异常"),
    //业务异常状态码
    PRODUCT_NOT_FOUND("20000","该产品不存在(测试使用)"),;
//异常码
    private String errorCode;
    //错误信息
    private String errorMessage;
}
