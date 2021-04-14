package com.example.phone_store_api.controller;

import com.example.phone_store_api.dto.OrderDTO;
import com.example.phone_store_api.exception.GlobalException;
import com.example.phone_store_api.form.OrderForm;
import com.example.phone_store_api.service.impl.OrderService;
import com.example.phone_store_api.utils.ApiResultUtil;
import com.example.phone_store_api.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 订单
 * @author By-Lin
 */

@Slf4j
@ResponseBody
@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public ResultVO create(@Valid @RequestBody OrderForm orderForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【创建订单】参数错误,orderForm={}",orderForm);
            throw new GlobalException(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getTel());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setSpecsId(orderForm.getSpecsId());
        orderDTO.setGoodsQuantity(orderForm.getQuantity());

        OrderDTO result = orderService.create(orderDTO);

        Map<String,String> map = new HashMap<>(16);
        map.put("orderId",result.getOrderId());

        return ApiResultUtil.success(map);
    }

    @GetMapping("/detail/{orderId}")
    public ResultVO findOrederDetail(
            @PathVariable("orderId") String orderId){
        return ApiResultUtil.success(orderService.findOrderDetailByOrderId(orderId));
    }

    @PutMapping("/pay/{orderId}")
    public ResultVO pay(
            @PathVariable("orderId") String orderId){
        Map<String,String> map = new HashMap<>(16);
        map.put("orderId",orderService.pay(orderId));
        return ApiResultUtil.success(map);
    }
}
