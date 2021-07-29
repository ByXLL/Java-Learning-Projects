package com.brodog.mall.app.service.impl;

import com.brodog.mall.app.mapper.OrderOperateHistoryMapper;
import com.brodog.mall.app.service.OrderOperateHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brodog.mall.common.entity.OrderOperateHistory;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单操作记录表
 服务实现类
 * </p>
 *
 * @author By-Lin
 * @since 2021-06-20
 */
@Service
public class OrderOperateHistoryServiceImpl extends ServiceImpl<OrderOperateHistoryMapper, OrderOperateHistory> implements OrderOperateHistoryService {

}
