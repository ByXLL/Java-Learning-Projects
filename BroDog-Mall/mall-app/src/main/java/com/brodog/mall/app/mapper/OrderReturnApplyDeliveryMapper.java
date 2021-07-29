package com.brodog.mall.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.brodog.mall.app.vo.order.OrderReturnApplyDeliveryVO;
import com.brodog.mall.common.entity.OrderReturnApplyDelivery;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 订单回退商品物流表 Mapper 接口
 * </p>
 *
 * @author By-Lin
 * @since 2021-06-20
 */
@Repository
public interface OrderReturnApplyDeliveryMapper extends IPageInterface<OrderReturnApplyDelivery, OrderReturnApplyDeliveryVO> {

}
