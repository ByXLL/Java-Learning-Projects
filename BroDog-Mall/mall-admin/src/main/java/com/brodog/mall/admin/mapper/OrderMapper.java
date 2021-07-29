package com.brodog.mall.admin.mapper;

import com.brodog.mall.admin.vo.order.OrderVO;
import com.brodog.mall.common.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author By-Lin
 * @since 2021-06-13
 */
@Repository
public interface OrderMapper extends IPageInterface<Order, OrderVO> {

}
