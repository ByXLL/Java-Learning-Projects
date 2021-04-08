package com.example.mall.dao;

import com.example.mall.dto.usercart.UserCartAddDto;
import com.example.mall.dto.usercart.UserCartEditDto;
import com.example.mall.entity.UserCart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 购物车 mapper 接口
 * @author By-Lin
 */
@Mapper
public interface UserCartMapper {
    /**
     * 添加购物车
     * @param userCartAddDto        购物车添加 dto
     * @return                      影响行数
     */
    int insertCart(UserCartAddDto userCartAddDto);

    /**
     * 移除 购物车
     * @param id    购物车id
     * @return      影响行数
     */
    int deleteCart(Integer id);

    /**
     * 编辑 购物车商品个数
     * @param userCartEditDto       购物车 编辑 dto
     * @return                      影响行数
     */
    int updateCart(UserCartEditDto userCartEditDto);

    /**
     * 通过 用户id 查询 购物车列表
     * @param userId        用户id
     * @return              购物车 实体 list
     */
    List<UserCart> selectCartByUserId(Integer userId);

    /**
     * 通过 id 查询购物车信息
     * @param id        购物车id
     * @return          购物车实体
     */
    UserCart selectCartById(Integer id);
}
