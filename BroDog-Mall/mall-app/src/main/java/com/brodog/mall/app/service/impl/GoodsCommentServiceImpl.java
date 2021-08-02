package com.brodog.mall.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brodog.mall.app.dto.goodsComment.GoodsCommentAddDto;
import com.brodog.mall.app.form.goodsComment.GoodsCommentSelectParam;
import com.brodog.mall.app.mapper.GoodsCommentMapper;
import com.brodog.mall.app.mapper.GoodsMapper;
import com.brodog.mall.app.service.GoodsCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brodog.mall.app.vo.goodsComment.GoodsCommentVo;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.Goods;
import com.brodog.mall.common.entity.GoodsComment;
import com.brodog.mall.common.enums.HttpCodeEnum;
import com.brodog.mall.common.exception.OperationalException;
import com.brodog.mall.common.util.CommUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 商品评论 服务实现类
 * </p>
 *
 * @author By-Lin
 * @since 2021-07-01
 */
@Service
public class GoodsCommentServiceImpl extends ServiceImpl<GoodsCommentMapper, GoodsComment> implements GoodsCommentService {
    private final GoodsCommentMapper goodsCommentMapper;
    private final GoodsMapper goodsMapper;

    public GoodsCommentServiceImpl(GoodsCommentMapper goodsCommentMapper, GoodsMapper goodsMapper) {
        this.goodsCommentMapper = goodsCommentMapper;
        this.goodsMapper = goodsMapper;
    }

    /**
     * 添加商品评论
     * @param goodsCommentAddDto 评论添加dto
     * @return 响应数据
     */
    @Override
    public ApiResult addGoodsComment(GoodsCommentAddDto goodsCommentAddDto) {
        Goods goods = goodsMapper.selectById(goodsCommentAddDto.getGoodsId());
        if(goods == null) { throw new OperationalException("评论失败，评论商品不存在"); }
        GoodsComment goodsComment = new GoodsComment();
        BeanUtils.copyProperties(goodsCommentAddDto,goodsComment);
        goodsComment.setGoodsName(goods.getName());
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        goodsComment.setIp(CommUtils.getIpAddr(request));
        int row = goodsCommentMapper.insert(goodsComment);
        if(row < 1) { throw new OperationalException("评论失败"); }
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc());
    }

    /**
     * 通过参数获取商品评论信息
     * @param param 查询参数
     * @return 响应数据
     */
    @Override
    public ApiResult selectListByParam(GoodsCommentSelectParam param) {
        QueryWrapper<GoodsCommentVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("gc.is_del",0).eq("gc.goods_id",param.getGoodsId());
        if(param.getGrade() != null) {
            switch (param.getGrade()) {
                case 1:
                    queryWrapper.eq("gc.start",5);
                    break;
                case 2:
                    queryWrapper.between("gc.start",3,4);
                    break;
                case 3:
                    queryWrapper.between("gc.start",1,2);
                    break;
                default:
                    break;
            }
        }

        IPage<GoodsCommentVo> mapPage = goodsCommentMapper.selectMyPage(
                new Page<>(param.getPage(), param.getSize()),
                queryWrapper
        );
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(),mapPage);
    }
}
