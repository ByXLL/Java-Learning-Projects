package com.demo.blog.exception;

import com.demo.blog.data.ApiResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.net.BindException;

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
    @ExceptionHandler({Exception.class})
    public ApiResult exceptionHandler(HttpServletRequest request, Exception e){
        e.printStackTrace();
        return new ApiResult(500,"服务器异常",e.getMessage());
    }
}
