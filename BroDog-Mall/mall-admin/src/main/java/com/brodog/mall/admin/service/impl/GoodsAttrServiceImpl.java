package com.brodog.mall.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brodog.mall.admin.dto.goods.GoodsAttrAddDto;
import com.brodog.mall.admin.dto.goods.GoodsAttrEditDto;
import com.brodog.mall.admin.vo.goods.GoodsAttrVO;
import com.brodog.mall.admin.vo.goods.GoodsBranVO;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.GoodsAttr;
import com.brodog.mall.admin.mapper.GoodsAttrMapper;
import com.brodog.mall.admin.service.GoodsAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brodog.mall.common.entity.PagerParam;
import com.brodog.mall.common.enums.HttpCodeEnum;
import com.brodog.mall.common.exception.ArgException;
import com.brodog.mall.common.exception.OperationalException;
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
    public ApiResult insert(GoodsAttrAddDto goodsAttrAddDto) {
        GoodsAttr goodsAttr = new GoodsAttr();
        BeanUtils.copyProperties(goodsAttrAddDto,goodsAttr);
        int row = goodsAttrMapper.insert(goodsAttr);
        if(row > 0) {
            System.out.println(goodsAttr);
            return new ApiResult(HttpCodeEnum.SUCCESS.getCode(),HttpCodeEnum.SUCCESS.getDesc(), goodsAttr);
        }
        return new ApiResult(HttpCodeEnum.ERROR.getCode(), HttpCodeEnum.ERROR.getDesc());
    }

    @Override
    public ApiResult delete(Long goodsAttrId){
        if(goodsAttrId == null) { throw new ArgException(); }
        GoodsAttr goodsAttr = goodsAttrMapper.selectById(goodsAttrId);
        if( goodsAttr == null ) { throw new OperationalException("当前属性不存在");}
        if(
            goodsAttr.getAttrCount() != 0 ||
            goodsAttr.getSpecCount() != 0
        ) { return new ApiResult(HttpCodeEnum.ERROR.getCode(), "该属性分类下存在商品，删除失败");}
        int row = goodsAttrMapper.deleteById(goodsAttrId);
        if(row>0) { return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc()); }
        throw new OperationalException();
    }

    @Override
    public ApiResult update(GoodsAttrEditDto goodsAttrEditDto) {
        GoodsAttr goodsAttr = goodsAttrMapper.selectById(goodsAttrEditDto.getId());
        if( goodsAttr == null ) { throw new OperationalException("当前属性不存在");}
        BeanUtils.copyProperties(goodsAttrEditDto,goodsAttr);
        int row = goodsAttrMapper.updateById(goodsAttr);
        if(row > 0) {
            return new ApiResult(HttpCodeEnum.SUCCESS.getCode(),HttpCodeEnum.SUCCESS.getDesc());
        }
        throw new OperationalException();
    }

    @Override
    public ApiResult selectAll() {
        List<GoodsAttrVO> goodsAttrVOList = goodsAttrMapper.selectList(null).stream().map(item -> new GoodsAttrVO(
                item.getId(),
                item.getName(),
                item.getAttrCount(),
                item.getSpecCount()
        )).collect(Collectors.toList());
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(), goodsAttrVOList);
    }

    @Override
    public ApiResult selectByName(String name) {
        QueryWrapper<GoodsAttr> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isBlank(name)) {
            queryWrapper = null;
        }else {
            queryWrapper.like("name",name);
        }
        List<GoodsAttrVO> goodsAttrVOList = goodsAttrMapper.selectList(queryWrapper).stream().map(item -> new GoodsAttrVO(
            item.getId(),
            item.getName(),
            item.getAttrCount(),
            item.getSpecCount()
        )).collect(Collectors.toList());
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(), goodsAttrVOList);
    }

    @Override
    public ApiResult selectById(Long id) {
        if(id == null) { throw new ArgException(); }
        GoodsAttr goodsAttr = goodsAttrMapper.selectById(id);
        if(goodsAttr == null) { throw new OperationalException(); }
        GoodsAttrVO goodsAttrVO = new GoodsAttrVO();
        BeanUtils.copyProperties(goodsAttr,goodsAttrVO);
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(), goodsAttrVO);
    }

    @Override
    public ApiResult selectByPage(PagerParam pagerParam, String name) {
        QueryWrapper<GoodsAttrVO> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isBlank(name)) {
            queryWrapper.like("name",name);
        }
        queryWrapper.eq("is_del",0);
        IPage<GoodsAttrVO> mapPage = goodsAttrMapper.selectMyPage(
            new Page<>(pagerParam.getPage(), pagerParam.getSize()),
            queryWrapper
        );
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(), mapPage);
    }

}
