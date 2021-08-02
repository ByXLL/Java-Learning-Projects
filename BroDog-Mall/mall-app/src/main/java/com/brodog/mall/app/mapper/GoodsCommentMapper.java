package com.brodog.mall.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.brodog.mall.app.vo.goodsComment.GoodsCommentVo;
import com.brodog.mall.common.entity.GoodsComment;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 商品评论 Mapper 接口
 * </p>
 *
 * @author By-Lin
 * @since 2021-07-01
 */
@Repository
public interface GoodsCommentMapper extends IPageInterface<GoodsComment, GoodsCommentVo> {

}
