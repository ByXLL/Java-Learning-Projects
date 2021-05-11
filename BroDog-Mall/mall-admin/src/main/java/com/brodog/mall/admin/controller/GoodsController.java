package com.brodog.mall.admin.controller;


import com.brodog.mall.admin.form.goods.GoodsAddForm;
import com.brodog.mall.admin.form.goods.GoodsEditForm;
import com.brodog.mall.admin.form.goods.GoodsEditStateParam;
import com.brodog.mall.admin.form.goods.GoodsSelectParam;
import com.brodog.mall.admin.service.impl.GoodsServiceImpl;
import com.brodog.mall.common.entity.ApiResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    private final GoodsServiceImpl service;


    public GoodsController(GoodsServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ApiResult add(@Valid @RequestBody GoodsAddForm goodsAddForm) {
        return service.addGoods(goodsAddForm);
    }

    @PostMapping("/del")
    public ApiResult delete(@PathParam("goodsId") Long goodsId) {
        return service.delete(goodsId);
    }

    @PostMapping("/edit")
    public ApiResult update(@Valid @RequestBody GoodsEditForm goodsEditForm) {
        return service.editGoods(goodsEditForm);
    }

    @PostMapping("/editState")
    public ApiResult updateGoodsState(@Valid @RequestBody GoodsEditStateParam param) {
        return service.updateGoodsState(param);
    }

    @GetMapping("/getList")
    public ApiResult getList(GoodsSelectParam param) {
        return service.selectByParam(param);
    }

    @GetMapping("/getDetail")
    public ApiResult getDetailByGoodsId(@PathParam("goodsId") Long goodsId) {
        return service.selectGoodsDetailById(goodsId);
    }

    @GetMapping("/get")
    public ApiResult getByGoodsId(@PathParam("goodsId") Long goodsId) {
        return service.selectById(goodsId);
    }
}

