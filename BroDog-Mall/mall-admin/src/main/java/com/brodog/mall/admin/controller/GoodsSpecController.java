package com.brodog.mall.admin.controller;


import com.brodog.mall.admin.dto.goods.GoodsCateDto;
import com.brodog.mall.admin.dto.goods.GoodsSpecDto;
import com.brodog.mall.admin.service.impl.GoodsSpecServiceImpl;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.PagerParam;
import com.brodog.mall.common.exception.ArgException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

/**
 * <p>
 * 商品-规格 前端控制器
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
@RestController
@RequestMapping("/goodsSpec")
public class GoodsSpecController {
    private final GoodsSpecServiceImpl goodsSpecService;

    public GoodsSpecController(GoodsSpecServiceImpl goodsSpecService) {
        this.goodsSpecService = goodsSpecService;
    }

    @PostMapping("/add")
    public ApiResult add(@Valid @RequestBody GoodsSpecDto goodsSpecDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){ throw new ArgException(); }
        return goodsSpecService.insert(goodsSpecDto);
    }

    @PostMapping("/del")
    public ApiResult delete(@PathParam("id") Long id) {
        return goodsSpecService.delete(id);
    }

    @PostMapping("/update")
    public ApiResult update(@RequestBody GoodsSpecDto goodsSpecDto) {
        return goodsSpecService.update(goodsSpecDto);
    }

    @GetMapping("/getList")
    public ApiResult selectPage(PagerParam pagerParam) {
        return goodsSpecService.selectByPage(pagerParam);
    }

    @GetMapping("/getById")
    public ApiResult selectById(@PathParam("id") Long id) {
        return goodsSpecService.selectById(id);
    }

    @GetMapping("/getByAttrId")
    public ApiResult selectByAttrId(@PathParam("attrId") Long attrId) {
        return goodsSpecService.selectByAttrId(attrId);
    }
}

