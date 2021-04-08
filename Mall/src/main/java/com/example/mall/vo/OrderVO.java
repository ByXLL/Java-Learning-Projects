package com.example.mall.vo;

import com.example.mall.entity.Order;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单 vo
 * @author By-Lin
 */
@Data
public class OrderVO {
    private String orderNumber;
    private Integer userId;
    private String consignee;
    private String userAddress;
    private String userPhone;
    private BigDecimal totalPrice;
    private Integer status;
    private Date payTime;
    private Date createTime;
}
