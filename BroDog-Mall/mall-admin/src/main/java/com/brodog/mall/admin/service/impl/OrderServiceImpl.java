package com.brodog.mall.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brodog.mall.admin.dto.order.EditShipStatusDto;
import com.brodog.mall.admin.form.order.OrderSelectParam;
import com.brodog.mall.admin.mapper.*;
import com.brodog.mall.admin.vo.order.OrderDetailVO;
import com.brodog.mall.admin.vo.order.OrderGoodsVO;
import com.brodog.mall.admin.vo.order.OrderOperateHistoryVO;
import com.brodog.mall.admin.vo.order.OrderVO;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.Order;
import com.brodog.mall.admin.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brodog.mall.common.entity.OrderGoods;
import com.brodog.mall.common.enums.HttpCodeEnum;
import com.brodog.mall.common.exception.ArgException;
import com.brodog.mall.common.exception.OperationalException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author By-Lin
 * @since 2021-06-13
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    private final OrderMapper orderMapper;
    private final OrderGoodsMapper orderGoodsMapper;
    private final OrderOperateHistoryMapper orderOperateHistoryMapper;
    private final OrderReturnApplyMapper orderReturnApplyMapper;
    private final OrderReturnApplyDeliveryMapper orderReturnApplyDeliveryMapper;



    public OrderServiceImpl(
        OrderMapper orderMapper,
        OrderGoodsMapper orderGoodsMapper,
        OrderOperateHistoryMapper orderOperateHistoryMapper,
        OrderReturnApplyMapper orderReturnApplyMapper,
        OrderReturnApplyDeliveryMapper orderReturnApplyDeliveryMapper) {
        this.orderMapper = orderMapper;
        this.orderGoodsMapper = orderGoodsMapper;
        this.orderOperateHistoryMapper = orderOperateHistoryMapper;
        this.orderReturnApplyMapper = orderReturnApplyMapper;
        this.orderReturnApplyDeliveryMapper = orderReturnApplyDeliveryMapper;
    }

    @Override
    public ApiResult selectByParam(OrderSelectParam param) {
        QueryWrapper<OrderVO> queryWrapper = new QueryWrapper<>();
        if(param.getOrderNumber() != null) { queryWrapper.eq("",param.getOrderNumber()); }
        if(param.getStatus() != null) { queryWrapper.eq("",param.getStatus()); }
        if(param.getSourceType() != null) { queryWrapper.eq("",param.getSourceType()); }
        if(param.getOrderType() != null) { queryWrapper.eq("",param.getOrderType()); }
        if(param.getPayType() != null) { queryWrapper.eq("",param.getPayType()); }
        if(param.getReceiverPhone() != null) { queryWrapper.eq("",param.getReceiverPhone()); }
        if(param.getReceiverName() != null) { queryWrapper.eq("",param.getReceiverName()); }
        if(param.getCreateTime() != null) { queryWrapper.eq("",param.getCreateTime()); }
        queryWrapper.eq("id_del",0);
        IPage<OrderVO> page = orderMapper.selectMyPage(
                new Page<>(param.getPage(),param.getSize()),
                queryWrapper
        );
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(),page);
    }

    @Override
    public ApiResult selectByOrderId(Long orderId) {
        if(orderId == null) { throw new ArgException(); }
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",orderId).eq("is_del",0);
        Order order = orderMapper.selectOne(queryWrapper);
        if(order == null) { throw new OperationalException("订单不存在"); }
        OrderVO orderVO = new OrderVO();
        BeanUtils.copyProperties(orderVO,order);
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(),orderVO);
    }

    @Override
    public ApiResult selectByOrderNumber(Long orderNumber) {
        if(orderNumber == null) { throw new ArgException(); }
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_number",orderNumber).eq("is_del",0);
        Order order = orderMapper.selectOne(queryWrapper);
        if(order == null) { throw new OperationalException("订单不存在"); }
        OrderVO orderVO = new OrderVO();
        BeanUtils.copyProperties(orderVO,order);
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(),orderVO);
    }

    @Override
    public ApiResult selectGoodsDetailByOrderNumber(Long orderNumber) {
        ApiResult result = selectByOrderNumber(orderNumber);
        OrderVO orderVO = (OrderVO) result.getData();
        List<OrderGoodsVO> orderGoodsVOList = orderGoodsMapper.selectListByOrderNumber(orderVO.getOrderNumber());
        List<OrderOperateHistoryVO> orderOperateHistoryList = orderOperateHistoryMapper.selectListByOrderId(orderVO.getId());
        OrderDetailVO orderDetailVO = new OrderDetailVO();
        BeanUtils.copyProperties(orderVO,orderDetailVO);
        BeanUtils.copyProperties(orderGoodsVOList,orderDetailVO);
        BeanUtils.copyProperties(orderOperateHistoryList,orderDetailVO);
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(), orderDetailVO);
    }

    @Override
    @Transactional
    public ApiResult editShipStatus(EditShipStatusDto editShipStatusDto) {
        Order order = orderMapper.selectOne(new QueryWrapper<Order>().eq("order_number",editShipStatusDto.getOrderNumber()));
        if(order == null) { throw new OperationalException("订单不存在"); }
        order.setDeliveryCompany(editShipStatusDto.getDeliveryCompany());
        order.setDeliverySn(editShipStatusDto.getDeliverySn());
        int row = orderMapper.update(order,new QueryWrapper<Order>().eq("order_number",editShipStatusDto.getOrderNumber()));
        if(row < 1) { throw new OperationalException(); }

        return null;
    }


}
