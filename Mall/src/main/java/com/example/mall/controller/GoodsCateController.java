package com.example.mall.controller;

import com.example.mall.annotation.PassTokenRequired;
import com.example.mall.data.ApiResult;
import com.example.mall.dto.goodscate.GoodsCateAddDto;
import com.example.mall.dto.goodscate.GoodsCateEditDto;
import com.example.mall.dto.goodscate.GoodsCateSelectDto;
import com.example.mall.service.GoodsCateService;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * 商品分类 控制器
 * @author By-Lin
 */
@ResponseBody
@RestController
@RequestMapping("/goodsCate")
public class GoodsCateController {
    private final GoodsCateService goodsCateService;

    public GoodsCateController(GoodsCateService goodsCateService) {
        this.goodsCateService = goodsCateService;
    }


    @PostMapping("/add")
    public ApiResult addGoodsCate(GoodsCateAddDto goodsCateAddDto) {
        return goodsCateService.insertGoodsCate(goodsCateAddDto);
    }


    @PostMapping("/del")
    public ApiResult deleteGoodsCate(@PathParam("goodsCateId") Integer goodsCateId){
        return goodsCateService.deleteGoodsCate(goodsCateId);
    }


    @PostMapping("/edit")
    public ApiResult updateGoodsCate(GoodsCateEditDto goodsCateEditDto) {
        return goodsCateService.updateGoodsCate(goodsCateEditDto);
    }

    @PassTokenRequired
    @GetMapping("/getAll")
    public ApiResult getGoodsCateAll() {
        return goodsCateService.selectAllGoodsCate();
    }

    @PassTokenRequired
    @GetMapping("/getTree")
    public ApiResult getGoodsCateTree() {
        return goodsCateService.selectAllGoodsCateTree();
    }

    @PassTokenRequired
    @GetMapping("/getCate")
    public ApiResult getGoodsCate(GoodsCateSelectDto goodsCateSelectDto) {
        return goodsCateService.selectGoodsCate(goodsCateSelectDto);
    }
}
