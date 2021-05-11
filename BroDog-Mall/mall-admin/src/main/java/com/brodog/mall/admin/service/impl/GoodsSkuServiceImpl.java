package com.brodog.mall.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.brodog.mall.admin.dto.goods.GoodsSkuAddDto;
import com.brodog.mall.admin.dto.goods.GoodsSkuEditDto;
import com.brodog.mall.admin.vo.goods.GoodsSkuVO;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.GoodsSku;
import com.brodog.mall.admin.mapper.GoodsSkuMapper;
import com.brodog.mall.admin.service.GoodsSkuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brodog.mall.common.enums.HttpCodeEnum;
import com.brodog.mall.common.exception.ArgException;
import com.brodog.mall.common.exception.OperationalException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 商品SKU表 服务实现类
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
@Service
public class GoodsSkuServiceImpl extends ServiceImpl<GoodsSkuMapper, GoodsSku> implements GoodsSkuService {

    private final GoodsSkuMapper mapper;

    public GoodsSkuServiceImpl(GoodsSkuMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public ApiResult insert(@Valid GoodsSkuAddDto goodsSkuAddDto) {
        GoodsSku goodsSku = new GoodsSku();
        BeanUtils.copyProperties(goodsSkuAddDto,goodsSku);
        int row = mapper.insert(goodsSku);
        if(row >0) { return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc()); }
        throw new OperationalException();
    }

    @Override
    public ApiResult delete(Long id) {
        if(id == null) {throw new ArgException(); }
        GoodsSku goodsSku = mapper.selectById(id);
        if(goodsSku == null) { throw new OperationalException(); }
        int row = mapper.deleteById(id);
        if(row > 0) { return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc()); }
        throw new OperationalException();
    }

    @Override
    public ApiResult deleteByGoodsId(Long goodsId) {
        if(goodsId == null) {throw new ArgException(); }
        QueryWrapper<GoodsSku> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("goods_id", goodsId);
        int row = mapper.delete(queryWrapper);
        if(row>0) {return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc()); }
        throw new OperationalException();
    }

    @Override
    public ApiResult deleteByGoodsIds(String goodsIds) {
        if(StringUtils.isBlank(goodsIds)) { throw new ArgException(); }
        int row = mapper.deleteBatchIds(Collections.singleton(goodsIds));
        if(row >0) { return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc()); }
        throw new OperationalException();
    }

    @Override
    public ApiResult update(GoodsSkuEditDto goodsSkuEditDto) {
        GoodsSku goodsSku = mapper.selectById(goodsSkuEditDto.getId());
        if(goodsSku == null) { throw new OperationalException(); }
        BeanUtils.copyProperties(goodsSkuEditDto,goodsSku);
        int row = mapper.updateById(goodsSku);
        if(row >0) { return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc()); }
        throw new OperationalException();
    }

    @Override
    public ApiResult selectById(Long id) {
        if(id == null) {throw new ArgException(); }
        GoodsSku goodsSku = mapper.selectById(id);
        if(goodsSku == null) { throw new OperationalException(); }
        GoodsSkuVO goodsSkuVO = new GoodsSkuVO();
        BeanUtils.copyProperties(goodsSku,goodsSkuVO);
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(),goodsSkuVO);
    }

    @Override
    public ApiResult selectByGoodsId(Long goodsId) {
        if(goodsId == null) {throw new ArgException(); }
//        QueryWrapper<GoodsSku> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("goods_id",goodsId);
//        List<GoodsSkuVO> goodsSkuList = mapper.selectList(queryWrapper).stream().map(item -> new GoodsSkuVO(
//            item.getId(),
//            item.getGoodsId(),
//            item.getSkuNumber(),
//            item.getPrice(),
//            item.getPromotionPrice(),
//            item.getStock(),
//            item.getLowStock(),
//            item.getPic(),
//            item.getLockStock(),
//            item.getData()
//        )).collect(Collectors.toList());
//        if(goodsSkuList.size() > 0) { throw new OperationalException(); }
        List<GoodsSkuVO> goodsSkuList = mapper.selectByGoodsId(goodsId);
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(),goodsSkuList);
    }

    @Override
    public ApiResult selectBySkuNumber(Integer skuNumber) {
        if(skuNumber == null) { throw new OperationalException(); }
        QueryWrapper<GoodsSku> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sku_number",skuNumber);
        GoodsSku goodsSku = mapper.selectOne(queryWrapper);
        if(goodsSku == null) { throw new OperationalException(); }
        GoodsSkuVO goodsSkuVO = new GoodsSkuVO();
        BeanUtils.copyProperties(goodsSku,goodsSkuVO);
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(),goodsSkuVO);
    }
}
