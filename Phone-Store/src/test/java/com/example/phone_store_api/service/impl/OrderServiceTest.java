package com.example.phone_store_api.service.impl;

import com.example.phone_store_api.dto.OrderDTO;
import com.example.phone_store_api.vo.order.OrderDetailVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderServiceTest {
    @Autowired
    private OrderService orderService;

    @Test
    void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("狗哥");
        orderDTO.setBuyerPhone("13977777777");
        orderDTO.setBuyerAddress("广西壮族自治区南宁市青秀区民族大道100号");
        orderDTO.setSpecsId(1);
        orderDTO.setGoodsQuantity(1);

        OrderDTO result = orderService.create(orderDTO);
        System.out.println("");
    }

    @Test
    void findOrderDetailByOrderId() {
        OrderDetailVO orderDetailVO = orderService.findOrderDetailByOrderId("1618297033460455933");
        System.out.println("");

    }
}