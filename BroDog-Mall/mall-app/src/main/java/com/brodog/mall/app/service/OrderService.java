package com.brodog.mall.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.brodog.mall.app.form.order.OrderAddForm;
import com.brodog.mall.app.form.order.OrderSelectParam;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.Order;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author By-Lin
 * @since 2021-06-20
 */
public interface OrderService extends IService<Order> {
    /**
     * 添加订单
     * @param orderAddForm      订单添加表单
     * @return                  响应数据
     */
    ApiResult addOrder(OrderAddForm orderAddForm);

    /**
     * 付款
     * @param orderNumber       订单编号
     * @return                  响应数据
     */
    ApiResult payment(Long orderNumber);

    /**
     * 通过订单编号 取消订单
     * @param orderNumber       订单编号
     * @return                  响应数据
     */
    ApiResult cancelOrderByOrderNumber(Long orderNumber);

    /**
     * 通过订单编号 发起售后
     * @param orderNumber       订单编号
     * @return                  响应数据
     */
    ApiResult afterSaleByOrderNumber(Long orderNumber);

    /**
     * 通过订单编号 获取订单详情
     * @param orderNumber       订单编号
     * @return                  响应数据
     */
    ApiResult findByOrderNumber(Long orderNumber);

    /**
     * 通过查询条件  获取订单列表
     * @param param         查询参数
     * @return              响应数据
     */
    ApiResult findListByParam(OrderSelectParam param);

}
