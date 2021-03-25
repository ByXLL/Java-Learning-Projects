package com.example.mall.controller.admin;

import com.example.mall.annotation.PassTokenRequired;
import com.example.mall.data.ApiResult;
import com.example.mall.dto.user.*;
import com.example.mall.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * 用户控制器
 * @author By-Lin
 */
@ResponseBody
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PassTokenRequired
    @PostMapping("/addUser")
    public ApiResult insertUser(UserAddDto userAddDto) {
        return userService.insertUser(userAddDto);
    }

    @PassTokenRequired
    @PostMapping("/login")
    public ApiResult login(UserLoginDto userLoginDto) {
        return userService.login(userLoginDto);
    }

    @PostMapping("/del")
    public ApiResult deleteUser(@PathParam("id") Integer id) {
        return userService.deleteUser(id);
    }

    @PostMapping("/update")
    public ApiResult updateUser(UserEditDto userEditDto) {
        return userService.updateUser(userEditDto);
    }

    @PostMapping("/updateUserStatus")
    public ApiResult updateUserStatus(UserEditStatusDto userEditStatusDto) {
        return userService.updateUserStatus(userEditStatusDto);
    }

    @PostMapping("/updateUserPassword")
    public ApiResult updateUserPassword(UserEditPassWordDto userEditPassWordDto) {
        return userService.updateUserPassword(userEditPassWordDto);
    }

    @GetMapping("/getUser")
    public ApiResult getUser(UserSelectDto userSelectDto) {
        System.out.println(userSelectDto);
        return userService.findUser(userSelectDto);
    }

    @GetMapping("/getUserById")
    public ApiResult getUser(@PathParam("id") Integer id) {
        return userService.findUserById(id);
    }

    @GetMapping("/getUserByUserName")
    public ApiResult getUser(@PathParam("userName") String userName) {
        return userService.findUserByUserName(userName);
    }
}
