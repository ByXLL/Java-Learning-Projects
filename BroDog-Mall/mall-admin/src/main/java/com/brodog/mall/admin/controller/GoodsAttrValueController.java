package com.brodog.mall.admin.controller;


import com.brodog.mall.admin.dto.goods.GoodsAttrValueDto;
import com.brodog.mall.admin.service.GoodsAttrValueService;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.PagerParam;
import com.brodog.mall.common.exception.ArgException;
import org.springframework.validation.BindingResult;
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
    public ApiResult add(@Valid @RequestBody GoodsAttrValueDto goodsAttrValueDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) { throw new ArgException(); }
        return service.insert(goodsAttrValueDto);
    }

    @PostMapping("/del")
    public ApiResult delete(@PathParam("id") Long id) {
        return service.delete(id);
    }

    @PostMapping("/update")
    public ApiResult update(@RequestBody GoodsAttrValueDto goodsAttrValueDto) {
        return service.update(goodsAttrValueDto);
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

