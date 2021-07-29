package com.brodog.mall.app.mapper;

import com.brodog.mall.app.vo.userCart.UserCartVo;
import com.brodog.mall.common.entity.UserCart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 用户购物车表 Mapper 接口
 * </p>
 *
 * @author By-Lin
 * @since 2021-07-20
 */
@Repository
public interface UserCartMapper extends BaseMapper<UserCart> {
    /**
     * 通过用户id 获取购物车列表
     * @param userId        用户id
     * @return              购物车vo 列表
     */
    List<UserCartVo> selectListByUserId(Long userId);
}
