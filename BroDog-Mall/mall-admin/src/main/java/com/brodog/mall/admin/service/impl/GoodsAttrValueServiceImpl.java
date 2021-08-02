package com.brodog.mall.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.brodog.mall.admin.dto.goods.GoodsAttrValueAddDto;
import com.brodog.mall.admin.mapper.GoodsAttrMapper;
import com.brodog.mall.admin.vo.goods.GoodsAttrValueVO;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.GoodsAttr;
import com.brodog.mall.common.entity.GoodsAttrValue;
import com.brodog.mall.admin.mapper.GoodsAttrValueMapper;
import com.brodog.mall.admin.service.GoodsAttrValueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
 * 商品属性-属性值表 服务实现类
 * </p>
 *
 * @author By-Lin
 * @since 2021-05-24
 */
@Service
public class GoodsAttrValueServiceImpl extends ServiceImpl<GoodsAttrValueMapper, GoodsAttrValue> implements GoodsAttrValueService {
    private final GoodsAttrMapper goodsAttrMapper;
    private final GoodsAttrValueMapper goodsAttrValueMapper;

    public GoodsAttrValueServiceImpl(GoodsAttrMapper goodsAttrMapper, GoodsAttrValueMapper goodsAttrValueMapper) {
        this.goodsAttrMapper = goodsAttrMapper;
        this.goodsAttrValueMapper = goodsAttrValueMapper;
    }

    @Override
    public ApiResult insert(GoodsAttrValueAddDto attrValueAddDto) {
        if (attrValueAddDto.getGoodsId() == null) { throw new ArgException("商品id为空"); }
        GoodsAttrValue goodsAttrValue = new GoodsAttrValue();
        BeanUtils.copyProperties(attrValueAddDto,goodsAttrValue);
        GoodsAttr goodsAttr = goodsAttrMapper.selectById(attrValueAddDto.getGoodsAttrId());
        if(goodsAttr == null) { throw new OperationalException("商品属性不存在"); }
        goodsAttrValue.setGoodsAttrName(goodsAttr.getName());
        int row = goodsAttrValueMapper.insert(goodsAttrValue);
        if(row >0) { return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc()); }
        throw new OperationalException();
    }

    /**
     * 这里的批量插入 有待优化 将批量插入抽离出去 做成公用
     */
    @Override
    @Transactional(rollbackFor = OperationalException.class)
    public ApiResult insertBatch(List<GoodsAttrValueAddDto> addDtoList) {
        if(addDtoList.size() > 0) {
            GoodsAttrValue goodsAttrValue = new GoodsAttrValue();
            for (GoodsAttrValueAddDto addDto : addDtoList) {
                if(addDto.getGoodsId() == null) { throw new ArgException("商品id为空"); }
                BeanUtils.copyProperties(addDto,goodsAttrValue);
                goodsAttrValueMapper.insert(goodsAttrValue);
            }
            return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc());
        }
        throw new ArgException();
    }

    @Override
    public ApiResult deleteByGoodsId(Long goodsId) {
        if(goodsId == null) { throw new ArgException("商品id为空"); }
        QueryWrapper<GoodsAttrValue> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("goods_id",goodsId);
        int row = goodsAttrValueMapper.delete(queryWrapper);
        if(row > 0) { return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc()); }
        throw new OperationalException();
    }

    @Override
    public ApiResult deleteByAttrId(Long attrId) {
        if(attrId == null) { throw new ArgException("商品属性分类id为空"); }
        QueryWrapper<GoodsAttrValue> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("goods_attr_id",attrId);
        int row = goodsAttrValueMapper.delete(queryWrapper);
        if(row > 0) { return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc()); }
        throw new OperationalException();
    }

    @Override
    public ApiResult deleteById(Long id) {
        if(id == null) { throw new ArgException("商品属性分类id为空"); }
        int row = goodsAttrValueMapper.deleteById(id);
        if(row > 0) { return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc()); }
        throw new OperationalException();
    }

    @Override
    public ApiResult selectById(Long id) {
        if(id == null) { throw new ArgException("商品属性值id为空"); }
        GoodsAttrValue goodsAttrValue = goodsAttrValueMapper.selectById(id);
        if(goodsAttrValue == null) { throw new OperationalException(); }
        GoodsAttrValueVO goodsAttrValueVO = new GoodsAttrValueVO();
        BeanUtils.copyProperties(goodsAttrValue,goodsAttrValueVO);
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(),goodsAttrValueVO);
    }

    @Override
    public ApiResult selectByGoodsId(Long goodsId) {
        if(goodsId == null) { throw new ArgException("商品id为空"); }
        QueryWrapper<GoodsAttrValue> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("goods_id",goodsId);
        List<GoodsAttrValueVO> list = goodsAttrValueMapper.selectList(queryWrapper).stream().map(item -> new GoodsAttrValueVO(
            item.getId(),
            item.getGoodsId(),
            item.getGoodsAttrId(),
            item.getGoodsAttrName(),
            item.getValue()
        )).collect(Collectors.toList());
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(),list);
    }
}
