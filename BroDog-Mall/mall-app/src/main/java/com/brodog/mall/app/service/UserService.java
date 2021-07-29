package com.brodog.mall.app.service;

import com.brodog.mall.app.dto.user.UserDto;
import com.brodog.mall.app.dto.user.UserPasswordDto;
import com.brodog.mall.app.form.user.UserAddForm;
import com.brodog.mall.app.form.user.UserLoginForm;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author By-Lin
 * @since 2021-07-01
 */
public interface UserService extends IService<User> {

    /**
     * 注册用户
     * @param userAddForm       用户添加表单实体
     * @return                  响应数据
     */
    ApiResult registerUser(UserAddForm userAddForm);

    /**
     * 编辑用户
     * @param userDto       用户实体
     * @return              响应数据
     */
    ApiResult updateUser(UserDto userDto);

    /**
     * 用户登录
     * @param userLoginForm     用户登录表单
     * @return                  响应数据
     */
    ApiResult login(UserLoginForm userLoginForm);

    /**
     * 修改用户密码
     * @param userPasswordDto       用户密码dto
     * @return                      响应数据
     */
    ApiResult updatePassword(UserPasswordDto userPasswordDto);
}
