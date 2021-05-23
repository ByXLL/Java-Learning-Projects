package com.brodog.mall.admin.controller;


import com.brodog.mall.admin.dto.goods.GoodsSkuAddDto;
import com.brodog.mall.admin.dto.goods.GoodsSkuEditDto;
import com.brodog.mall.admin.service.impl.GoodsSkuServiceImpl;
import com.brodog.mall.common.entity.ApiResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

/**
 * <p>
 * 商品SKU表 前端控制器
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
@RestController
@RequestMapping("/goodsSku")
public class GoodsSkuController {
    private final GoodsSkuServiceImpl service;

    public GoodsSkuController(GoodsSkuServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ApiResult add(@Valid GoodsSkuAddDto goodsSkuAddDto) {
        return service.insert(goodsSkuAddDto);
    }

    @PostMapping("/del")
    public ApiResult delete(@PathParam("id") Long id) {
        return service.delete(id);
    }

    @PostMapping("/delByGoodsId")
    public ApiResult deleteByGoodsId(@PathParam("goodsId") Long goodsId) {
        return service.selectByGoodsId(goodsId);
    }

    @PostMapping("/update")
    public ApiResult update(@Valid @RequestBody GoodsSkuEditDto goodsSkuEditDto) {
        return service.update(goodsSkuEditDto);
    }

    @GetMapping("/getById")
    public ApiResult selectById(@PathParam("id") Long id) {
        return service.selectById(id);
    }

    @GetMapping("/getByGoodsId")
    public ApiResult selectByGoodsId(@PathParam("goodsId") Long goodsId) {
        return service.selectByGoodsId(goodsId);
    }

    @GetMapping("/getBySkuNumber")
    public ApiResult selectBySkuNumber(@PathParam("skuNumber") Integer skuNumber) {
        return service.selectBySkuNumber(skuNumber);
    }
}

