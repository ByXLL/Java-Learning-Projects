package com.demo.blog.controller.handler;

import com.demo.blog.data.ApiResult;
import com.demo.blog.exception.LoginException;
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
public class GlobalExceptionHandler  {
    /**
     * 自定义异常的处理方法
     * @param request   HttpServletRequest
     * @param e         错误异常对象
     * @return          响应数据
     */
    @ExceptionHandler({LoginException.class})
    public ApiResult LoginExceptionHandler(HttpServletRequest request, Exception e){
        return new ApiResult(401,"登录过期，请重新登录");
    }

    /**
     * 自定义异常的处理方法
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
