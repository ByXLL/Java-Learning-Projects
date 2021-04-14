package com.demo.blog.controller.advice;

import com.demo.blog.data.ApiResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//@ControllerAdvice(annotations = Controller.class)
public class ExceptionAdvice {
    /**
     * 异常处理类
     * ExceptionHandler 处理异常注解
     * 参数 {Exception.class} 代表所有的 Exception
     */
//    @ExceptionHandler({Exception.class})
    public ApiResult handleException(Exception e, HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 当这个方法被执行了 代表捕获到了异常
        e.printStackTrace();
        return new ApiResult(500,"服务器异常",e.getMessage());
    }
}
