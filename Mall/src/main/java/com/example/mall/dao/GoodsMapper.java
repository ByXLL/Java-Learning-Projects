package com.example.mall.dao;

import com.example.mall.dto.goods.GoodsEditDto;
import com.example.mall.dto.goods.GoodsSelectDto;
import com.example.mall.entity.Goods;
import com.example.mall.vo.GoodsDetailVO;
import com.example.mall.vo.GoodsVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 商品 mapper 接口
 * @author By-Lin
 */
@Mapper
public interface GoodsMapper {
    /**
     * 插入 商品 mapper 接口
     * @param goods      商品dto
     * @return                     影响行数
     */
    int insertGoods(Goods goods);

    /**
     * 删除 商品 mapper 接口
     * @param goodsId       商品id
     * @return              影响行数
     */
    int deleteGoods(Integer goodsId);

    /**
     * 编辑 商品 mapper 接口
     * @param GoodsEditDto      商品编辑dto
     * @return                  影响行数
     */
    int updateGoods(GoodsEditDto GoodsEditDto);

    /**
     * 查询 商品 mapper 接口
     * @param goodsSelectDto    商品查询dto
     * @return                  商品vo 数组
     */
    List<GoodsVO> selectGoods(GoodsSelectDto goodsSelectDto);

    /**
     * 通过 商品id 查询商品 mapper接口
     * @param goodsId           商品id
     * @return                  商品 vo
     */
    GoodsVO selectGoodsById(Integer goodsId);

    /**
     * 查询商品个数
     * @param goodsSelectDto    商品查询dto
     * @return                  个数
     */
    Integer selectGoodsCount(GoodsSelectDto goodsSelectDto);

    /**
     * 查询 商品详情 mapper 接口
     * @param goodsSelectDto        商品查询dto
     * @return                      商品详情 list
     */
    List<GoodsDetailVO> selectGoodsDetail(GoodsSelectDto goodsSelectDto);

    /**
     * 通过 商品id  商品详情 mapper 接口
     * @param goodsId       商品id
     * @return              商品详情 list
     */
    GoodsDetailVO selectGoodsDetailById(Integer goodsId);
}
