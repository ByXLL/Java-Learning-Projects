package com.example.mall.controller;

import com.example.mall.annotation.PassTokenRequired;
import com.example.mall.data.ApiResult;
import com.example.mall.dto.order.OrderAddDto;
import com.example.mall.dto.order.OrderEditDto;
import com.example.mall.dto.order.OrderSelectDto;
import com.example.mall.dto.order.OrderStatusDto;
import com.example.mall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * 订单控制器
 * @author By-Lin
 */
@ResponseBody
@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PassTokenRequired
    @PostMapping("/addOrder")
    public ApiResult addOrder(OrderAddDto dto) {
        return orderService.insertOrder(dto);
    }

    @PassTokenRequired
    @PostMapping("/delOrder")
    public ApiResult delOrder(@PathParam("orderNumber") String orderNumber) {
        return orderService.deleteOrder(orderNumber);
    }

    @PassTokenRequired
    @PostMapping("/updateOrderStatus")
    public ApiResult updateOrderStatus(OrderStatusDto dto) {
        return orderService.updateOrderStatus(dto);
    }

    @PassTokenRequired
    @PostMapping("/updateOrder")
    public ApiResult updateOrder(OrderEditDto dto) {
        return orderService.updateOrder(dto);
    }

    @PassTokenRequired
    @PostMapping("/payOrder")
    public ApiResult payOrder(@PathParam("orderNumber") String orderNumber) {
        return orderService.payOrder(orderNumber);
    }

    @PassTokenRequired
    @GetMapping("/getOrder")
    public ApiResult getOrder(@PathParam("orderNumber") String orderNumber) {
        return orderService.selectOrderByOrderNumber(orderNumber);
    }

    @PassTokenRequired
    @GetMapping("/getOrders")
    public ApiResult getOrders(OrderSelectDto dto) {
        return orderService.selectOrder(dto);
    }
}
