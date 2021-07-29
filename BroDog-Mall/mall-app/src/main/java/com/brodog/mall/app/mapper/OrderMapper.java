package com.brodog.mall.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.brodog.mall.app.vo.order.OrderVO;
import com.brodog.mall.common.entity.Order;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author By-Lin
 * @since 2021-06-20
 */
@Repository
public interface OrderMapper extends IPageInterface<Order, OrderVO> {

}
