package com.brodog.mall.admin.controller;


import com.brodog.mall.admin.dto.goods.GoodsAttrValueAddDto;
import com.brodog.mall.admin.service.impl.GoodsAttrValueServiceImpl;
import com.brodog.mall.common.entity.ApiResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

/**
 * <p>
 * 商品属性-属性值表 前端控制器
 * </p>
 *
 * @author By-Lin
 * @since 2021-05-24
 */
@RestController
@RequestMapping("/goodsAttrValue")
public class GoodsAttrValueController {
    private final GoodsAttrValueServiceImpl service;

    public GoodsAttrValueController(GoodsAttrValueServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ApiResult add(@Valid @RequestBody GoodsAttrValueAddDto goodsAttrValueAddDto) {
        return service.insert(goodsAttrValueAddDto);
    }

    @PostMapping("/delById")
    public ApiResult deleteById(@PathParam("id") Long id) {
        return service.deleteById(id);
    }

    @PostMapping("/delByAttrId")
    public ApiResult delete(@PathParam("attrId") Long attrId) {
        return service.deleteByAttrId(attrId);
    }

    @PostMapping("/deleteByGoodsId")
    public ApiResult deleteByGoodsId(@PathParam("goodsId") Long goodsId) {
        return service.deleteByGoodsId(goodsId);
    }

    @GetMapping("/getById")
    public ApiResult selectById(@PathParam("id") Long id) {
        return service.selectById(id);
    }

    @GetMapping("/getByGoodsId")
    public ApiResult selectByGoodsId(@PathParam("goodsId") Long goodsId) {
        return service.selectByGoodsId(goodsId);
    }
}

