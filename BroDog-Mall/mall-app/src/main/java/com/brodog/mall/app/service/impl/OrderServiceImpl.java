package com.brodog.mall.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brodog.mall.app.dto.order.OrderGoodsAddDto;
import com.brodog.mall.app.form.order.OrderAddForm;
import com.brodog.mall.app.form.order.OrderSelectParam;
import com.brodog.mall.app.mapper.*;
import com.brodog.mall.app.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brodog.mall.app.vo.order.OrderDetailVO;
import com.brodog.mall.app.vo.order.OrderGoodsVO;
import com.brodog.mall.app.vo.order.OrderVO;
import com.brodog.mall.common.entity.*;
import com.brodog.mall.common.enums.HttpCodeEnum;
import com.brodog.mall.common.exception.OperationalException;
import com.brodog.mall.common.util.CommUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author By-Lin
 * @since 2021-06-20
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    private final OrderMapper orderMapper;
    private final OrderGoodsMapper orderGoodsMapper;
    private final OrderReturnApplyMapper orderReturnApplyMapper;
    private final OrderReturnApplyDeliveryMapper orderReturnApplyDeliveryMapper;
    private final GoodsMapper goodsMapper;
    private final GoodsSkuMapper goodsSkuMapper;
    private final GoodsAttrMapper goodsAttrMapper;
    private final UserMapper userMapper;
    private final UserCartMapper userCartMapper;
    private final OrderSettingMapper orderSettingMapper;


    public OrderServiceImpl(OrderMapper orderMapper,
                            OrderGoodsMapper orderGoodsMapper,
                            OrderReturnApplyMapper orderReturnApplyMapper,
                            OrderReturnApplyDeliveryMapper orderReturnApplyDeliveryMapper,
                            GoodsMapper goodsMapper,
                            GoodsSkuMapper goodsSkuMapper, GoodsAttrMapper goodsAttrMapper,
                            UserMapper userMapper, UserCartMapper userCartMapper,
                            OrderSettingMapper orderSettingMapper) {
        this.orderMapper = orderMapper;
        this.orderGoodsMapper = orderGoodsMapper;
        this.orderReturnApplyMapper = orderReturnApplyMapper;
        this.orderReturnApplyDeliveryMapper = orderReturnApplyDeliveryMapper;
        this.goodsMapper = goodsMapper;
        this.goodsSkuMapper = goodsSkuMapper;
        this.goodsAttrMapper = goodsAttrMapper;
        this.userMapper = userMapper;
        this.userCartMapper = userCartMapper;
        this.orderSettingMapper = orderSettingMapper;
    }

    @Override
    @Transactional(rollbackFor = OperationalException.class)
    public ApiResult addOrder(OrderAddForm orderAddForm) {
        // 生成订单编号和订单id
        String orderNumber = String.valueOf(System.currentTimeMillis()) + CommUtils.get4Number();
        Long orderId = IdWorker.getId();
        // 订单来源
        int sourceType = orderAddForm.getSourceType();
        // 订单商品列表
        List<OrderGoodsAddDto> orderGoodsAddDtoList = orderAddForm.getOrderGoodsList();

        // 计算订单总价
        BigDecimal totalPrice = new BigDecimal("0.00");
        // todo

        //处理订单商品
        for (OrderGoodsAddDto item : orderGoodsAddDtoList) {
            // 减库存
            totalPrice = reduceInventoryAndGetTotalPrice(item,orderId,orderNumber);
            // 移除购物车
            if(sourceType == 1) { removeShoppingCart(item); }
        }

        // 获取订单设置
        OrderSetting orderSetting = orderSettingMapper.selectById(1L);
        if(orderSetting == null) { throw new OperationalException("创建订单失败，订单设置信息获取失败"); }



        Order order = new Order();
        BeanUtils.copyProperties(orderAddForm,order);
        order.setId(orderId).setOrderNumber(orderNumber)
                .setStatus(1).setSubStatus(1).setPayStatus(0)
                .setFreightAmount(new BigDecimal("0.00"))
                .setIntegrationAmount(new BigDecimal("0.00"))
                .setCouponAmount(new BigDecimal("0.00"))
                .setConfirmStatus(0)
                .setTotalAmount(totalPrice)
                .setPayAmount(totalPrice)
                .setAutoConfirmDay(orderSetting.getConfirmOvertime());

        int row = orderMapper.insert(order);

        if(row < 1) { throw new OperationalException("创建订单失败"); }

        Map<String,Object> orderInfo = new HashMap<>(16);
        orderInfo.put("orderNumber",order.getOrderNumber());
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(),orderInfo);
    }

    @Override
    @Transactional(rollbackFor = OperationalException.class)
    public ApiResult payment(Long orderNumber) {
        Order order = orderMapper.selectOne(
                new QueryWrapper<Order>().eq("order_number",orderNumber)
                    .eq("is_del",0)
                    .eq("status",1)
                    .eq("sub_status",1)
        );
        if(order == null) { throw new OperationalException("支付失败，订单不存在"); }
        return deductionMoney(order);
    }

    @Override
    @Transactional(rollbackFor = OperationalException.class)
    public ApiResult cancelOrderByOrderNumber(Long orderNumber) {
        Order order = orderMapper.selectOne(new QueryWrapper<Order>()
                .eq("order_number",orderNumber)
                .eq("user_id",1)
                .eq("is_del",0));
        if(order == null) { throw new OperationalException("订单不存在"); }
        // 判断订单是否已经支付
        if(order.getPayStatus() == 1) {
            // 退款
            refundByOrder(order);
            // 恢复库存
            restoreInventory(order);
            // 恢复积分
            restorePoints(order);
            // 恢复优惠卷
            // todo
        }else {
            // 订单未支付状态 直接修改订单状态
            order.setStatus(0).setSubStatus(0);
            orderMapper.updateById(order);
        }
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), "取消订单成功");
    }

    @Override
    public ApiResult afterSaleByOrderNumber(Long orderNumber) {
        Order order = orderMapper.selectOne(
                new QueryWrapper<Order>().eq("is_del",0)
                    .eq("user_id",1L)
                    .eq("status",2)
        );
        if(order == null) { throw new OperationalException("订单不存在"); }
        int orderSubStatus = order.getSubStatus();
        if(orderSubStatus == 6) { throw new OperationalException("订单售后已完成"); }
        if(orderSubStatus == 5) { throw new OperationalException("订单进行中"); }
        order.setSubStatus(5);
        int row = orderMapper.updateById(order);
        if(row < 1) { throw new OperationalException("申请售后失败"); }
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc());
    }

    @Override
    public ApiResult findByOrderNumber(Long orderNumber) {
        Order order = orderMapper.selectOne(new QueryWrapper<Order>()
                .eq("order_number",orderNumber)
                .eq("user_id",1)
                .eq("is_del",0));
        if(order == null) { throw new OperationalException("订单不存在"); }
        List<OrderGoodsVO> orderGoodsVOList = orderGoodsMapper.selectVoByOrderNumber(orderNumber);
        OrderDetailVO orderDetailVO = new OrderDetailVO();
        BeanUtils.copyProperties(order,orderDetailVO);
        BeanUtils.copyProperties(orderGoodsVOList,orderDetailVO);
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(),orderDetailVO);
    }

    @Override
    public ApiResult findListByParam(OrderSelectParam param) {
        QueryWrapper<OrderVO> orderQueryWrapper = new QueryWrapper<>();
        if(param.getStatus() != null) { orderQueryWrapper.eq("sub_status",param.getStatus()); }
        orderQueryWrapper.eq("user_id",1).eq("is_del",0);
        IPage<OrderVO> page = orderMapper.selectMyPage(new Page<>(param.getPage(), param.getSize()), orderQueryWrapper);
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(),page);
    }

    /**
     * 减库存和计算当前商品总价
     * @param dto               订单商品添加dto
     * @param orderId           订单id
     * @param orderNumber       订单编号
     * @return          当前商品总价
     */
    private BigDecimal reduceInventoryAndGetTotalPrice(OrderGoodsAddDto dto, Long orderId, String orderNumber) {
        Goods goods = goodsMapper.selectById(dto.getGoodsId());
        GoodsSku goodsSku = goodsSkuMapper.selectOne(new QueryWrapper<GoodsSku>().eq("sku_number",dto.getSkuNumber()));
        if(goods == null || goodsSku == null) { throw new OperationalException("创建订单失败，商品不存在"); }
        // 判断库存量
        int newSkuStock = goodsSku.getStock() -  dto.getCount();
        if( newSkuStock < 0 ){ throw new OperationalException("创建订单失败，商品库存不足"); }
        // 处理商品主表的库存量
        // todo
        // 处理sku表库存量
        goodsSku.setStock(newSkuStock);
        goodsSkuMapper.updateById(goodsSku);

        /*
         * 插入 订单商品表
         * future 完善促销减免与优惠卷减免
         */
        OrderGoods orderGoods = new OrderGoods();
        BeanUtils.copyProperties(dto,orderGoods);
        orderGoods.setOrderId(orderId)
                .setGoodsCateId(goods.getCateId())
                .setGoodsName(goods.getName())
                .setOrderNumber(orderNumber)
                .setSkuId(goodsSku.getId())
                .setSkuNumber(goodsSku.getSkuNumber())
                .setSellPrice(goodsSku.getPrice())
                .setPromotionPrice(new BigDecimal(0))
                .setCouponPrice(new BigDecimal(0))
                .setBrandId(goods.getBrandId())
                .setPayPrice(goodsSku.getPrice().multiply(new BigDecimal(dto.getCount())));

        int row = orderGoodsMapper.insert(orderGoods);
        if(row <1) { throw new OperationalException("创建订单失败，插入订单商品表失败"); }
        return orderGoods.getPayPrice();
    }



    /**
     * 减库存
     * @param dto               订单商品添加dto
     * @param orderId           订单id
     * @param orderNumber       订单编号
     */
    private synchronized  void reduceInventory(OrderGoodsAddDto dto, Long orderId, String orderNumber) {
        Goods goods = goodsMapper.selectById(dto.getGoodsId());
        GoodsSku goodsSku = goodsSkuMapper.selectOne(new QueryWrapper<GoodsSku>().eq("sku_number",dto.getSkuNumber()));
        if(goods == null || goodsSku == null) { throw new OperationalException("创建订单失败，商品不存在"); }
        // 判断库存量
        int newSkuStock = goodsSku.getStock() -  dto.getCount();
        if( newSkuStock < 0 ){ throw new OperationalException("创建订单失败，商品库存不足"); }
        // 处理商品主表的库存量
        // todo

        // 处理sku表库存量
        goodsSku.setStock(newSkuStock);
        goodsSkuMapper.updateById(goodsSku);

        /*
         * 插入 订单商品表
         * future 完善促销减免与优惠卷减免
         */
        OrderGoods orderGoods = new OrderGoods();
        BeanUtils.copyProperties(dto,orderGoods);
        orderGoods.setOrderId(orderId)
                .setGoodsCateId(goods.getCateId())
                .setGoodsName(goods.getName())
                .setOrderNumber(orderNumber)
                .setSkuId(goodsSku.getId())
                .setSkuNumber(goodsSku.getSkuNumber())
                .setSellPrice(goodsSku.getPrice())
                .setPromotionPrice(new BigDecimal(0))
                .setCouponPrice(new BigDecimal(0))
                .setBrandId(goods.getBrandId())
                .setPayPrice(goodsSku.getPrice().multiply(new BigDecimal(dto.getCount())));

        int row = orderGoodsMapper.insert(orderGoods);
        if(row <1) { throw new OperationalException("创建订单失败，插入订单商品表失败"); }
    }

    /**
     * 根据订单移除购物车中的商品
     * @param orderGoodsAddDto      订单中的商品
     */
    private void removeShoppingCart(OrderGoodsAddDto orderGoodsAddDto) {
        // todo
        Goods goods = goodsMapper.selectById(orderGoodsAddDto.getGoodsId());
        if(goods == null) { throw new OperationalException("创建订单失败，购物车商品不存在"); }
        int row = userCartMapper.delete(new QueryWrapper<UserCart>().eq("goods_id",goods.getId()).eq("user_id",1));
        if(row <1) { throw new OperationalException("创建订单失败，移除购物车失败"); }
    }

    /**
     * 扣款
     * @param order      订单
     */
    private ApiResult deductionMoney(Order order) {
        BigDecimal payPrice = order.getPayAmount();
        int payType = order.getPayType();
        switch (payType) {
            case 0:
                deductionFromCard(payPrice);
                break;
            case 2:
                deductionFromWeChatPay(payPrice);
                break;
            case 3:
                deductionFromAliPay(payPrice);
                break;
            default:
                deductionFromBalance(payPrice);
                break;
        }
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc());
    }

    /**
     * 从银行卡扣款
     * @param payPrice      金额
     */
    private void deductionFromCard(BigDecimal payPrice) {
        // todo
    }

    /**
     * 从微信扣款
     * @param payPrice      金额
     */
    private void deductionFromWeChatPay(BigDecimal payPrice) {
        // todo
    }

    /**
     * 从支付宝扣款
     * @param payPrice      金额
     */
    private void deductionFromAliPay(BigDecimal payPrice) {
        // todo
    }

    /**
     * 从余额扣款
     * @param payPrice      金额
     */
    private void deductionFromBalance(BigDecimal payPrice) {
        User user = userMapper.selectById(1L);
        BigDecimal balance = user.getBalance();
        // 余额大于待支付金额
        if(balance.compareTo(payPrice) > -1){
            user.setBalance(balance.subtract(payPrice));
            userMapper.updateById(user);
        }
        throw new OperationalException("支付失败,余额不足");
    }



    /**
     * 根据订单退款
     * @param order         订单实体
     */
    private void refundByOrder(Order order) {
        int payType = order.getPayType();
        switch (payType){
            case 1:
                refundToBalance(order);
                break;
            case 2:
                refundToAliPay(order);
                break;
            case 3:
                refundToWechatPay(order);
                break;
            default:
                refundToCard(order);
                break;
        }
    }

    /**
     * 恢复库存
     * @param order     订单实体
     */
    private void restoreInventory(Order order) {
        String orderNumber = order.getOrderNumber();
        List<OrderGoods> orderGoodsList = orderGoodsMapper.selectList(new QueryWrapper<OrderGoods>().eq("order_number", orderNumber));
        for (OrderGoods orderGoods : orderGoodsList) {
            Goods goods = goodsMapper.selectById(orderGoods.getGoodsId());
            if(goods == null) { throw new OperationalException("取消订单失败，商品不存在"); }
            goods.setInventory(goods.getInventory()+orderGoods.getCount());
            goodsMapper.updateById(goods);
        }
    }

    /**
     * 恢复积分
     * 疑问：如果一个订单里面存在两个商品
     * 而现在的设计是在一个订单结算的时候使用积分，积分减免是作用到订单上，而不是订单商品
     * 当前处理，当订单是全退款时，做积分全退回
     * @param order     订单实体
     */
    private void restorePoints(Order order) {
        String orderNumber = order.getOrderNumber();
        User user =  userMapper.selectById(order.getUserId());
        if(user == null) { throw new OperationalException("取消订单失败，用户不存在"); }
        BigDecimal integrationAmount = order.getIntegrationAmount();
        user.setIntegral(user.getIntegral() + integrationAmount.doubleValue()*10);
        userMapper.updateById(user);
    }

    /**
     * 退款到银行卡
     * @param order     订单实体
     */
    private void refundToCard(Order order) {
        // todo
    }

    /**
     * 退款到微信
     * @param order     订单实体
     */
    private void refundToWechatPay(Order order) {
        // todo
    }

    /**
     * 退款到支付宝
     * @param order     订单实体
     */
    private void refundToAliPay(Order order) {
        // todo
    }

    /**
     * 退款到余额
     * @param order     订单实体
     */
    private void refundToBalance(Order order) {
        User user = userMapper.selectById(order.getUserId());
        user.setBalance(user.getBalance().add(order.getPayAmount()));
        userMapper.updateById(user);
    }

}
