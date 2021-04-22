package com.brodog.mall.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.brodog.mall.admin.dto.goods.GoodsAttrDto;
import com.brodog.mall.admin.vo.GoodsAttrVo;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.GoodsAttr;
import com.brodog.mall.admin.mapper.GoodsAttrMapper;
import com.brodog.mall.admin.service.GoodsAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brodog.mall.common.enums.HttpCodeEnum;
import com.brodog.mall.common.exception.ArgException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 商品-属性 服务实现类
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
@Service
public class GoodsAttrServiceImpl extends ServiceImpl<GoodsAttrMapper, GoodsAttr> implements GoodsAttrService {

    private final GoodsAttrMapper goodsAttrMapper;

    public GoodsAttrServiceImpl(GoodsAttrMapper goodsAttrMapper) {
        this.goodsAttrMapper = goodsAttrMapper;
    }

    @Override
    public ApiResult insert(GoodsAttrDto goodsAttrDto) {
        GoodsAttr goodsAttr = new GoodsAttr();
        BeanUtils.copyProperties(goodsAttrDto,goodsAttr);
        int row = goodsAttrMapper.insert(goodsAttr);
        if(row > 0) {
            System.out.println(goodsAttr);
            return new ApiResult(HttpCodeEnum.SUCCESS.getCode(),HttpCodeEnum.SUCCESS.getDesc(), goodsAttr);
        }
        return new ApiResult(HttpCodeEnum.ERROR.getCode(), HttpCodeEnum.ERROR.getDesc());
    }

    @Override
    public ApiResult selectAll() {
        List<GoodsAttrVo> goodsAttrVoList = goodsAttrMapper.selectList(null).stream().map(item -> new GoodsAttrVo(
                item.getId(),
                item.getName(),
                item.getAttrCount(),
                item.getSpecCount()
        )).collect(Collectors.toList());
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(), goodsAttrVoList);
    }

    @Override
    public ApiResult selectByName(String name) {
        QueryWrapper<GoodsAttr> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name",name);
        List<GoodsAttrVo> goodsAttrVoList = goodsAttrMapper.selectList(queryWrapper).stream().map(item -> new GoodsAttrVo(
            item.getId(),
            item.getName(),
            item.getAttrCount(),
            item.getSpecCount()
        )).collect(Collectors.toList());
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(),goodsAttrVoList);
    }
}
