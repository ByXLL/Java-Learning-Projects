package com.example.phone_store_api.service;

import com.example.phone_store_api.vo.goodsinfo.GoodsInfoVO;
import com.example.phone_store_api.vo.goodsspecs.SpecsPackageVO;

import java.util.List;

/**
 * 商品service 接口
 * @author By-Lin
 */
public interface GoodsServiceInterface {
    /**
     * 通过商品分类 获取商品信息集合
     * @param categoryId    分类id
     * @return              商品信息集合
     */
    List<GoodsInfoVO> findGoodsInfoByCategoryType(Integer categoryId);

    /**
     * 通过商品id 获取具体规格
     * @param goodsId   商品id
     * @return          商品 规格 vo
     */
    SpecsPackageVO findSpecsByGoodsId(Integer goodsId);

    /**
     * 减库存
     * @param specsId       规格id
     * @param quantity      购买个数
     */
    void subStock(Integer specsId, Integer quantity);
}
