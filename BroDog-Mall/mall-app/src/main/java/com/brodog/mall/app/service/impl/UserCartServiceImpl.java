package com.brodog.mall.app.service.impl;

import com.brodog.mall.app.dto.userCart.UserCartAddDto;
import com.brodog.mall.app.dto.userCart.UserCartEditDto;
import com.brodog.mall.app.mapper.UserMapper;
import com.brodog.mall.app.vo.userCart.UserCartVo;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.User;
import com.brodog.mall.common.entity.UserCart;
import com.brodog.mall.app.mapper.UserCartMapper;
import com.brodog.mall.app.service.UserCartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brodog.mall.common.enums.HttpCodeEnum;
import com.brodog.mall.common.exception.ArgException;
import com.brodog.mall.common.exception.OperationalException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户购物车表 服务实现类
 * </p>
 *
 * @author By-Lin
 * @since 2021-07-20
 */
@Service
public class UserCartServiceImpl extends ServiceImpl<UserCartMapper, UserCart> implements UserCartService {
    private final UserCartMapper userCartMapper;
    private final UserMapper userMapper;

    public UserCartServiceImpl(UserCartMapper userCartMapper, UserMapper userMapper) {
        this.userCartMapper = userCartMapper;
        this.userMapper = userMapper;
    }

    /**
     * 添加购物车项
     * @param userCartAddDto 购物车添加dto
     * @return 响应数据
     */
    @Override
    public ApiResult add(UserCartAddDto userCartAddDto) {
        UserCart userCart = new UserCart();
        BeanUtils.copyProperties(userCartAddDto,userCart);
        userCartMapper.insert(userCart);
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), "加入购物车成功");
    }

    /**
     * 移除购物车
     * @param id 主键
     * @return 响应数据
     */
    @Override
    public ApiResult delete(Long id) {
        if(id == null) { throw new ArgException("id不能为空"); }
        UserCart userCart = userCartMapper.selectById(id);
        if(userCart == null) { throw new OperationalException("移出购物车失败"); }
        int row = userCartMapper.deleteById(id);
        if(row > 0) { return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc()); }
        throw new OperationalException("移出购物车失败");
    }

    /**
     * 修改购物车个数
     * @param userCartEditDto 购物车编辑 dto
     * @return 响应数据
     */
    @Override
    public ApiResult updateCount(UserCartEditDto userCartEditDto) {
        UserCart userCart = userCartMapper.selectById(userCartEditDto.getId());
        if(userCart == null) { throw new OperationalException("购物车不存在"); }
        if(userCartEditDto.getCount() < 1) { throw new OperationalException(); }
        userCart.setCount(userCartEditDto.getCount());
        userCartMapper.updateById(userCart);
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc());
    }

    /**
     * 查询当前用户的购物车列表
     * @param userId 用户id
     * @return 响应数据
     */
    @Override
    public ApiResult selectList(Long userId) {
        if(userId == null) { throw new ArgException("用户id不能为空"); }
        User user = userMapper.selectById(userId);
        if(user == null) { throw new OperationalException(); }
        List<UserCartVo> userCartVoList = userCartMapper.selectListByUserId(userId);
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(),userCartVoList);
    }
}
