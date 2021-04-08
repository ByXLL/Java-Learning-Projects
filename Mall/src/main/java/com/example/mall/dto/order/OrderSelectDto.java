package com.example.mall.dto.order;


import lombok.Data;

/**
 * 订单选择dto
 * @author By-Lin
 */
@Data
public class OrderSelectDto {
    private String orderNumber;
    private Integer userId;
    private String consignee;
    private String userPhone;
    private Integer status;
}
