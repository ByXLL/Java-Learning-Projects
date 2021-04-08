package com.example.mall.dao;

import com.example.mall.dto.order.OrderEditDto;
import com.example.mall.dto.order.OrderSelectDto;
import com.example.mall.dto.order.OrderStatusDto;
import com.example.mall.entity.OrderGoods;
import com.example.mall.vo.OrderDetailVO;
import com.example.mall.vo.OrderGoodsVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 订单商品 mapper
 * @author By-Lin
 */
@Mapper
public interface OrderGoodsMapper {
    /**
     * 添加订单
     * @param orderGoods    订单实体
     * @return              影响行数
     */
    int insertOrderGoods(OrderGoods orderGoods);

    /**
     * 通过 订单号 查询订单商品集合
     * @param orderNumber   订单编号
     * @return              订单上皮 vo list
     */
    List<OrderGoodsVO> selectByOrderNumber(String orderNumber);


    /**
     * 通过订单标号 获取订单商品 列表
     * @param orderNumbers      订单编号集合
     * @return                  订单商品详情 list
     */
    List<OrderGoodsVO> selectOrderGoodsByNumber(List<String> orderNumbers);
}

