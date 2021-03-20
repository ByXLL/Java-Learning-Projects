package com.demo.blog.controller;

import com.demo.blog.annotation.LoginTokenRequired;
import com.demo.blog.annotation.PassTokenRequired;
import com.demo.blog.data.ApiResult;
import com.demo.blog.entity.User;
import com.demo.blog.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * 用户模块 控制器
 * @author By-Lin
 */
@ResponseBody
@RestController
@RequestMapping("/user")
public class UserController extends ApiController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 登录
     * @param user      用户实体
     * @return          响应数据
     */
    @PassTokenRequired
    @PostMapping("/login")
    public ApiResult Login(User user) {
        return userService.login(user);
    }

    /**
     * 通过用户id 获取用户信息
     * @param userId    用户id
     * @return          响应体
     */
    @GetMapping("/{userId}")
    public ApiResult getUserInfo(@PathVariable Integer userId) {
        return userService.findUserById(userId);
    }

    /**
     * 通过实体字段 获取用户信息
     * @param user  用户实体
     * @return      响应数据
     */
    @GetMapping("/getUserInfo")
    public ApiResult getUserByUserName(User user) { return userService.findUser(user); }

    /**
     * 注册用户
     * @param user      用户信息
     * @return          响应体
     */
    @PassTokenRequired
    @PostMapping("/registerUser")
    public ApiResult registerUser(User user) { return userService.register(user); }

    /**
     * 更新用户状态值
     * @param userId    用户id
     * @param status    用户状态
     * @return          响应数据
     */
    @PostMapping("/updateUserStatus")
    public ApiResult updateUserStatus(@PathParam("userId") Integer userId, @PathParam("status") Integer status ) {
        return userService.updateUserStatus(userId,status);
    }

    /**
     * 更新用户 密码
     * @param userId        用户id
     * @param password      密码
     * @return
     */
    @PostMapping("/updateUserPassword")
    public ApiResult updateUserPassword(@PathParam("userId") Integer userId, @PathParam("password") String password) {
        return userService.updateUserPassword(userId,password);
    }

    /**
     * 更改用户 头像
     * @param userId    用户id
     * @param avatar    头像url地址
     * @return          响应数据
     */
    @PostMapping("/updateUserAvatar")
    public ApiResult updateUserAvatar(@PathParam("userId") Integer userId, @PathParam("avatar") String avatar) {
        return userService.updateUserAvatar(userId, avatar);
    }

    /**
     * 通过实体 更新用户 信息
     * @param user      用户实体
     * @return          响应数据
     */
    @PostMapping("/updateUser")
    public ApiResult updateUser(User user) {
        return userService.updateUser(user);
    }
}
