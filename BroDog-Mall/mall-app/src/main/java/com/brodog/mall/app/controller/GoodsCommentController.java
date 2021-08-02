package com.brodog.mall.app.controller;


import com.brodog.mall.app.dto.goodsComment.GoodsCommentAddDto;
import com.brodog.mall.app.form.goodsComment.GoodsCommentSelectParam;
import com.brodog.mall.app.service.impl.GoodsCommentServiceImpl;
import com.brodog.mall.common.entity.ApiResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 商品评论 前端控制器
 * </p>
 *
 * @author By-Lin
 * @since 2021-07-01
 */
@RestController
@RequestMapping("/goodsComment")
public class GoodsCommentController {
    private final GoodsCommentServiceImpl goodsCommentService;

    public GoodsCommentController(GoodsCommentServiceImpl goodsCommentService) {
        this.goodsCommentService = goodsCommentService;
    }

    @PostMapping("/add")
    public ApiResult add(@Valid @RequestBody GoodsCommentAddDto addDto) {
        return goodsCommentService.addGoodsComment(addDto);
    }

    @GetMapping("/getList")
    public ApiResult getListByParam(@Valid GoodsCommentSelectParam param) {
        return goodsCommentService.selectListByParam(param);
    }
}

