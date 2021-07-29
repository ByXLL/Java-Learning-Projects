package com.brodog.mall.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brodog.mall.admin.form.order.OrderSelectParam;
import com.brodog.mall.admin.mapper.OrderMapper;
import com.brodog.mall.admin.vo.order.OrderVO;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.Order;
import com.brodog.mall.common.entity.OrderGoods;
import com.brodog.mall.admin.mapper.OrderGoodsMapper;
import com.brodog.mall.admin.service.OrderGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brodog.mall.common.enums.HttpCodeEnum;
import com.brodog.mall.common.exception.ArgException;
import com.brodog.mall.common.exception.OperationalException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单商品表 服务实现类
 * </p>
 *
 * @author By-Lin
 * @since 2021-06-13
 */
@Service
public class OrderGoodsServiceImpl extends ServiceImpl<OrderGoodsMapper, OrderGoods> implements OrderGoodsService {


}
