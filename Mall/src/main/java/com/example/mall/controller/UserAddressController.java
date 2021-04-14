package com.example.mall.controller;

import com.example.mall.annotation.PassTokenRequired;
import com.example.mall.data.ApiResult;
import com.example.mall.dto.useraddress.UserAddressAddDto;
import com.example.mall.dto.useraddress.UserAddressEditDto;
import com.example.mall.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * 用户地址模块 控制器
 * @author By-Lin
 */
@RestController
@ResponseBody
@RequestMapping("/userAddress")
public class UserAddressController {
    private final UserAddressService userAddressService;

    public UserAddressController(UserAddressService userAddressService) {
        this.userAddressService = userAddressService;
    }

    @PassTokenRequired
    @PostMapping("/add")
    public ApiResult addUserAddress(UserAddressAddDto dto) {
        return userAddressService.insertUserAddress(dto);
    }

    @PassTokenRequired
    @PostMapping("/del")
    public ApiResult deleteUserAddress(@PathParam("id") Integer id) {
        return userAddressService.deleteUserAddress(id);
    }

    @PassTokenRequired
    @PostMapping("/edit")
    public ApiResult editUserAddress(UserAddressEditDto dto) {
        return userAddressService.updateUserAddress(dto);
    }

    @PassTokenRequired
    @GetMapping("/getById")
    public ApiResult getUserAddressById(Integer id) {
        return userAddressService.selectUserAddressById(id);
    }
}
