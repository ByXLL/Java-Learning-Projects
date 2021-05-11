package com.brodog.mall.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.brodog.mall.admin.dto.goods.GoodsDescAddDto;
import com.brodog.mall.admin.dto.goods.GoodsDescEditDto;
import com.brodog.mall.admin.vo.goods.GoodsDescVO;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.GoodsDesc;
import com.brodog.mall.admin.mapper.GoodsDescMapper;
import com.brodog.mall.admin.service.GoodsDescService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brodog.mall.common.enums.HttpCodeEnum;
import com.brodog.mall.common.exception.ArgException;
import com.brodog.mall.common.exception.OperationalException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品详情表 服务实现类
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
@Service
public class GoodsDescServiceImpl extends ServiceImpl<GoodsDescMapper, GoodsDesc> implements GoodsDescService {

    private final GoodsDescMapper mapper;

    public GoodsDescServiceImpl(GoodsDescMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public ApiResult insert(GoodsDescAddDto goodsDescAddDto) {
        GoodsDesc goodsDesc = new GoodsDesc();
        BeanUtils.copyProperties(goodsDescAddDto,goodsDesc);
        int row = mapper.insert(goodsDesc);
        if(row >0) { return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(),true); }
        throw new OperationalException();
    }

    @Override
    public ApiResult delete(Long id) {
        if(id == null) { throw new ArgException(); }
        GoodsDesc goodsDesc = mapper.selectById(id);
        if(goodsDesc == null) { throw new OperationalException(); }
        int row = mapper.deleteById(id);
        if(row>0) { return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(),true); }
        throw new OperationalException();
    }

    @Override
    public ApiResult update(GoodsDescEditDto goodsDescEditDto) {
        GoodsDesc goodsDesc = mapper.selectById(goodsDescEditDto.getGoodsId());
        if(goodsDesc == null) { throw new OperationalException(); }
        BeanUtils.copyProperties(goodsDescEditDto,goodsDesc);
        int row = mapper.updateById(goodsDesc);
        if(row >0) { return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc()); }
        throw new OperationalException();
    }

    @Override
    public ApiResult selectById(Long id) {
        if(id == null) { throw new OperationalException(); }
        GoodsDesc goodsDesc = mapper.selectById(id);
        if(goodsDesc == null) { throw new OperationalException(); }
        GoodsDescVO goodsDescVO = new GoodsDescVO();
        BeanUtils.copyProperties(goodsDesc,goodsDescVO);
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(), goodsDescVO);
    }

    @Override
    public ApiResult selectByGoodsId(Long goodsId) {
        if(goodsId == null) { throw new ArgException(); }
//        QueryWrapper<GoodsDesc> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("goods_id",goodsId);
//        GoodsDesc goodsDesc = mapper.selectOne(queryWrapper);
//        GoodsDescVO goodsDescVO = new GoodsDescVO();
//        BeanUtils.copyProperties(goodsDesc,goodsDescVO);
        GoodsDescVO goodsDescVO = mapper.selectByGoodsId(goodsId);
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(), goodsDescVO);
    }
}
