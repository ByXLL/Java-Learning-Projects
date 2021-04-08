package com.example.mall.controller;

import com.example.mall.annotation.PassTokenRequired;
import com.example.mall.data.ApiResult;
import com.example.mall.dto.usercart.UserCartAddDto;
import com.example.mall.dto.usercart.UserCartEditDto;
import com.example.mall.service.UserCartService;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * 购物车 控制器
 * @author By-Lin
 */
@RestController
@ResponseBody
@RequestMapping("/cart")
public class UserCartController {
    private final UserCartService userCartService;

    public UserCartController(UserCartService userCartService) {
        this.userCartService = userCartService;
    }

    @PassTokenRequired
    @PostMapping("/add")
    public ApiResult addCart(UserCartAddDto dto) {
        return userCartService.insertCart(dto);
    }

    @PassTokenRequired
    @PostMapping("/del")
    public ApiResult delCart(@PathParam("id") Integer id) {
        return userCartService.deleteCartById(id);
    }

    @PassTokenRequired
    @PostMapping("/edit")
    public ApiResult editCart(UserCartEditDto dto) {
        return userCartService.updateCart(dto);
    }

    @PassTokenRequired
    @GetMapping("/getById")
    public ApiResult getById(@PathParam("id") Integer id) {
        return userCartService.selectCartById(id);
    }

    @PassTokenRequired
    @GetMapping("/getByUserId")
    public ApiResult getByUserId(@PathParam("userId") Integer userId) {
        return userCartService.selectCartByUserId(userId);
    }
}
