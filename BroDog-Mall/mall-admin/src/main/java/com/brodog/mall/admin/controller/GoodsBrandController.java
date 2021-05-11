package com.brodog.mall.admin.controller;


import com.brodog.mall.admin.dto.goods.GoodsBrandAddDto;
import com.brodog.mall.admin.dto.goods.GoodsBrandEditDto;
import com.brodog.mall.admin.service.GoodsBrandService;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.PagerParam;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

/**
 * <p>
 * 商品品牌 前端控制器
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
@RestController
@ResponseBody
@RequestMapping("/goodsBrand")
public class GoodsBrandController {
//    @RequestParam(value = "goodsAttrId",defaultValue = "0")
    private final GoodsBrandService goodsBrandService;

    public GoodsBrandController(GoodsBrandService goodsBrandService) {
        this.goodsBrandService = goodsBrandService;
    }

    @PostMapping("/add")
    public ApiResult add(@Valid @RequestBody GoodsBrandAddDto goodsBrandAddDto) {
        return goodsBrandService.insert(goodsBrandAddDto);
    }

    @PostMapping("/del")
    public ApiResult del(@PathParam("id") Long id) {
        return goodsBrandService.delete(id);
    }


    @PostMapping("/update")
    public ApiResult update(@Valid @RequestBody GoodsBrandEditDto goodsBrandEditDto) {
        return goodsBrandService.update(goodsBrandEditDto);
    }

    @GetMapping("/getList")
    public ApiResult getList(PagerParam pagerParam, String name) {
        return goodsBrandService.selectByPage(pagerParam, name);
    }

    @GetMapping("/getById")
    public ApiResult getById(@PathParam("id") Long id) {
        return goodsBrandService.selectById(id);
    }
}

