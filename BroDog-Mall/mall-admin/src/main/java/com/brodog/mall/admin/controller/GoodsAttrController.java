package com.brodog.mall.admin.controller;


import com.brodog.mall.admin.dto.goods.GoodsAttrDto;
import com.brodog.mall.admin.service.impl.GoodsAttrServiceImpl;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.exception.ArgException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
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
    public ApiResult add(@Valid @RequestBody GoodsAttrDto goodsAttrDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println(goodsAttrDto);
            log.warn("【添加商品参数】 参数错误,goodsAttrForm={}", goodsAttrDto);
            throw new ArgException("参数异常");
        }
        return goodsAttrService.insert(goodsAttrDto);
    }

    @GetMapping("/listByName")
    public ApiResult selectAllByName(@PathParam("name") String name) {
        return goodsAttrService.selectByName(name);
    }

    @GetMapping("/list")
    public ApiResult selectAll() {
        return goodsAttrService.selectAll();
    }
}

