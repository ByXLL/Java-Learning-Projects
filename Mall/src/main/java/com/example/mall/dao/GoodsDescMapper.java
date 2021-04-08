package com.example.mall.dao;

import com.example.mall.dto.goodsdesc.GoodsDescDto;
import com.example.mall.entity.GoodsDesc;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品详情 mapper
 * @author By-Lin
 */
@Mapper
public interface GoodsDescMapper {
    /**
     * 添加
     * @param goodsDescDto       商品添加 dto
     * @return                      影响行数
     */
    int insertGoodsDesc(GoodsDescDto goodsDescDto);

    /**
     * 更新商品详情
     * @param goodsDescDto      商品编辑 dto
     * @return                      影响行数
     */
    int updateGoodsDesc(GoodsDescDto goodsDescDto);

    /**
     * 通过 商品id 获取商品
     * @param goodsId        商品id
     * @return              商品详情实体
     */
    GoodsDesc selectGoodsDescByGoodsId(Integer goodsId);
}
