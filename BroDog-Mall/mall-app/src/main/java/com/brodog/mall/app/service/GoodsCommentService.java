package com.brodog.mall.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.brodog.mall.app.dto.goodsComment.GoodsCommentAddDto;
import com.brodog.mall.app.form.goodsComment.GoodsCommentSelectParam;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.GoodsComment;

/**
 * <p>
 * 商品评论 服务类
 * </p>
 *
 * @author By-Lin
 * @since 2021-07-01
 */
public interface GoodsCommentService extends IService<GoodsComment> {

    /**
     * 添加商品评论
     * @param goodsCommentAddDto        评论添加dto
     * @return                          响应数据
     */
    ApiResult addGoodsComment(GoodsCommentAddDto goodsCommentAddDto);

    /**
     * 通过参数获取商品评论信息
     * @param param     查询参数
     * @return          响应数据
     */
    ApiResult selectListByParam(GoodsCommentSelectParam param);
}
