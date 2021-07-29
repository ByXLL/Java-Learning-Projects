package com.brodog.mall.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.brodog.mall.app.vo.order.OrderOperateHistoryVO;
import com.brodog.mall.common.entity.OrderOperateHistory;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 订单操作记录表
 Mapper 接口
 * </p>
 *
 * @author By-Lin
 * @since 2021-06-20
 */
@Repository
public interface OrderOperateHistoryMapper extends IPageInterface<OrderOperateHistory, OrderOperateHistoryVO> {

}
