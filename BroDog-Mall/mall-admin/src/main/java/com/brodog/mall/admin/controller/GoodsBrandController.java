package com.brodog.mall.admin.controller;


import com.brodog.mall.admin.dto.goods.GoodsAttrDto;
import com.brodog.mall.admin.dto.goods.GoodsBrandDto;
import com.brodog.mall.admin.service.GoodsBrandService;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.PagerParam;
import com.brodog.mall.common.exception.ArgException;
import org.springframework.validation.BindingResult;
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
    public ApiResult add(@Valid @RequestBody GoodsBrandDto goodsBrandDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) { throw new ArgException(); }
        return goodsBrandService.insert(goodsBrandDto);
    }

    @PostMapping("/del")
    public ApiResult del(@PathParam("id") Long id) {
        return new ApiResult(200,"111",id);
    }


    @PostMapping("/update")
    public ApiResult update(@RequestBody GoodsBrandDto goodsBrandDto) {
        return goodsBrandService.update(goodsBrandDto);
    }

    @GetMapping("/getList")
    public ApiResult getList(PagerParam pagerParam) {
        return goodsBrandService.selectByPage(pagerParam);
    }

    @GetMapping("/getById")
    public ApiResult getById(@PathParam("id") Long id) {
        return goodsBrandService.selectById(id);
    }
}

