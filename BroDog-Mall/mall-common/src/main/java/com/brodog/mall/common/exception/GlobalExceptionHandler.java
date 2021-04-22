package com.brodog.mall.common.exception;

import com.brodog.mall.common.entity.ApiResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * 全局异常处理
 * @author By-Lin
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    /**
     * 自定义登录异常的处理方法
     * @param request   HttpServletRequest
     * @param e         错误异常对象
     * @return          响应数据
     */
    @ExceptionHandler({LoginException.class})
    public ApiResult loginExceptionHandler(HttpServletRequest request, Exception e){
        return new ApiResult(401,"登录过期，请重新登录");
    }

    @ExceptionHandler({ArgException.class})
    public ApiResult argExceptionHandler(HttpServletRequest request, Exception e) {
        return new ApiResult(400,e.getMessage());
    }

    /**
     * 自定义全局异常的处理方法
     * @param request   HttpServletRequest
     * @param e         错误异常对象
     * @return          响应数据
     */
    @ExceptionHandler({Exception.class})
    public ApiResult exceptionHandler(HttpServletRequest request, Exception e){
        e.printStackTrace();
        return new ApiResult(500,"服务器异常",e.getMessage());
    }

}
