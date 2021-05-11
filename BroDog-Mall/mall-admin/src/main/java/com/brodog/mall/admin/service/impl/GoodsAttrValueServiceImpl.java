package com.brodog.mall.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brodog.mall.admin.dto.goods.GoodsAttrValueAddDto;
import com.brodog.mall.admin.dto.goods.GoodsAttrValueEditDto;
import com.brodog.mall.admin.vo.goods.GoodsAttrValueVO;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.GoodsAttrValue;
import com.brodog.mall.admin.mapper.GoodsAttrValueMapper;
import com.brodog.mall.admin.service.GoodsAttrValueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brodog.mall.common.entity.PagerParam;
import com.brodog.mall.common.enums.HttpCodeEnum;
import com.brodog.mall.common.exception.ArgException;
import com.brodog.mall.common.exception.OperationalException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 商品属性-属性值表 服务实现类
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
@Service
public class GoodsAttrValueServiceImpl extends ServiceImpl<GoodsAttrValueMapper, GoodsAttrValue> implements GoodsAttrValueService {
    private final GoodsAttrValueMapper mapper;

    public GoodsAttrValueServiceImpl(GoodsAttrValueMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public ApiResult insert(GoodsAttrValueAddDto goodsAttrValueAddDto) {
        GoodsAttrValue goodsAttrValue = new GoodsAttrValue();
        BeanUtils.copyProperties(goodsAttrValueAddDto,goodsAttrValue);
        goodsAttrValue.setIsDel(0);
        int row = mapper.insert(goodsAttrValue);
        if(row > 0) { return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc()); }
        throw new OperationalException();
    }

    @Override
    public ApiResult delete(Long id) {
        if(id == null) { throw new ArgException(); }
        GoodsAttrValue goodsAttrValue = mapper.selectById(id);
        if(goodsAttrValue == null) { throw new OperationalException(); }
        int row = mapper.deleteById(id);
        if(row>0) { return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc()); }
        throw new OperationalException();
    }

    @Override
    public ApiResult update(GoodsAttrValueEditDto goodsAttrValueEditDto) {
        if(goodsAttrValueEditDto == null) { throw new ArgException(); }
        GoodsAttrValue goodsAttrValue = mapper.selectById(goodsAttrValueEditDto.getId());
        if(goodsAttrValue == null) { throw new OperationalException(); }
        BeanUtils.copyProperties(goodsAttrValueEditDto,goodsAttrValue);
        int row = mapper.updateById(goodsAttrValue);
        if(row > 0) { return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc()); }
        throw new OperationalException();
    }

    @Override
    public ApiResult selectByPage(PagerParam pagerParam) {
        QueryWrapper<GoodsAttrValueVO> queryWrapper = new QueryWrapper<>();
        IPage<GoodsAttrValueVO> page = mapper.selectMyPage(
            new Page<>(pagerParam.getPage(), pagerParam.getSize()),
            queryWrapper
        );
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(),page);
    }

    @Override
    public ApiResult selectById(Long id) {
        if(id == null) { throw new ArgException(); }
        GoodsAttrValue goodsAttrValue = mapper.selectById(id);
        if(goodsAttrValue == null) { throw new OperationalException(); }
        GoodsAttrValueVO goodsAttrValueVO = new GoodsAttrValueVO();
        BeanUtils.copyProperties(goodsAttrValue,goodsAttrValueVO);
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(),goodsAttrValueVO);
    }

    @Override
    public ApiResult selectByAttrId(Long id) {
        if(id == null) { throw new ArgException(); }
        QueryWrapper<GoodsAttrValue> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("goods_attr_id",id);
        List<GoodsAttrValueVO> list = mapper.selectList(queryWrapper).stream().map(item -> new GoodsAttrValueVO(
            item.getId(),
            item.getName(),
            item.getGoodsAttrId(),
            item.getValueList(),
            item.getInputType(),
            item.getSort()
        )).collect(Collectors.toList());
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(), list);
    }
}
