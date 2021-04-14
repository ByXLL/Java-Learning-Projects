package com.example.mall.vo;

import com.example.mall.entity.Order;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 订单 详情 vo
 * @author By-Lin
 */
@Data
public class OrderDetailVO extends OrderVO {
    private List<OrderGoodsVO> orderGoodsList;
}
