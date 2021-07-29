package com.brodog.mall.admin.vo.order;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 订单详情 vo
 * @author By-Lin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrderDetailVO extends OrderVO {

    @ApiModelProperty(value = "订单商品列表")
    private List<OrderGoodsVO> orderGoodsList;

    @ApiModelProperty(value = "订单操作记录")
    private List<OrderOperateHistoryVO> operateHistoryList;
}
