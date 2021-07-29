package com.brodog.mall.app.controller;


import com.brodog.mall.app.dto.user.UserDto;
import com.brodog.mall.app.dto.user.UserPasswordDto;
import com.brodog.mall.app.form.user.UserAddForm;
import com.brodog.mall.app.form.user.UserLoginForm;
import com.brodog.mall.app.service.impl.UserServiceImpl;
import com.brodog.mall.common.entity.ApiResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author By-Lin
 * @since 2021-07-01
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserServiceImpl service;

    public UserController(UserServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ApiResult register(@Valid @RequestBody UserAddForm userAddForm) {
        return service.registerUser(userAddForm);
    }

    @PostMapping("/login")
    public ApiResult login(@Valid @RequestBody UserLoginForm userLoginForm) {
        return service.login(userLoginForm);
    }

    @PostMapping("/edit")
    public ApiResult edit(@Valid @RequestBody UserDto userDto) {
        return service.updateUser(userDto);
    }

    @PostMapping("/editPassword")
    public ApiResult editPassword(@Valid @RequestBody UserPasswordDto userPasswordDto) {
        return service.updatePassword(userPasswordDto);
    }
}

