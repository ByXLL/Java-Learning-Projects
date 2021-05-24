package com.brodog.mall.admin.controller;


import com.brodog.mall.admin.dto.goods.GoodsAttrCateAddDto;
import com.brodog.mall.admin.dto.goods.GoodsAttrCateEditDto;
import com.brodog.mall.admin.service.impl.GoodsAttrCateServiceImpl;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.PagerParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

/**
 * <p>
 * 商品-属性分类 前端控制器
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
@Slf4j
@ResponseBody
@RestController
@RequestMapping("/goodsAttrCate")
public class GoodsAttrCateController {
    private final GoodsAttrCateServiceImpl goodsAttrService;

    public GoodsAttrCateController(GoodsAttrCateServiceImpl goodsAttrService) {
        this.goodsAttrService = goodsAttrService;
    }

    @PostMapping("/add")
    public ApiResult add(@Valid @RequestBody GoodsAttrCateAddDto goodsAttrCateAddDto) {
        return goodsAttrService.insert(goodsAttrCateAddDto);
    }

    @PostMapping("/del")
    public ApiResult delete(@PathParam("id") Long id) {
        return goodsAttrService.delete(id);
    }

    @PostMapping("/update")
    public ApiResult update(@Valid @RequestBody GoodsAttrCateEditDto goodsAttrCateEditDto) {
        return goodsAttrService.update(goodsAttrCateEditDto);
    }

    @GetMapping("/listByName")
    public ApiResult selectAllByName(@PathParam("name") String name) {
        return goodsAttrService.selectByName(name);
    }

    @GetMapping("/list")
    public ApiResult selectAll(PagerParam pagerParam, String name) {
        return goodsAttrService.selectByPage(pagerParam, name);
    }

    @GetMapping("/getById")
    public ApiResult selectById(@PathParam("id") Long id) {
        return goodsAttrService.selectById(id);
    }
}

