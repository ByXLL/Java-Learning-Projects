package com.example.mall.dao;

import com.example.mall.dto.order.OrderAddDto;
import com.example.mall.dto.order.OrderEditDto;
import com.example.mall.dto.order.OrderSelectDto;
import com.example.mall.dto.order.OrderStatusDto;
import com.example.mall.entity.Order;
import com.example.mall.vo.OrderDetailVO;
import com.example.mall.vo.OrderGoodsVO;
import com.example.mall.vo.OrderVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 订单 mapper 接口
 * @author By-Lin
 */
@Mapper
public interface OrderMapper {
    /**
     * 添加订单
     * @param order     订单实体
     * @return          影响行数
     */
    int insertOrder(Order order);

    /**
     * 取消订单
     * @param orderNumber           订单编号
     * @return                      影响行数
     */
    int deleteOrder(String orderNumber);

    /**
     * 修改订单状态
     * @param orderStatusDto        订单状态dto
     * @return                      影响行数
     */
    int updateOrderStatus(OrderStatusDto orderStatusDto);

    /**
     * 修改订单信息
     * @param orderEditDto      修改订单 dto
     * @return              影响行数
     */
    int updateOrder(OrderEditDto orderEditDto);

    /**
     * 支付订单
     * @param orderNumber       订单编号
     * @return                  影响行数
     */
    int payOrder(String orderNumber);

    /**
     * 查询订单 集合
     * @param orderSelectDto        订单查询 dto
     * @return                      订单实体 list
     */
    List<OrderDetailVO> selectOrder(OrderSelectDto orderSelectDto);



    /**
     * 通过 订单编号查询 订单
     * @param orderNumber       订单编号
     * @return                  订单实体
     */
    OrderVO selectOrderByOrderNumber(String orderNumber);

}
