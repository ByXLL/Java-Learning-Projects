package com.brodog.mall.admin.mapper;

import com.brodog.mall.admin.vo.order.OrderOperateHistoryVO;
import com.brodog.mall.common.entity.OrderOperateHistory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 订单操作记录表
 Mapper 接口
 * </p>
 *
 * @author By-Lin
 * @since 2021-06-13
 */
@Repository
public interface OrderOperateHistoryMapper extends BaseMapper<OrderOperateHistory> {

    /**
     * 通过订单id 获取订单操作记录
     * @param orderId           订单id
     * @return                  订单操作记录 vo 集合
     */
    List<OrderOperateHistoryVO> selectListByOrderId(Long orderId);
}
