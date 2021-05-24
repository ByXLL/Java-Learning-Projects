package com.brodog.mall.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brodog.mall.admin.dto.goods.GoodsAttrCateAddDto;
import com.brodog.mall.admin.dto.goods.GoodsAttrCateEditDto;
import com.brodog.mall.admin.vo.goods.GoodsAttrCateVO;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.GoodsAttrCate;
import com.brodog.mall.admin.mapper.GoodsAttrCateMapper;
import com.brodog.mall.admin.service.GoodsAttrCateService;
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
 * 商品-属性分类 服务实现类
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
@Service
public class GoodsAttrCateServiceImpl extends ServiceImpl<GoodsAttrCateMapper, GoodsAttrCate> implements GoodsAttrCateService {

    private final GoodsAttrCateMapper goodsAttrCateMapper;

    public GoodsAttrCateServiceImpl(GoodsAttrCateMapper goodsAttrCateMapper) {
        this.goodsAttrCateMapper = goodsAttrCateMapper;
    }

    @Override
    public ApiResult insert(GoodsAttrCateAddDto goodsAttrCateAddDto) {
        GoodsAttrCate goodsAttrCate = new GoodsAttrCate();
        BeanUtils.copyProperties(goodsAttrCateAddDto, goodsAttrCate);
        int row = goodsAttrCateMapper.insert(goodsAttrCate);
        if(row > 0) {
            System.out.println(goodsAttrCate);
            return new ApiResult(HttpCodeEnum.SUCCESS.getCode(),HttpCodeEnum.SUCCESS.getDesc(), goodsAttrCate);
        }
        return new ApiResult(HttpCodeEnum.ERROR.getCode(), HttpCodeEnum.ERROR.getDesc());
    }

    @Override
    public ApiResult delete(Long goodsAttrCateId){
        if(goodsAttrCateId == null) { throw new ArgException(); }
        GoodsAttrCate goodsAttrCate = goodsAttrCateMapper.selectById(goodsAttrCateId);
        if( goodsAttrCate == null ) { throw new OperationalException("当前属性分类不存在");}
        if(
            goodsAttrCate.getAttrCount() != 0 ||
            goodsAttrCate.getSpecCount() != 0
        ) { return new ApiResult(HttpCodeEnum.ERROR.getCode(), "该属性分类下存在商品，删除失败");}
        int row = goodsAttrCateMapper.deleteById(goodsAttrCateId);
        if(row>0) { return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc()); }
        throw new OperationalException();
    }

    @Override
    public ApiResult update(GoodsAttrCateEditDto goodsAttrCateEditDto) {
        GoodsAttrCate goodsAttrCate = goodsAttrCateMapper.selectById(goodsAttrCateEditDto.getId());
        if( goodsAttrCate == null ) { throw new OperationalException("当前属性分类不存在");}
        BeanUtils.copyProperties(goodsAttrCateEditDto, goodsAttrCate);
        int row = goodsAttrCateMapper.updateById(goodsAttrCate);
        if(row > 0) {
            return new ApiResult(HttpCodeEnum.SUCCESS.getCode(),HttpCodeEnum.SUCCESS.getDesc());
        }
        throw new OperationalException();
    }

    @Override
    public ApiResult selectAll() {
        List<GoodsAttrCateVO> goodsAttrCateVOList = goodsAttrCateMapper.selectList(null).stream().map(item -> new GoodsAttrCateVO(
                item.getId(),
                item.getName(),
                item.getAttrCount(),
                item.getSpecCount()
        )).collect(Collectors.toList());
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(), goodsAttrCateVOList);
    }

    @Override
    public ApiResult selectByName(String name) {
        QueryWrapper<GoodsAttrCate> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isBlank(name)) {
            queryWrapper = null;
        }else {
            queryWrapper.like("name",name);
        }
        List<GoodsAttrCateVO> goodsAttrCateVOList = goodsAttrCateMapper.selectList(queryWrapper).stream().map(item -> new GoodsAttrCateVO(
            item.getId(),
            item.getName(),
            item.getAttrCount(),
            item.getSpecCount()
        )).collect(Collectors.toList());
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(), goodsAttrCateVOList);
    }

    @Override
    public ApiResult selectById(Long id) {
        if(id == null) { throw new ArgException(); }
        GoodsAttrCate goodsAttrCate = goodsAttrCateMapper.selectById(id);
        if(goodsAttrCate == null) { throw new OperationalException(); }
        GoodsAttrCateVO goodsAttrCateVO = new GoodsAttrCateVO();
        BeanUtils.copyProperties(goodsAttrCate, goodsAttrCateVO);
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(), goodsAttrCateVO);
    }

    @Override
    public ApiResult selectByPage(PagerParam pagerParam, String name) {
        QueryWrapper<GoodsAttrCateVO> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isBlank(name)) {
            queryWrapper.like("name",name);
        }
        queryWrapper.eq("is_del",0);
        IPage<GoodsAttrCateVO> mapPage = goodsAttrCateMapper.selectMyPage(
            new Page<>(pagerParam.getPage(), pagerParam.getSize()),
            queryWrapper
        );
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(), mapPage);
    }

}
