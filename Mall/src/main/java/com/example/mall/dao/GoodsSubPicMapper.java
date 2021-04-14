package com.example.mall.dao;

import com.example.mall.dto.goodspic.GoodsPicDto;
import com.example.mall.entity.GoodsSubPics;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品小图 mapper 接口
 * @author By-Lin
 */
@Mapper
public interface GoodsSubPicMapper {
    /**
     * 插入 商品小图 mapper 接口
     * @param goodsPicDto      商品图片dto
     * @return                 影响行数
     */
    int insertGoodsSubPic(GoodsPicDto goodsPicDto);


    /**
     * 编辑 商品小图 mapper 接口
     * @param goodsPicDto       商品图片dto
     * @return                  影响行数
     */
    int updateGoodsSubPic(GoodsPicDto goodsPicDto);

    /**
     * 查询 商品小图 mapper 接口
     * @param goodsId           商品ID
     * @return                  商品 小图 实体
     */
    GoodsSubPics selectGoodsSubPic(Integer goodsId);

}
