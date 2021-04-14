package com.example.phone_store_api.service;

import com.example.phone_store_api.dto.OrderDTO;
import com.example.phone_store_api.vo.order.OrderDetailVO;

/**
 * 订单 service 接口
 * @author By-Lin
 */
public interface OrderServiceInterface {
    /**
     * 创建订单
     * @param orderDTO      订单dto
     * @return              订单tdo
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 获取订单详情
     * @param orderId       订单id
     * @return              订单详情 vo
     */
    OrderDetailVO findOrderDetailByOrderId(String orderId);

    /**
     * 支付
     * @param orderId       订单id
     * @return              订单id
     */
    String pay(String orderId);
}
