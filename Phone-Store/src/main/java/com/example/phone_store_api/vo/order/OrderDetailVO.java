package com.example.phone_store_api.vo.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 订单详情 vo
 * @author By-Lin
 */
@Data
public class OrderDetailVO {
    private String orderId;
    private String buyerName;

    @JsonProperty("tel")
    private String buyerPhone;

    @JsonProperty("address")
    private String buyerAddress;

    @JsonProperty("number")
    private Integer goodsQuantity;
    private String goodsName;

    @JsonProperty("specs")
    private String specsName;

    @JsonProperty("price")
    private String specsPrice;

    @JsonProperty("ico")
    private String goodsIcon;

    @JsonProperty("amount")
    private BigDecimal orderAmount;
    private Integer payStatus;
    private Integer freight = 10;
}
