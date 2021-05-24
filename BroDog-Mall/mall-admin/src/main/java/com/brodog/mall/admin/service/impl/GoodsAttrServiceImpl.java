package com.brodog.mall.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brodog.mall.admin.dto.goods.GoodsAttrAddDto;
import com.brodog.mall.admin.dto.goods.GoodsAttrEditDto;
import com.brodog.mall.admin.mapper.GoodsAttrCateMapper;
import com.brodog.mall.admin.vo.goods.GoodsAttrVO;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.GoodsAttrCate;
import com.brodog.mall.common.entity.GoodsAttr;
import com.brodog.mall.admin.mapper.GoodsAttrMapper;
import com.brodog.mall.admin.service.GoodsAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brodog.mall.common.entity.PagerParam;
import com.brodog.mall.common.enums.HttpCodeEnum;
import com.brodog.mall.common.exception.ArgException;
import com.brodog.mall.common.exception.OperationalException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 商品属性表 服务实现类
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
@Service
public class GoodsAttrServiceImpl extends ServiceImpl<GoodsAttrMapper, GoodsAttr> implements GoodsAttrService {
    private final GoodsAttrMapper goodsAttrMapper;
    private final GoodsAttrCateMapper goodsAttrCateMapper;

    public GoodsAttrServiceImpl(GoodsAttrMapper goodsAttrMapper, GoodsAttrCateMapper goodsAttrCateMapper) {
        this.goodsAttrMapper = goodsAttrMapper;
        this.goodsAttrCateMapper = goodsAttrCateMapper;
    }

    @Override
    @Transactional(rollbackFor = OperationalException.class)
    public ApiResult insert(GoodsAttrAddDto goodsAttrAddDto) {
        GoodsAttr goodsAttr = new GoodsAttr();
        BeanUtils.copyProperties(goodsAttrAddDto, goodsAttr);
        goodsAttr.setIsDel(0);
        int row1 = goodsAttrMapper.insert(goodsAttr);
        GoodsAttrCate goodsAttrCate = goodsAttrCateMapper.selectById(goodsAttrAddDto.getGoodsAttrCateId());
        goodsAttrCate.setAttrCount(goodsAttrCate.getAttrCount() +1);
        int row2 = goodsAttrCateMapper.updateById(goodsAttrCate);
        if(row1 > 0 && row2 > 0) { return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc()); }
        throw new OperationalException();
    }

    @Override
    @Transactional(rollbackFor = OperationalException.class)
    public ApiResult delete(Long id) {
        if(id == null) { throw new ArgException(); }
        GoodsAttr goodsAttr = goodsAttrMapper.selectById(id);
        if(goodsAttr == null) { throw new OperationalException(); }
        GoodsAttrCate goodsAttrCate = goodsAttrCateMapper.selectById(goodsAttr.getGoodsAttrCateId());
        int count = goodsAttrCate.getAttrCount();
        if(count >= 1) { count--; }
        else { count=0; }
        goodsAttrCate.setAttrCount(count);
        int row1 = goodsAttrMapper.deleteById(id);
        int row2 = goodsAttrCateMapper.updateById(goodsAttrCate);
        if(row1>0 && row2 > 0) { return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc()); }
        throw new OperationalException();
    }

    @Override
    public ApiResult update(GoodsAttrEditDto goodsAttrEditDto) {
        if(goodsAttrEditDto == null) { throw new ArgException(); }
        GoodsAttr goodsAttr = goodsAttrMapper.selectById(goodsAttrEditDto.getId());
        if(goodsAttr == null) { throw new OperationalException(); }
        BeanUtils.copyProperties(goodsAttrEditDto, goodsAttr);
        int row = goodsAttrMapper.updateById(goodsAttr);
        if(row > 0) { return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc()); }
        throw new OperationalException();
    }

    @Override
    public ApiResult selectByPage(PagerParam pagerParam) {
        QueryWrapper<GoodsAttrVO> queryWrapper = new QueryWrapper<>();
        IPage<GoodsAttrVO> page = goodsAttrMapper.selectMyPage(
            new Page<>(pagerParam.getPage(), pagerParam.getSize()),
            queryWrapper
        );
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(),page);
    }

    @Override
    public ApiResult selectById(Long id) {
        if(id == null) { throw new ArgException(); }
        GoodsAttr goodsAttr = goodsAttrMapper.selectById(id);
        if(goodsAttr == null) { throw new OperationalException(); }
        GoodsAttrVO goodsAttrVO = new GoodsAttrVO();
        BeanUtils.copyProperties(goodsAttr, goodsAttrVO);
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(), goodsAttrVO);
    }

    @Override
    public ApiResult selectByAttrCateId(Long id) {
        if(id == null) { throw new ArgException(); }
        GoodsAttrCate goodsAttrCate = goodsAttrCateMapper.selectById(id);
        if(goodsAttrCate == null) { throw new OperationalException("商品属性分类不存在"); }
        QueryWrapper<GoodsAttr> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("goods_attr_cate_id",id);
        List<GoodsAttrVO> list = goodsAttrMapper.selectList(queryWrapper).stream().map(item -> new GoodsAttrVO(
            item.getId(),
            item.getName(),
            item.getGoodsAttrCateId(),
            goodsAttrCate.getName(),
            item.getValueList(),
            item.getInputType(),
            item.getSort()
        )).collect(Collectors.toList());
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(), list);
    }
}
