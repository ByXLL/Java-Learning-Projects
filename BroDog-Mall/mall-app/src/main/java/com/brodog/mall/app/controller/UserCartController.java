package com.brodog.mall.app.controller;


import com.brodog.mall.app.dto.userCart.UserCartAddDto;
import com.brodog.mall.app.dto.userCart.UserCartEditDto;
import com.brodog.mall.app.service.impl.UserCartServiceImpl;
import com.brodog.mall.common.entity.ApiResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

/**
 * <p>
 * 用户购物车表 前端控制器
 * </p>
 *
 * @author By-Lin
 * @since 2021-07-20
 */
@RestController
@RequestMapping("/userCart")
public class UserCartController {
    private final UserCartServiceImpl userCartService;

    public UserCartController(UserCartServiceImpl userCartService) {
        this.userCartService = userCartService;
    }

    @PostMapping("/add")
    public ApiResult add(@Valid @RequestBody UserCartAddDto userCartAddDto) {
        return userCartService.add(userCartAddDto);
    }

    @PostMapping("/del")
    public ApiResult delete(@PathParam("id") Long id) {
        return userCartService.delete(id);
    }

    @PostMapping("/edit")
    public ApiResult edit(@Valid @RequestBody UserCartEditDto userCartEditDto) {
        return userCartService.updateCount(userCartEditDto);
    }

    @GetMapping("/getList")
    public ApiResult getList(@PathParam("userId") Long userId) {
        return userCartService.selectList(userId);
    }
}

