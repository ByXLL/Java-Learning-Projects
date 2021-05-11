package com.brodog.mall.admin.controller;


import com.brodog.mall.admin.dto.goods.GoodsPicsAddDto;
import com.brodog.mall.admin.dto.goods.GoodsPicsEditDto;
import com.brodog.mall.admin.service.impl.GoodsPicsServiceImpl;
import com.brodog.mall.common.entity.ApiResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
@RestController
@RequestMapping("/goodsPics")
public class GoodsPicsController {
    private final GoodsPicsServiceImpl service;

    public GoodsPicsController(GoodsPicsServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ApiResult add(@Valid GoodsPicsAddDto goodsPicsAddDto){
        return service.insert(goodsPicsAddDto);
    }

    @PostMapping("/del")
    public ApiResult delete(@PathParam("id") Long id) {
        return service.delete(id);
    }

}

