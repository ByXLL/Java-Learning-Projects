package com.example.phone_store_api.vo;

import lombok.Data;

/**
 * 统一Json 响应数据
 * @author By-Lin
 */
@Data
public class ResultVO<T> {
    private Integer code;
    private String msg;
    private T data;
}
