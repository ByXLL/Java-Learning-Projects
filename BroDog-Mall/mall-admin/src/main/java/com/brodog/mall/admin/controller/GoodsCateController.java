package com.brodog.mall.admin.controller;


import com.brodog.mall.admin.dto.goods.GoodsCateAddDto;
import com.brodog.mall.admin.dto.goods.GoodsCateEditDto;
import com.brodog.mall.admin.service.GoodsCateService;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.PagerParam;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

/**
 * <p>
 * 商品分类 前端控制器
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
@RestController
@RequestMapping("/goodsCate")
public class GoodsCateController {
    private final GoodsCateService goodsCateService;

    public GoodsCateController(GoodsCateService goodsCateService) {
        this.goodsCateService = goodsCateService;
    }


    @PostMapping("/add")
    public ApiResult add(@Valid @RequestBody GoodsCateAddDto goodsCateAddDto) {
        return goodsCateService.insert(goodsCateAddDto);
    }

    @PostMapping("/del")
    public ApiResult delete(@PathParam("id") Long id) {
        return goodsCateService.delete(id);
    }

    @PostMapping("/update")
    public ApiResult update(@Valid @RequestBody GoodsCateEditDto goodsCateEditDto) {
        return goodsCateService.update(goodsCateEditDto);
    }

    @GetMapping("/getList")
    public ApiResult selectPage(PagerParam pagerParam, @PathParam("name") String name) {
        return goodsCateService.selectByPage(pagerParam, name);
    }

    @GetMapping("/getById")
    public ApiResult selectById(@PathParam("id") Long id) {
        return goodsCateService.selectById(id);
    }
}

