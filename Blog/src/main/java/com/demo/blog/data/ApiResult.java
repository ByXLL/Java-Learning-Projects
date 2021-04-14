package com.demo.blog.data;

/**
 * 全局 api 返回数据格式 基类
 * @author By-Lin
 */
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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
