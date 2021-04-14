package com.example.phone_store_api.dto;

import lombok.Data;

/**
 * 订单 dto
 * @author By-Lin
 */
@Data
public class OrderDTO {
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private Integer specsId;
    private Integer goodsQuantity;
}
