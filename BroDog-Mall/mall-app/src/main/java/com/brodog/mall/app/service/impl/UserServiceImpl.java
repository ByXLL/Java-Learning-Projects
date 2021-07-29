package com.brodog.mall.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.brodog.mall.app.dto.user.UserDto;
import com.brodog.mall.app.dto.user.UserPasswordDto;
import com.brodog.mall.app.form.user.UserAddForm;
import com.brodog.mall.app.form.user.UserLoginForm;
import com.brodog.mall.app.vo.user.UserVo;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.User;
import com.brodog.mall.app.mapper.UserMapper;
import com.brodog.mall.app.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brodog.mall.common.enums.HttpCodeEnum;
import com.brodog.mall.common.exception.OperationalException;
import com.brodog.mall.common.util.CommUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static com.brodog.mall.common.util.Constants.BASE_AVATAR;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author By-Lin
 * @since 2021-07-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 添加用户
     *
     * @param userAddForm 用户添加表单实体
     * @return 响应数据
     */
    @Override
    public ApiResult registerUser(UserAddForm userAddForm) {
        User user = new User();
        BeanUtils.copyProperties(userAddForm,user);
        user.setPassword(CommUtils.getMd5(userAddForm.getPassword()));
        user.setAvatar(BASE_AVATAR);
        user.setBalance(new BigDecimal("0.00"));
        user.setIntegral(0.00);
        user.setGrowthValue(0.00);
        user.setStatus(1);
        int row = userMapper.insert(user);
        if(row > 0) { return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc()); }
        throw new OperationalException();
    }

    /**
     * 编辑用户
     *
     * @param userDto  用户dto
     * @return         响应数据
     */
    @Override
    public ApiResult updateUser(UserDto userDto) {
        User user = userMapper.selectOne(
                new QueryWrapper<User>().eq("status",1).eq("id",userDto.getId())
        );
        if(user == null) { throw new OperationalException("用户不存在"); }
        return null;
    }

    /**
     * 用户登录
     *
     * @param userLoginForm 用户登录表单
     * @return 响应数据
     */
    @Override
    public ApiResult login(UserLoginForm userLoginForm) {
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("phone",userLoginForm.getPhone()));
        if(user == null) { throw new OperationalException("用户不存在"); }
        boolean checkPassword = StringUtils.equals(CommUtils.getMd5(userLoginForm.getPassword()),user.getPassword());
        if(checkPassword) {
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(user,userVo);
            String token = CommUtils.getToken(user.getId());
            Map<String,Object> data = new HashMap(16);
            data.put("token",token);
            data.put("userInfo",userVo);
            return new ApiResult(HttpCodeEnum.SUCCESS.getCode(),"登录成功",data);
        }
        return new ApiResult(HttpCodeEnum.ERROR.getCode(), "账号密码错误");
    }

    /**
     * 修改用户密码
     *
     * @param userPasswordDto 用户密码dto
     * @return 响应数据
     */
    @Override
    public ApiResult updatePassword(UserPasswordDto userPasswordDto) {
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("status",1).eq("id",userPasswordDto.getId()));
        if(user == null) { throw new OperationalException("修改失败，当前用户不存在"); }
        if(user.getPassword().equals(CommUtils.getMd5(userPasswordDto.getOldPassword()))) {
            user.setPassword(CommUtils.getMd5(userPasswordDto.getNewPassword()));
            userMapper.updateById(user);
            return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc());
        }else {
            throw new OperationalException("修改失败，旧密码错误");
        }
    }
}
