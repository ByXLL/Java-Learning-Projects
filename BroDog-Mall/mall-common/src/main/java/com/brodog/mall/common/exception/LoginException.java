package com.brodog.mall.common.exception;


/**
 * 自定义 登录异常
 * @author By-Lin
 */
public class LoginException extends RuntimeException{

    public LoginException(String msg) {
        super(msg);
    }

}
