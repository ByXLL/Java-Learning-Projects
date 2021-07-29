package com.brodog.mall.admin.mapper;

import com.brodog.mall.admin.vo.order.OrderGoodsVO;
import com.brodog.mall.common.entity.OrderGoods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 订单商品表 Mapper 接口
 * </p>
 *
 * @author By-Lin
 * @since 2021-06-13
 */
@Repository
public interface OrderGoodsMapper extends BaseMapper<OrderGoods> {
    /**
     * 通过订单编号 获取订单商品集合
     * @param orderNumber       订单编号
     * @return                  订单商品vo 集合
     */
    List<OrderGoodsVO> selectListByOrderNumber(Long orderNumber);
}
