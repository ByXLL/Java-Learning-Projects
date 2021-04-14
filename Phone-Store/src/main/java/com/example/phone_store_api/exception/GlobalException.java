package com.example.phone_store_api.exception;

import com.example.phone_store_api.enums.ResultEnum;

/**
 * service 层 异常处理
 * @author By-Lin
 */
public class GlobalException extends RuntimeException {
    public GlobalException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
    }
    public GlobalException(String error) {
        super(error);
    }
}
