package com.example.mall.dao;

import com.example.mall.dto.goods.GoodsDelDto;
import com.example.mall.dto.goods.GoodsDto;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品 mapper 接口
 * @author By-Lin
 */
@Mapper
public interface GoodsMapper {
    /**
     * 插入 商品 mapper 接口
     * @param goodsDto      商品dto
     * @return              影响行数
     */
    int insertGoods(GoodsDto goodsDto);

    /**
     * 删除 商品 mapper 接口
     * @param goodsDelDto   删除商品dto
     * @return              影响行数
     */
    int deleteGoods(GoodsDelDto goodsDelDto);


}
