package com.example.mall.dao;

import com.example.mall.dto.goodspic.GoodsPicDto;
import com.example.mall.entity.GoodsMainPics;
import com.example.mall.entity.GoodsSubPics;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品大图 mapper 接口
 * @author By-Lin
 */
@Mapper
public interface GoodsMainPicMapper {
    /**
     * 插入 商品大图 mapper 接口
     * @param goodsPicDto      商品图片dto
     * @return                 影响行数
     */
    int insertGoodsMainPic(GoodsPicDto goodsPicDto);


    /**
     * 编辑 商品大图 mapper 接口
     * @param goodsPicDto       商品图片dto
     * @return                  影响行数
     */
    int updateGoodsMainPic(GoodsPicDto goodsPicDto);

    /**
     * 查询 商品大图 mapper 接口
     * @param goodsId           商品ID
     * @return                  商品 大图 实体
     */
    GoodsMainPics selectGoodsMainPic(Integer goodsId);

}
