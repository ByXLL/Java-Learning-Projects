package com.brodog.mall.app.controller;


import com.brodog.mall.app.form.order.OrderAddForm;
import com.brodog.mall.app.form.order.OrderSelectParam;
import com.brodog.mall.app.service.impl.OrderServiceImpl;
import com.brodog.mall.common.entity.ApiResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author By-Lin
 * @since 2021-06-20
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderServiceImpl orderService;

    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/add")
    public ApiResult addOrder(@Valid @RequestBody OrderAddForm orderAddForm) {
        return orderService.addOrder(orderAddForm);
    }

    @PostMapping("/payment")
    public ApiResult payment(@PathParam("orderNumber") Long orderNumber) {
        return orderService.payment(orderNumber);
    }

    @PostMapping("/cancelOrder")
    public ApiResult cancelOrder(@PathParam("orderNumber") Long orderNumber) {
        return orderService.cancelOrderByOrderNumber(orderNumber);
    }

    @PostMapping("/afterSale")
    public ApiResult afterSale(@PathParam("orderNumber") Long orderNumber) {
        return orderService.afterSaleByOrderNumber(orderNumber);
    }

    @GetMapping("/getByOrderNumber")
    public ApiResult findByOrderNumber(@PathParam("orderNumber") Long orderNumber) {
        return orderService.findByOrderNumber(orderNumber);
    }

    @GetMapping("/getListByParam")
    public ApiResult findListByParam(OrderSelectParam param) {
        return orderService.findListByParam(param);
    }
}

