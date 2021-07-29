package com.brodog.mall.app.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.brodog.mall.app.vo.order.OrderReturnReasonVO;
import com.brodog.mall.common.entity.OrderReturnReason;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 商品退货理由表 Mapper 接口
 * </p>
 *
 * @author By-Lin
 * @since 2021-06-20
 */
@Repository
public interface OrderReturnReasonMapper extends IPageInterface<OrderReturnReason, OrderReturnReasonVO> {

}
