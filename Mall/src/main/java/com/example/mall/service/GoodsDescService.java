package com.example.mall.service;

import com.example.mall.dao.GoodsDescMapper;
import com.example.mall.data.ApiResult;
import com.example.mall.dto.goodsdesc.GoodsDescDto;
import com.example.mall.entity.GoodsDesc;
import com.example.mall.utils.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * 商品详情 service
 * @author By-Lin
 */
@Service
public class GoodsDescService implements Constants {
    private final GoodsDescMapper goodsDescMapper;

    public GoodsDescService(GoodsDescMapper goodsDescMapper) {
        this.goodsDescMapper = goodsDescMapper;
    }

    /**
     * 插入商品详情
     * @param goodsDescDto       商品详情 dto
     * @return                      响应数据
     */
    public ApiResult insertGoodsDesc(GoodsDescDto goodsDescDto) {
        if(goodsDescDto == null) { return new ApiResult(WARNING_CODE,"参数不能为空"); }
        if(goodsDescDto.getGoodsId() == null) { return new ApiResult(WARNING_CODE,"商品id不能为空"); }
        if(StringUtils.isBlank(goodsDescDto.getContent())) { return new ApiResult(WARNING_CODE,"商品详情不能为空"); }
        int row = goodsDescMapper.insertGoodsDesc(goodsDescDto);
        if(row > 0) { return new ApiResult(SUCCESS_CODE,"商品详情添加成功",true); }
        return new ApiResult(ERROR_CODE,"商品添加失败",false);
    }

    /**
     * 编辑商品
     * @param goodsDescDto      商品详情 编辑dto
     * @return                      响应数据
     */
    public ApiResult updateGoodsDesc(GoodsDescDto goodsDescDto) {
        if(goodsDescDto == null) { return new ApiResult(WARNING_CODE,"参数不能为空"); }
        if(goodsDescDto.getGoodsId() == null) { return new ApiResult(WARNING_CODE,"商品id不能为空"); }
        if(StringUtils.isBlank(goodsDescDto.getContent())) { return new ApiResult(WARNING_CODE,"商品详情不能为空"); }
        int row = goodsDescMapper.updateGoodsDesc(goodsDescDto);
        if(row > 0) { return new ApiResult(SUCCESS_CODE,"编辑商品详情成功"); }
        return new ApiResult(ERROR_CODE,"编辑商品详情失败");
    }

    /**
     * 通过 商品id 获取商品详情
     * @param goodsId       商品id
     * @return              响应数据
     */
    public ApiResult selectGoodsDescByGoodsId(Integer goodsId) {
        if(goodsId == null) { return new ApiResult(WARNING_CODE,"商品id不能为空"); }
        GoodsDesc goodsDesc = goodsDescMapper.selectGoodsDescByGoodsId(goodsId);
        return new ApiResult(SUCCESS_CODE,"商品详情获取成功",goodsDesc);
    }
}
