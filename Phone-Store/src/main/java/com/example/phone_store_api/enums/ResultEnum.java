package com.example.phone_store_api.enums;

import lombok.Getter;

/**
 * 返回结果 枚举
 * @author By-Lin
 */
@Getter
public enum ResultEnum {
    /** 库存异常 */
    STOCK_ERROR(0,"库存异常"),
    /** 商品异常 */
    GOODS_NULL_ERROR(0,"商品不存在"),
    GOODS_SPECS_NULL_ERROR(0,"商品规格不存在"),
    /** 参数异常 */
    ARG_ERROR(0,"参数异常");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
