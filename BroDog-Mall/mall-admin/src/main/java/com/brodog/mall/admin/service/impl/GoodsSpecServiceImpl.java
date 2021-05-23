package com.brodog.mall.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brodog.mall.admin.dto.goods.GoodsSpecAddDto;
import com.brodog.mall.admin.dto.goods.GoodsSpecEditDto;
import com.brodog.mall.admin.mapper.GoodsAttrMapper;
import com.brodog.mall.admin.vo.goods.GoodsSpecVO;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.GoodsAttr;
import com.brodog.mall.common.entity.GoodsSpec;
import com.brodog.mall.admin.mapper.GoodsSpecMapper;
import com.brodog.mall.admin.service.GoodsSpecService;
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
 * 商品-规格 服务实现类
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
@Service
public class GoodsSpecServiceImpl extends ServiceImpl<GoodsSpecMapper, GoodsSpec> implements GoodsSpecService {
    private final GoodsSpecMapper goodsSpecMapper;
    private final GoodsAttrMapper goodsAttrMapper;

    public GoodsSpecServiceImpl(GoodsSpecMapper goodsSpecMapper, GoodsAttrMapper goodsAttrMapper) {
        this.goodsSpecMapper = goodsSpecMapper;
        this.goodsAttrMapper = goodsAttrMapper;
    }

    @Override
    @Transactional(rollbackFor = OperationalException.class)
    public ApiResult insert(GoodsSpecAddDto goodsSpecAddDto) {
        GoodsSpec goodsSpec = new GoodsSpec();
        BeanUtils.copyProperties(goodsSpecAddDto,goodsSpec);
        goodsSpec.setIsDel(0);
        GoodsAttr goodsAttr = goodsAttrMapper.selectById(goodsSpec.getGoodsAttrId());
        goodsAttr.setSpecCount(goodsAttr.getSpecCount() + 1);
        int row1 = goodsSpecMapper.insert(goodsSpec);
        int row2 = goodsAttrMapper.updateById(goodsAttr);
        if(row1 >0 && row2 >0) { return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc()); }
        throw new OperationalException();
    }

    @Override
    public ApiResult delete(Long goodsSpecId) {
        if(goodsSpecId == null) { throw new ArgException(); }
        GoodsSpec goodsSpec = goodsSpecMapper.selectById(goodsSpecId);
        if(goodsSpec == null) { throw new OperationalException(); }
        int row = goodsSpecMapper.deleteById(goodsSpecId);
        if(row > 0) { return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc()); }
        throw new OperationalException();
    }

    @Override
    public ApiResult update(GoodsSpecEditDto goodsSpecEditDto) {
        if(goodsSpecEditDto == null) { throw new ArgException(); }
        GoodsSpec goodsSpec = goodsSpecMapper.selectById(goodsSpecEditDto.getId());
        if(goodsSpec == null) { throw new OperationalException(); }
        BeanUtils.copyProperties(goodsSpecEditDto, goodsSpec);
        int row = goodsSpecMapper.updateById(goodsSpec);
        if(row > 0) { return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc()); }
        throw new OperationalException();
    }

    @Override
    public ApiResult selectByPage(PagerParam pagerParam) {
        QueryWrapper<GoodsSpecVO> queryWrapper = new QueryWrapper<>();
        IPage<GoodsSpecVO> mapPage = goodsSpecMapper.selectMyPage(
            new Page<>(pagerParam.getPage(), pagerParam.getSize()),
            queryWrapper
        );
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(), mapPage);
    }

    @Override
    public ApiResult selectById(Long id) {
        if(id == null) { throw new ArgException(); }
        GoodsSpec goodsSpec = goodsSpecMapper.selectById(id);
        if(goodsSpec == null) { throw new OperationalException(); }
        GoodsSpecVO goodsSpecVO = new GoodsSpecVO();
        BeanUtils.copyProperties(goodsSpec,goodsSpecVO);
//        ArrayList<String> newList = CommUtils.stringToList(goodsSpec.getValueList());
//        goodsSpecVO.setValueList(newList);
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(), goodsSpecVO);
    }

    @Override
    public ApiResult selectByAttrId(Long id) {
        QueryWrapper<GoodsSpec> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("goods_attr_id",id);
        GoodsAttr goodsAttr = goodsAttrMapper.selectById(id);
        if(goodsAttr == null) { throw new OperationalException("商品属性不存在"); }
        List<GoodsSpecVO> list = goodsSpecMapper.selectList(queryWrapper).stream().map(item -> new GoodsSpecVO(
                item.getId(),
                item.getName(),
                item.getGoodsAttrId(),
                goodsAttr.getName(),
                item.getValueList(),
                item.getSort()
        )).collect(Collectors.toList());
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(),list);
    }
}
