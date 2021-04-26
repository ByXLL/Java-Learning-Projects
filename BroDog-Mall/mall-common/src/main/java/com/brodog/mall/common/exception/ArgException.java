package com.brodog.mall.common.exception;

/**
 * 自定义参数异常
 * @author By-Lin
 */
public class ArgException extends IllegalArgumentException {
    public ArgException(String s) {
        super(s);
    }
    public ArgException() {
        super("参数异常");
    }
}
