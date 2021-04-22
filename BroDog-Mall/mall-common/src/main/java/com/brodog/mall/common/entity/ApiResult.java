package com.brodog.mall.common.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 全局响应数据格式对象
 * @author By-Lin
 */
@Getter
@Setter
public class ApiResult {
    private Integer code;
    private String msg;
    private Object data;
    private Boolean status;



    public ApiResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ApiResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ApiResult(Integer code, String msg, Object data, Boolean status) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.status = status;
    }

    public ApiResult(Integer code, String msg, Boolean status) {
        this.code = code;
        this.msg = msg;
        this.status = status;
    }

    public ApiResult(String msg, Boolean status) {
        this.msg = msg;
        this.status = status;
    }

    public ApiResult(Integer code, Boolean status) {
        this.code = code;
        this.status = status;
    }
}
