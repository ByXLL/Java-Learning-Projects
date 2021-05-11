package com.brodog.mall.admin.controller;


import com.brodog.mall.admin.dto.goods.GoodsAttrAddDto;
import com.brodog.mall.admin.dto.goods.GoodsAttrEditDto;
import com.brodog.mall.admin.service.impl.GoodsAttrServiceImpl;
import com.brodog.mall.common.entity.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

/**
 * <p>
 * 商品-属性 前端控制器
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
@Slf4j
@ResponseBody
@RestController
@RequestMapping("/goodsAttr")
public class GoodsAttrController {
    private final GoodsAttrServiceImpl goodsAttrService;

    public GoodsAttrController(GoodsAttrServiceImpl goodsAttrService) {
        this.goodsAttrService = goodsAttrService;
    }

    @PostMapping("/add")
    public ApiResult add(@Valid @RequestBody GoodsAttrAddDto goodsAttrAddDto) {
        return goodsAttrService.insert(goodsAttrAddDto);
    }

    @PostMapping("/del")
    public ApiResult delete(@PathParam("id") Long goodsAttrId) {
        return goodsAttrService.delete(goodsAttrId);
    }

    @PostMapping("/update")
    public ApiResult update(@Valid @RequestBody GoodsAttrEditDto goodsAttrEditDto) {
        return goodsAttrService.update(goodsAttrEditDto);
    }

    @GetMapping("/listByName")
    public ApiResult selectAllByName(@PathParam("name") String name) {
        return goodsAttrService.selectByName(name);
    }

    @GetMapping("/list")
    public ApiResult selectAll() {
        return goodsAttrService.selectAll();
    }

    @GetMapping("/getById")
    public ApiResult selectById(@PathParam("id") Long goodsAttrId) {
        return goodsAttrService.selectById(goodsAttrId);
    }
}

