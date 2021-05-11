package com.brodog.mall.admin.controller;


import com.brodog.mall.admin.dto.goods.GoodsAttrAddDto;
import com.brodog.mall.admin.dto.goods.GoodsAttrValueAddDto;
import com.brodog.mall.admin.dto.goods.GoodsAttrValueEditDto;
import com.brodog.mall.admin.service.GoodsAttrValueService;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.PagerParam;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

/**
 * <p>
 * 商品属性-属性值表 前端控制器
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
@RestController
@RequestMapping("/goodsAttrValue")
public class GoodsAttrValueController {
    private final GoodsAttrValueService service;

    public GoodsAttrValueController(GoodsAttrValueService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ApiResult add(@Valid @RequestBody GoodsAttrValueAddDto goodsAttrValueAddDto) {
        return service.insert(goodsAttrValueAddDto);
    }

    @PostMapping("/del")
    public ApiResult delete(@PathParam("id") Long id) {
        return service.delete(id);
    }

    @PostMapping("/update")
    public ApiResult update(@Valid @RequestBody GoodsAttrValueEditDto goodsAttrValueEditDto) {
        return service.update(goodsAttrValueEditDto);
    }

    @GetMapping("/getList")
    public ApiResult selectPage(PagerParam pagerParam) {
        return service.selectByPage(pagerParam);
    }

    @GetMapping("/getById")
    public ApiResult selectById(@PathParam("id") Long id) {
        return service.selectById(id);
    }

    @GetMapping("/getByAttrId")
    public ApiResult selectByAttrId(@PathParam("attrId") Long attrId) {
        return service.selectByAttrId(attrId);
    }
}

