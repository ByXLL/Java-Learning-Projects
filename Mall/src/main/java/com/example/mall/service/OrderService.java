package com.example.mall.service;

import com.example.mall.dao.GoodsCateMapper;
import com.example.mall.dao.GoodsMapper;
import com.example.mall.dao.OrderGoodsMapper;
import com.example.mall.dao.OrderMapper;
import com.example.mall.data.ApiResult;
import com.example.mall.dto.order.OrderAddDto;
import com.example.mall.dto.order.OrderEditDto;
import com.example.mall.dto.order.OrderSelectDto;
import com.example.mall.dto.order.OrderStatusDto;
import com.example.mall.dto.ordergoods.OrderGoodsDto;
import com.example.mall.entity.Order;
import com.example.mall.entity.OrderGoods;
import com.example.mall.utils.CommUtils;
import com.example.mall.utils.Constants;
import com.example.mall.vo.GoodsVO;
import com.example.mall.vo.OrderDetailVO;
import com.example.mall.vo.OrderGoodsVO;
import com.example.mall.vo.OrderVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
 * 订单 service 层
 * @author By-Lin
 */
@Service
public class OrderService implements Constants {
    private final OrderGoodsMapper orderGoodsMapper;
    private final GoodsCateMapper goodsCateMapper;
    private final GoodsMapper goodsMapper;
    private final OrderMapper orderMapper;

    public OrderService(OrderGoodsMapper orderGoodsMapper, GoodsCateMapper goodsCateMapper, GoodsMapper goodsMapper, OrderMapper orderMapper) {
        this.orderGoodsMapper = orderGoodsMapper;
        this.goodsCateMapper = goodsCateMapper;
        this.goodsMapper = goodsMapper;
        this.orderMapper = orderMapper;
    }


    /**
     * 这里 逻辑有问题 一个订单只能包含一个商品
     */

    /**
     * 添加订单
     * @param orderAddDto       订单添加dto
     * @return                  响应数据
     */
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public ApiResult insertOrder(OrderAddDto orderAddDto) {
        if(orderAddDto == null) {
            return new ApiResult(WARNING_CODE,"参数不能为空");
        }
        if(orderAddDto.getUserId() == null) { return new ApiResult(WARNING_CODE,"用户id不能为空"); }
        if(StringUtils.isBlank(orderAddDto.getUserAddress())) { return new ApiResult(WARNING_CODE,"收货地址不能为空"); }
        if(StringUtils.isBlank(orderAddDto.getConsignee())) { return new ApiResult(WARNING_CODE,"收货人不能为空"); }
        if(StringUtils.isBlank(orderAddDto.getUserPhone())) { return new ApiResult(WARNING_CODE,"收货人手机号码不能为空"); }
        if(orderAddDto.getTotalPrice() == null) { return new ApiResult(WARNING_CODE,"订单总价不能为空"); }

        if(orderAddDto.getGoodsId() == null) { return new ApiResult(WARNING_CODE,"商品id不能为空"); }
        if(orderAddDto.getGoodsCount() ==null || orderAddDto.getGoodsCount() < 0 ) { return new ApiResult(WARNING_CODE,"商品个数不能为空"); }

        GoodsVO goods = goodsMapper.selectGoodsById(orderAddDto.getGoodsId());
        if(goods == null ) { return new ApiResult(WARNING_CODE,"当前商品已下架，请重新购买"); }

        String orderNumber = CommUtils.generateUUID();

        // 计算总价
        BigDecimal orderTotalPrice = goods.getGoodsPrice().multiply( new BigDecimal(orderAddDto.getGoodsCount()));
        int checkTotalPrice = orderTotalPrice.compareTo(orderAddDto.getTotalPrice());
        if(checkTotalPrice != 0) { return new ApiResult(WARNING_CODE,"订单总价异常，请重新下单"); }

        // 生成 订单商品 信息
        OrderGoods orderGoods = new OrderGoods();
        orderGoods.setGoodsId(goods.getGoodsId());
        orderGoods.setOrderNumber(orderNumber);
        orderGoods.setGoodsCateName(orderAddDto.getGoodsCateName());
        orderGoods.setGoodsName(orderAddDto.getGoodsName());
        orderGoods.setGoodsCount(orderAddDto.getGoodsCount());
        orderGoods.setGoodsPrice(orderAddDto.getGoodsPrice());

        // 生成 订单 信息
        Order order = new Order();
        order.setOrderNumber(orderNumber);
        order.setUserId(orderAddDto.getUserId());
        order.setConsignee(orderAddDto.getConsignee());
        order.setUserAddress(orderAddDto.getUserAddress());
        order.setUserPhone(orderAddDto.getUserPhone());
        order.setTotalPrice(orderTotalPrice);
        order.setStatus(1);
        order.setCreateTime(new Date());

        int insertOrderResult = orderMapper.insertOrder(order);
        int insertOrderGoodsResult = orderGoodsMapper.insertOrderGoods(orderGoods);
        if(insertOrderGoodsResult >0 && insertOrderResult > 0) {
            Map<String, Object> map = new HashMap<>(16);
            map.put("orderNumber",orderNumber);
            return new ApiResult(SUCCESS_CODE,"创建订单成功",map,true);
        }
        return new ApiResult(ERROR_CODE,"创建订单失败",false);
    }

    /**
     * 取消订单
     * @param orderNumber       订单编号
     * @return                  响应数据
     */
    public ApiResult deleteOrder(String orderNumber) {
        if(StringUtils.isBlank(orderNumber)) { return new ApiResult(WARNING_CODE,"订单编号不能为空");}
        OrderVO order = orderMapper.selectOrderByOrderNumber(orderNumber);
        if(order == null) { return new ApiResult(WARNING_CODE,"当前订单不存在"); }
        int row = orderMapper.deleteOrder(orderNumber);
        if(row > 0) { return new ApiResult(SUCCESS_CODE,"取消成功"); }
        return new ApiResult(WARNING_CODE,"取消订单失败");
    }

    /**
     * 修改订单状态
     * @param dto           订单状态 dto
     * @return              响应数据
     */
    public ApiResult updateOrderStatus(OrderStatusDto dto) {
        if(dto == null) { return new ApiResult(WARNING_CODE,"参数不能为空",false); }
        if(StringUtils.isBlank(dto.getOrderNumber())) { return new ApiResult(WARNING_CODE,"订单编号不能为空",false); }
        if(dto.getStatus() == null) { return new ApiResult(WARNING_CODE,"订单状态不能为空",false); }
        int row = orderMapper.updateOrderStatus(dto);
        if(row > 0) { return new ApiResult(SUCCESS_CODE,"修改成功",true); }
        return new ApiResult(ERROR_CODE,"修改失败",false);
    }

    /**
     * 修改订单信息
     * @param dto       订单编辑 dto
     * @return          响应数据
     */
    public ApiResult updateOrder(OrderEditDto dto) {
        if(dto == null) { return new ApiResult(WARNING_CODE,"参数不能为空"); }
        if(StringUtils.isBlank(dto.getOrderNumber())) { return new ApiResult(WARNING_CODE,"订单编号不能为空"); }
        int row = orderMapper.updateOrder(dto);
        if(row >0) { return new ApiResult(SUCCESS_CODE,"编辑成功"); }
        return new ApiResult(ERROR_CODE,"编辑失败");
    }

    /**
     * 支付
     * @param orderNumber       订单编号
     * @return                  响应数据
     */
    public ApiResult payOrder(String orderNumber) {
        if(StringUtils.isBlank(orderNumber)) { return new ApiResult(WARNING_CODE,"订单编号不能为空",false); }
        OrderVO order = orderMapper.selectOrderByOrderNumber(orderNumber);
        if(order == null) { return new ApiResult(WARNING_CODE,"当前订单不存在",false); }
        int row = orderMapper.payOrder(orderNumber);
        if(row>0) { return new ApiResult(SUCCESS_CODE,"支付成功",true); }
        return new ApiResult(ERROR_CODE,"支付失败");
    }

    /**
     * 通过 订单编号 获取订单详情
     * @param orderNumber       订单编号
     * @return                  响应数据
     */
    public ApiResult selectOrderByOrderNumber(String orderNumber) {
        if(StringUtils.isBlank(orderNumber)) { return new ApiResult(WARNING_CODE,"订单编号不能为空"); }
        OrderVO order = orderMapper.selectOrderByOrderNumber(orderNumber);
        if(order == null) { return new ApiResult(WARNING_CODE,"当前订单不存在"); }

        OrderDetailVO orderDetailVO = toBuildOrderDetailVO(order);
        return new ApiResult(SUCCESS_CODE,"数据获取成功",orderDetailVO);
    }

    /**
     * 查询 订单列表
     * @param dto   订单查询 dto
     * @return      响应数据
     */
    public ApiResult selectOrder(OrderSelectDto dto) {
        if(dto == null) { return new ApiResult(WARNING_CODE,"参数不能为空"); }

        // 获取 符合条件的订单实体集合
        List<OrderDetailVO> orderDetailVOList = orderMapper.selectOrder(dto);
        if(orderDetailVOList.size()>0) {
            List<String> orderNumbers = new ArrayList<>();
            // 获取所有订单的 订单号集合
            for (OrderDetailVO orderDetailVO: orderDetailVOList) {
                orderNumbers.add(orderDetailVO.getOrderNumber());
            }
            // 获取 所有订单里面的所有商品
            List<OrderGoodsVO> orderGoodsVOS = getOrderGoodsByOrderNumbers(orderNumbers);

            // 先循环 订单集合
            for (OrderDetailVO orderDetailVO: orderDetailVOList) {
                // 创建一个 订单商品 集合 用于存放 当前属于当前订单号的商品
                List<OrderGoodsVO> orderGoodsVOList = new ArrayList<>();
                // 遍历所有的订单商品
                for (OrderGoodsVO og: orderGoodsVOS) {
                    // 判断当前的商品的 订单编号 == 当前订单的订单编号
                    if(og.getOrderNumber().equals(orderDetailVO.getOrderNumber())) {
                        // 将商品添加进 订单商品集合
                        orderGoodsVOList.add(og);
                    }
                }
                // 将 过滤出来 订单商品添加到 vo的商品集合属性
                orderDetailVO.setOrderGoodsList(orderGoodsVOList);
            }
        }
        return new ApiResult(SUCCESS_CODE,"数据获取成功",orderDetailVOList);
    }

    /**
     * 通过订单编号集合 获取订单商品集合
     * @param orderNumbers      订单编号集合
     * @return                  订单商品集合
     */
    private List<OrderGoodsVO> getOrderGoodsByOrderNumbers(List<String> orderNumbers) {
        if(orderNumbers.size() >0) {
            return orderGoodsMapper.selectOrderGoodsByNumber(orderNumbers);
        }
        return new ArrayList<>();
    }


    /**
     * 私有方法 构建订单详情vo
     * @param order     订单实体
     * @return          OrderDetailVO
     */
    private OrderDetailVO toBuildOrderDetailVO(OrderVO order) {
        if(order == null) { return new OrderDetailVO(); }
        List<OrderGoodsVO> orderGoodsVOS = orderGoodsMapper.selectByOrderNumber(order.getOrderNumber());

        OrderDetailVO orderDetailVO = new OrderDetailVO();

        orderDetailVO.setOrderNumber(order.getOrderNumber());
        orderDetailVO.setUserId(order.getUserId());
        orderDetailVO.setConsignee(order.getConsignee());
        orderDetailVO.setUserAddress(order.getUserAddress());
        orderDetailVO.setUserPhone(order.getUserPhone());
        orderDetailVO.setTotalPrice(order.getTotalPrice());
        orderDetailVO.setStatus(order.getStatus());
        orderDetailVO.setPayTime(order.getPayTime());
        orderDetailVO.setCreateTime(order.getCreateTime());
        orderDetailVO.setOrderGoodsList(orderGoodsVOS);
        return orderDetailVO;
    }
}
