package com.brodog.mall.app.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.brodog.mall.app.vo.order.OrderGoodsVO;
import com.brodog.mall.common.entity.OrderGoods;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 订单商品表 Mapper 接口
 * </p>
 *
 * @author By-Lin
 * @since 2021-06-20
 */
@Repository
public interface OrderGoodsMapper extends IPageInterface<OrderGoods, OrderGoodsVO> {
    /**
     * 通过订单号获取 订单下的商品vo 集合
     * @param orderNumber       订单编号
     * @return                  商品vo 集合
     */
    List<OrderGoodsVO> selectVoByOrderNumber(Long orderNumber);
}
