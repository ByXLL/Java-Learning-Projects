package com.brodog.mall.app.controller;


import com.brodog.mall.app.form.goods.GoodsSelectParam;
import com.brodog.mall.app.service.impl.GoodsServiceImpl;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.PagerParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author By-Lin
 * @since 2021-07-01
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    private final GoodsServiceImpl goodsService;

    public GoodsController(GoodsServiceImpl goodsService) {
        this.goodsService = goodsService;
    }

    @GetMapping("/getHotList")
    public ApiResult getHotList(PagerParam pagerParam) {
        return goodsService.selectHotList(pagerParam);
    }

    @GetMapping("/getByParam")
    public ApiResult getByParam(GoodsSelectParam goodsSelectParam) {
        return goodsService.selectByParam(goodsSelectParam);
    }

    @GetMapping("/getById")
    public ApiResult getById(@PathParam("goodsId") Long goodsId) {
        return goodsService.selectById(goodsId);
    }
}

