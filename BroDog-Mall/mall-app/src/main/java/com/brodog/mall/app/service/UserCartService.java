package com.brodog.mall.app.service;

import com.brodog.mall.app.dto.userCart.UserCartAddDto;
import com.brodog.mall.app.dto.userCart.UserCartEditDto;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.UserCart;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户购物车表 服务类
 * </p>
 *
 * @author By-Lin
 * @since 2021-07-20
 */
public interface UserCartService extends IService<UserCart> {
    /**
     * 添加购物车项
     * @param userCartAddDto        购物车添加dto
     * @return                      响应数据
     */
    ApiResult add(UserCartAddDto userCartAddDto);

    /**
     * 移除购物车
     * @param id        主键
     * @return          响应数据
     */
    ApiResult delete(Long id);

    /**
     * 修改购物车个数
     * @param userCartEditDto       购物车编辑 dto
     * @return                      响应数据
     */
    ApiResult updateCount(UserCartEditDto userCartEditDto);

    /**
     * 查询当前用户的购物车列表
     * @param userId        用户id
     * @return              响应数据
     */
    ApiResult selectList(Long userId);
}
