package com.example.mall.controller;

import com.example.mall.annotation.PassTokenRequired;
import com.example.mall.data.ApiResult;
import com.example.mall.dto.goodsdesc.GoodsDescDto;
import com.example.mall.service.GoodsDescService;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * 商品详情 控制器
 * @author By-Lin
 */
@ResponseBody
@RestController
@RequestMapping("/goodsDesc")
public class GoodsDescController {
    private final GoodsDescService goodsDescService;

    public GoodsDescController(GoodsDescService goodsDescService) {
        this.goodsDescService = goodsDescService;
    }

    @PassTokenRequired
    @PostMapping("/edit")
    public ApiResult editGoodsDesc(GoodsDescDto goodsDescDto) {
        return goodsDescService.updateGoodsDesc(goodsDescDto);
    }

    @PassTokenRequired
    @GetMapping("/getGoodsDesc")
    public ApiResult findGoodsDesc(@PathParam("goodsId") Integer goodsId) {
        return goodsDescService.selectGoodsDescByGoodsId(goodsId);
    }
}
