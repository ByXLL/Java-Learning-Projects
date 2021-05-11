package com.brodog.mall.admin.controller;


import com.brodog.mall.admin.dto.goods.GoodsDescAddDto;
import com.brodog.mall.admin.dto.goods.GoodsDescEditDto;
import com.brodog.mall.admin.service.impl.GoodsDescServiceImpl;
import com.brodog.mall.common.entity.ApiResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

/**
 * <p>
 * 商品详情表 前端控制器
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
@RestController
@ResponseBody
@RequestMapping("/goodsDesc")
public class GoodsDescController {
    private final GoodsDescServiceImpl service;

    public GoodsDescController(GoodsDescServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ApiResult add(@Valid @RequestBody GoodsDescAddDto goodsDescAddDto) {
        return service.insert(goodsDescAddDto);
    }

    @PostMapping("/del")
    public ApiResult delete(@PathParam("id") Long id) {
        return service.delete(id);
    }

    @PostMapping("/update")
    public ApiResult update(@RequestBody GoodsDescEditDto goodsDescEditDto) {
        return service.update(goodsDescEditDto);
    }

    @GetMapping("/get")
    public ApiResult getList(@PathParam("id") Long id) {
        return service.selectById(id);
    }

    @GetMapping("/getByGoodsId")
    public ApiResult getByGoodsId(@PathParam("goodsId") Long goodsId) {
        return service.selectByGoodsId(goodsId);
    }
}

