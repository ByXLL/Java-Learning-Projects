package com.example.phone_store_api.controller;

import com.example.phone_store_api.service.impl.GoodsService;
import com.example.phone_store_api.utils.ApiResultUtil;
import com.example.phone_store_api.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

/**
 * 商品 handler
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

    @GetMapping("/findByCategoryType/{categoryId}")
    public ResultVO findByCategoryType(@PathVariable("categoryId") Integer categoryId) {
        return ApiResultUtil.success(goodsService.findGoodsInfoByCategoryType(categoryId));
    }

    @GetMapping("/findSpecsByGoodsId/{goodsId}")
    public ResultVO findSpecsByGoodsId(@PathVariable Integer goodsId) {
        return ApiResultUtil.success(goodsService.findSpecsByGoodsId(goodsId));
    }
}
