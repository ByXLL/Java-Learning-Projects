package com.example.phone_store_api.enums;

import lombok.Getter;

/**
 * 支付状态 枚举类
 * @author By-Lin
 */
@Getter
public enum PayStatusEnum {
    /** 未支付 **/
    UNPAID(0,"未支付"),
    /** 已支付 **/
    PAID(1,"已支付");

    private Integer code;
    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
