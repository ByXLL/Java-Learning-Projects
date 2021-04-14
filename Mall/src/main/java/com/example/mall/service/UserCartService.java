package com.example.mall.service;

import com.example.mall.dao.GoodsMapper;
import com.example.mall.dao.UserCartMapper;
import com.example.mall.data.ApiResult;
import com.example.mall.dto.usercart.UserCartAddDto;
import com.example.mall.dto.usercart.UserCartEditDto;
import com.example.mall.entity.UserCart;
import com.example.mall.utils.Constants;
import com.example.mall.vo.GoodsDetailVO;
import com.example.mall.vo.UserCartGoodsVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 购物车 service 层
 * @author By-Lin
 */
@Service
public class UserCartService implements Constants {
    private final UserCartMapper userCartMapper;
    private final GoodsMapper goodsMapper;


    public UserCartService(UserCartMapper userCartMapper, GoodsMapper goodsMapper) {
        this.userCartMapper = userCartMapper;
        this.goodsMapper = goodsMapper;
    }

    /**
     * 加入购物车
     * @param dto       添加购物车 dto
     * @return          响应数据
     */
    public ApiResult insertCart(UserCartAddDto dto) {
        if(dto == null) { return new ApiResult(WARNING_CODE,"参数不能为空"); }
        if(dto.getGoodsId() == null) { return new ApiResult(WARNING_CODE,"商品id不能为空"); }
        if(dto.getUserId() == null) { return new ApiResult(WARNING_CODE,"用户id不能为空"); }
        if(dto.getGoodsCount() == null || dto.getGoodsCount() < 1) { return new ApiResult(WARNING_CODE,"商品个数不能为空"); }

        UserCart userCart = userCartMapper.selectCartById(dto.getGoodsId());
        if(userCart != null) {
            UserCartEditDto userCartEditDto = new UserCartEditDto();
            userCartEditDto.setId(userCart.getId());
            userCartEditDto.setGoodsCount(userCart.getGoodsCount() + dto.getGoodsCount());
            int resultRow = userCartMapper.updateCart(userCartEditDto);
            if(resultRow > 0) { return new ApiResult(SUCCESS_CODE,"加入购物车成功"); }
            return new ApiResult(ERROR_CODE,"加入购物车失败");
        }
        int row = userCartMapper.insertCart(dto);
        if(row > 0) { return new ApiResult(SUCCESS_CODE,"加入购物车成功"); }
        return new ApiResult(ERROR_CODE,"加入购物车失败");
    }

    /**
     * 移出购物车
     * @param id    购物车id
     * @return      响应数据
     */
    public ApiResult deleteCartById(Integer id) {
        if(id == null) { return new ApiResult(WARNING_CODE,"id不能为空"); }
        int row = userCartMapper.deleteCart(id);
        if(row > 0) { return new ApiResult(SUCCESS_CODE,"移出购物车成功"); }
        return new ApiResult(ERROR_CODE,"移除购物车失败");
    }

    /**
     * 更新 购物车
     * @param dto       编辑购物车 dto
     * @return          响应数据
     */
    public ApiResult updateCart(UserCartEditDto dto) {
        if(dto == null) { return new ApiResult(WARNING_CODE,"参数不能为空"); }
        if(dto.getId() == null) { return new ApiResult(WARNING_CODE,"id不能为空"); }
        if(dto.getGoodsCount() == null || dto.getGoodsCount() < 1) { return new ApiResult(WARNING_CODE,"商品个数不能为空"); }
        UserCart userCart = userCartMapper.selectCartById(dto.getId());
        if(userCart == null) { return new ApiResult(WARNING_CODE,"购物车不存在"); }
        int row = userCartMapper.updateCart(dto);
        if(row > 0) { return new ApiResult(SUCCESS_CODE,"修改购物车成功"); }
        return new ApiResult(ERROR_CODE,"修改购物车失败");
    }

    /**
     * 查询购物车  详情
     * @param id    购物车id
     * @return      响应数据
     */
    public ApiResult selectCartById(Integer id) {
        if(id == null) { return new ApiResult(WARNING_CODE,"id不能为空"); }
        UserCart userCart = userCartMapper.selectCartById(id);
        if(userCart == null) { return new ApiResult(WARNING_CODE,"购物车不存在"); }
        GoodsDetailVO goodsDetailVO = goodsMapper.selectGoodsDetailById(userCart.getGoodsId());
        if(goodsDetailVO == null) { return new ApiResult(WARNING_CODE,"当前商品已下架"); }

        UserCartGoodsVO userCartGoodsVO = new UserCartGoodsVO();
        userCartGoodsVO.setCartId(userCart.getId());
        userCartGoodsVO.setGoodsInfo(goodsDetailVO);
        userCartGoodsVO.setCount(userCart.getGoodsCount());

        return new ApiResult(SUCCESS_CODE,"获取购物车商品详情成功",userCartGoodsVO);
    }

    /**
     * 查询 用户购物车
     * @param userId        用户id
     * @return              响应数据
     */
    public ApiResult selectCartByUserId(Integer userId) {
        if(userId == null) { return new ApiResult(WARNING_CODE,"用户id不能为空"); }
        List<UserCart> userCartList = userCartMapper.selectCartByUserId(userId);
        return new ApiResult(SUCCESS_CODE,"数据获取成功",userCartList);
    }
}
