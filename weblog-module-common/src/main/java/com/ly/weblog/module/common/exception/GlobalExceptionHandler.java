package com.ly.weblog.module.common.exception;

import com.ly.weblog.module.common.enums.ResponseCodeEnum;
import com.ly.weblog.module.common.utils.Response;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: 骆洋
 * @date: 2025/11/23 17:26
 * @description: 全局异常处理
 **/
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 捕获自定义异常类
     * @return
     */
    @ExceptionHandler({BizException.class})
    @ResponseBody
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
    @ResponseBody
    public Response<Object> handleOtherException(HttpServletRequest request,Exception e){
log.error("{} request error,",request.getRequestURI(),e);
return Response.fail(ResponseCodeEnum.SYSTEM_ERROR);
    }
}
