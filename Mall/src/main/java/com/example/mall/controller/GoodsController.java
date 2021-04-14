package com.example.mall.controller;

import com.example.mall.annotation.PassTokenRequired;
import com.example.mall.dao.GoodsMapper;
import com.example.mall.data.ApiResult;
import com.example.mall.dto.goods.GoodsAddDto;
import com.example.mall.dto.goods.GoodsEditDto;
import com.example.mall.dto.goods.GoodsSelectDto;
import com.example.mall.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * 商品控制器
 * @author By-Lin
 */
@ResponseBody
@RestController
@RequestMapping("/goods")
public class GoodsController {
    private final GoodsService goodsService;

    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @PassTokenRequired
    @PostMapping("/add")
    public ApiResult addGoods(GoodsAddDto goodsAddDto) {
        return goodsService.insertGoods(goodsAddDto);
    }

    @PassTokenRequired
    @PostMapping("/del")
    public ApiResult deleteGoods(@PathParam("goodsId") Integer goodsId) {
        return goodsService.deleteGoods(goodsId);
    }

    @PassTokenRequired
    @PostMapping("/edit")
    public ApiResult editGoods(GoodsEditDto goodsEditDto) {
        return goodsService.updateGoods(goodsEditDto);
    }

    @PassTokenRequired
    @GetMapping("/getGoods")
    public ApiResult getGoods(GoodsSelectDto goodsSelectDto) {
        return goodsService.selectGoods(goodsSelectDto);
    }

    @PassTokenRequired
    @GetMapping("/getGoodsById")
    public ApiResult getGoodsById(@PathParam("goodsId") Integer goodsId) {
        return goodsService.selectGoodsById(goodsId);
    }


    @PassTokenRequired
    @GetMapping("/getGoodsDetail")
    public ApiResult getGoodsDetail(GoodsSelectDto goodsSelectDto) {
        return goodsService.selectGoodsDetail(goodsSelectDto);
    }

    @PassTokenRequired
    @GetMapping("/getGoodsDetailById")
    public ApiResult getGoodsDetailById(@PathParam("goodsId") Integer goodsId) {
        return goodsService.selectGoodsDetailById(goodsId);
    }
}
