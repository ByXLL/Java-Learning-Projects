package com.brodog.mall.admin.controller;


import com.brodog.mall.admin.dto.goods.GoodsAttrAddDto;
import com.brodog.mall.admin.dto.goods.GoodsAttrEditDto;
import com.brodog.mall.admin.service.GoodsAttrService;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.PagerParam;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

/**
 * <p>
 * 商品属性表 前端控制器
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
@RestController
@RequestMapping("/goodsAttr")
public class GoodsAttrController {
    private final GoodsAttrService service;

    public GoodsAttrController(GoodsAttrService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ApiResult add(@Valid @RequestBody GoodsAttrAddDto goodsAttrAddDto) {
        return service.insert(goodsAttrAddDto);
    }

    @PostMapping("/del")
    public ApiResult delete(@PathParam("id") Long id) {
        return service.delete(id);
    }

    @PostMapping("/update")
    public ApiResult update(@Valid @RequestBody GoodsAttrEditDto goodsAttrEditDto) {
        return service.update(goodsAttrEditDto);
    }

//    @GetMapping("/list")
//    public ApiResult selectPage(PagerParam pagerParam) {
//        return service.selectByPage(pagerParam);
//    }

    @GetMapping("/getById")
    public ApiResult selectById(@PathParam("id") Long id) {
        return service.selectById(id);
    }

    @GetMapping("/getByAttrCateId")
    public ApiResult selectByAttrId(@PathParam("attrCateId") Long attrCateId) {
        return service.selectByAttrCateId(attrCateId);
    }
}

