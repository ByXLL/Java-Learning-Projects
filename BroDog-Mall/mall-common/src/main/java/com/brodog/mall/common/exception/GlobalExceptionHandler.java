package com.brodog.mall.common.exception;

import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.enums.HttpCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;


/**
 * 全局异常处理
 * @author By-Lin
 */
@Slf4j
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
        return new ApiResult(HttpCodeEnum.AUTH_ERROR.getCode(),"登录过期，请重新登录");
    }

    /**
     * 自定义 参数异常 处理方法
     * @param request       HttpServletRequest
     * @param e             错误异常对象
     * @return              响应数据
     */
    @ExceptionHandler({ArgException.class})
    public ApiResult argExceptionHandler(HttpServletRequest request, Exception e) {
        log.error("URL:{} ,参数异常: {}",request.getRequestURI(), e.getMessage());
        return new ApiResult(HttpCodeEnum.ERROR.getCode(),e.getMessage());
    }

    /**
     * 参数类型 转换异常处理方法
     * @param request       HttpServletRequest
     * @param e             错误异常对象
     * @return              响应数据
     */
    @ExceptionHandler({TypeMismatchException.class})
    public ApiResult typeMismatchExceptionHandler(HttpServletRequest request, Exception e){
//        e.printStackTrace();
        log.error("URL:{} ,参数异常,数据转换错误: {}",request.getRequestURI(), e.getMessage());
        return new ApiResult(HttpCodeEnum.ERROR.getCode(),"参数异常,数据转换错误",e.getMessage());
    }

    /**
     * 操作异常 处理方法
     * @param request       HttpServletRequest
     * @param e             错误异常对象
     * @return              响应数据
     */
    @ExceptionHandler({OperationalException.class})
    public ApiResult operationalExceptionHandler(HttpServletRequest request, Exception e){
//        e.printStackTrace();
        log.error("URL:{} ,操作失败: {}",request.getRequestURI(), e.getMessage());
        return new ApiResult(HttpCodeEnum.ERROR.getCode(),"操作失败",e.getMessage());
    }

    /**
     * 参数绑定异常 处理方法
     * @param request       HttpServletRequest
     * @param e             错误异常对象
     * @return              响应数据
     */
    @ExceptionHandler({BindException.class})
    public ApiResult bindExceptionHandler(HttpServletRequest request, BindException e){
//        e.printStackTrace();
        log.error("URL:{} ,参数异常: {}",request.getRequestURI(),  Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
        return new ApiResult(HttpCodeEnum.ERROR.getCode(),"参数异常", Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
    }


    /**
     * 自定义全局异常的处理方法
     * @param request   HttpServletRequest
     * @param e         错误异常对象
     * @return          响应数据
     */
    @ExceptionHandler({Exception.class})
    public ApiResult exceptionHandler(HttpServletRequest request, Exception e){
//        e.printStackTrace();
        log.error("URL:{} ,服务器异常: {}",request.getRequestURI(), e.getMessage());
        return new ApiResult(HttpCodeEnum.ERROR.getCode(),"服务器异常",e.getMessage());
    }

}
