package com.example.phone_store_api.service.impl;

import com.example.phone_store_api.dto.OrderDTO;
import com.example.phone_store_api.entity.GoodsInfo;
import com.example.phone_store_api.entity.GoodsSpecs;
import com.example.phone_store_api.entity.OrderMaster;
import com.example.phone_store_api.enums.PayStatusEnum;
import com.example.phone_store_api.enums.ResultEnum;
import com.example.phone_store_api.exception.GlobalException;
import com.example.phone_store_api.repository.GoodsInfoRepository;
import com.example.phone_store_api.repository.GoodsSpecsRepository;
import com.example.phone_store_api.repository.OrderMasterRepository;
import com.example.phone_store_api.service.OrderServiceInterface;
import com.example.phone_store_api.utils.CommUtils;
import com.example.phone_store_api.vo.order.OrderDetailVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 订单 service 实现类
 * @author By-Lin
 */
@Service
@Slf4j
public class OrderService implements OrderServiceInterface {
    private final OrderMasterRepository orderMasterRepository;
    private final GoodsSpecsRepository goodsSpecsRepository;
    private final GoodsInfoRepository goodsInfoRepository;
    private final GoodsService goodsService;

    public OrderService(OrderMasterRepository orderMasterRepository, GoodsSpecsRepository goodsSpecsRepository, GoodsInfoRepository goodsInfoRepository, GoodsService goodsService) {
        this.orderMasterRepository = orderMasterRepository;
        this.goodsSpecsRepository = goodsSpecsRepository;
        this.goodsInfoRepository = goodsInfoRepository;
        this.goodsService = goodsService;
    }

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        OrderMaster orderMaster = new OrderMaster();
        GoodsSpecs goodsSpecs = goodsSpecsRepository.findById(orderDTO.getSpecsId()).orElse(null);
        if(goodsSpecs == null) {throw new GlobalException(ResultEnum.GOODS_SPECS_NULL_ERROR); }
        GoodsInfo goodsInfo = goodsInfoRepository.findById(goodsSpecs.getGoodsId()).orElse(null);
        if(goodsInfo == null) { throw new GlobalException(ResultEnum.GOODS_NULL_ERROR); }
        BeanUtils.copyProperties(orderDTO,orderMaster);
        BeanUtils.copyProperties(goodsSpecs,orderMaster);
        BeanUtils.copyProperties(goodsInfo,orderMaster);

        // 计算总价
        BigDecimal orderAmount = new BigDecimal(0);
        // 这里的除法 会出现 无限循环的小数 按照正常来说 需要去 保留多少位小数点
        orderAmount = goodsSpecs.getSpecsPrice()
                    .divide(new BigDecimal(100))
                    .multiply(new BigDecimal(orderDTO.getGoodsQuantity()))
                    .add(orderAmount).add(new BigDecimal(10));
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderId(CommUtils.createUniqueKey());
        orderMaster.setPayStatus(PayStatusEnum.UNPAID.getCode());
        orderDTO.setOrderId(orderMaster.getOrderId());

        // 保存订单
        orderMasterRepository.save(orderMaster);

        // 减库存
        goodsService.subStock(orderDTO.getSpecsId(), orderDTO.getGoodsQuantity());
        return orderDTO;
    }

    @Override
    public OrderDetailVO findOrderDetailByOrderId(String orderId) {
        OrderDetailVO orderDetailVO = new OrderDetailVO();
        OrderMaster orderMaster = orderMasterRepository.findById(orderId).orElse(null);
        if(orderMaster == null) {throw new IllegalArgumentException("订单不存在"); }

        BeanUtils.copyProperties(orderMaster,orderDetailVO);
        orderDetailVO.setSpecsPrice(orderMaster.getSpecsPrice().divide(new BigDecimal(100))+".00");
        return orderDetailVO;
    }

    @Override
    public String pay(String orderId) {
        OrderMaster orderMaster = orderMasterRepository.findById(orderId).orElse(null);
        if(orderMaster == null) {
            log.error("【支付异常 订单不存在】 orderMaster={}",orderMaster);
            throw new IllegalArgumentException("订单不存在");
        }
        // 已支付
        if(orderMaster.getPayStatus().equals(PayStatusEnum.PAID.getCode())) {
            log.error("【支付异常 订单已支付】 orderMaster={}",orderMaster);
            throw new IllegalArgumentException("订单已支付");
        }
        orderMaster.setPayStatus(PayStatusEnum.PAID.getCode());
        orderMasterRepository.save(orderMaster);
        return orderId;
    }
}
