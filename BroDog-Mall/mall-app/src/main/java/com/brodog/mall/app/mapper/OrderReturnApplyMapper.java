package com.brodog.mall.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.brodog.mall.app.vo.order.OrderReturnApplyVO;
import com.brodog.mall.common.entity.OrderReturnApply;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 订单退货表 Mapper 接口
 * </p>
 *
 * @author By-Lin
 * @since 2021-06-20
 */
@Repository
public interface OrderReturnApplyMapper extends IPageInterface<OrderReturnApply, OrderReturnApplyVO> {

}
