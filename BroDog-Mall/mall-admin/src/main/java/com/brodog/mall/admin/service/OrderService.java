package com.brodog.mall.admin.service;

import com.brodog.mall.admin.dto.order.EditShipStatusDto;
import com.brodog.mall.admin.form.order.OrderSelectParam;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author By-Lin
 * @since 2021-06-13
 */
public interface OrderService extends IService<Order> {
    /**
     *  订单 条件分页查询
     * @param param         订单查询参数
     * @return              响应数据
     */
    ApiResult selectByParam(OrderSelectParam param);

    /**
     * 通过订单id 获订单信息
     * @param orderId       订单id
     * @return              响应数据
     */
    ApiResult selectByOrderId(Long orderId);

    /**
     * 通过订单编号获取订单信息
     * @param orderNumber       订单编号
     * @return                  响应数据
     */
    ApiResult selectByOrderNumber(Long orderNumber);

    /**
     * 通过订单编号 获订单详细信息
     * @param orderNumber       订单编号
     * @return                  响应数据
     */
    ApiResult selectGoodsDetailByOrderNumber(Long orderNumber);

    /**
     * 发货操作
     * @param editShipStatusDto     订单发货物流信息 dto
     * @return                      响应数据
     */
    ApiResult editShipStatus(EditShipStatusDto editShipStatusDto);

}
