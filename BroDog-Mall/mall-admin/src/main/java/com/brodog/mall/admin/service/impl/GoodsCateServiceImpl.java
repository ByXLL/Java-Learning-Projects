package com.brodog.mall.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brodog.mall.admin.dto.goods.GoodsCateAddDto;
import com.brodog.mall.admin.dto.goods.GoodsCateEditDto;
import com.brodog.mall.admin.vo.goods.GoodsCateVO;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.GoodsCate;
import com.brodog.mall.admin.mapper.GoodsCateMapper;
import com.brodog.mall.admin.service.GoodsCateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brodog.mall.common.entity.PagerParam;
import com.brodog.mall.common.enums.HttpCodeEnum;
import com.brodog.mall.common.exception.ArgException;
import com.brodog.mall.common.exception.OperationalException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品分类 服务实现类
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
@Service
public class GoodsCateServiceImpl extends ServiceImpl<GoodsCateMapper, GoodsCate> implements GoodsCateService {

    private final GoodsCateMapper goodsCateMapper;

    public GoodsCateServiceImpl(GoodsCateMapper goodsCateMapper) {
        this.goodsCateMapper = goodsCateMapper;
    }

    @Override
    public ApiResult insert(GoodsCateAddDto goodsCateAddDto) {
        GoodsCate goodsCate = new GoodsCate();
        BeanUtils.copyProperties(goodsCateAddDto,goodsCate);
        if(goodsCate.getLevel() == null) { goodsCate.setLevel(1); }
        if(goodsCate.getIsShow() == null) { goodsCate.setIsShow(1); }
        if(goodsCate.getIsMenu() == null) { goodsCate.setIsMenu(1); }
        goodsCate.setIsDel(0);
        int row = goodsCateMapper.insert(goodsCate);
        if(row>0) { return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc());}
        throw new OperationalException();
    }

    @Override
    public ApiResult delete(Long id) {
        if(id == null) { throw new ArgException("参数异常"); }
        GoodsCate goodsCate = goodsCateMapper.selectById(id);
        if(goodsCate == null) { throw new OperationalException(); }
        QueryWrapper<GoodsCate> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pid",id);
        Integer count = goodsCateMapper.selectCount(queryWrapper);
        if(count>0) { return new ApiResult(HttpCodeEnum.ERROR.getCode(), "操作失败，当前分类下存在子分类"); }
        int row = goodsCateMapper.deleteById(id);
        if(row > 0) { return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc()); }
        throw new OperationalException();
    }

    @Override
    public ApiResult update(GoodsCateEditDto goodsCateEditDto) {
        GoodsCate goodsCate = goodsCateMapper.selectById(goodsCateEditDto.getId());
        if(goodsCate == null) { throw new OperationalException(); }
        BeanUtils.copyProperties(goodsCateEditDto,goodsCate);
        int row = goodsCateMapper.updateById(goodsCate);
        if(row>0) { return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc()); }
        throw new OperationalException();
    }

    @Override
    public ApiResult selectByPage(PagerParam pagerParam, String name) {
        QueryWrapper<GoodsCateVO> queryWrapper = new QueryWrapper<>();
        if(!StringUtils.isBlank(name)) {
            queryWrapper.like("name", name);
        }
        queryWrapper.eq("is_del", 0);
        IPage<GoodsCateVO> mapPage = goodsCateMapper.selectMyPage(
            new Page<>(pagerParam.getPage(),pagerParam.getSize()),
            queryWrapper
        );
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(), mapPage);
    }

    @Override
    public ApiResult selectById(Long id) {
        if(id == null) { throw new ArgException("参数异常"); }
        GoodsCate goodsCate = goodsCateMapper.selectById(id);
        if(goodsCate == null) { return new ApiResult(HttpCodeEnum.ERROR.getCode(),HttpCodeEnum.ERROR.getDesc()); }
        GoodsCateVO goodsCateVO = new GoodsCateVO();
        BeanUtils.copyProperties(goodsCate,goodsCateVO);
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(),goodsCateVO);
    }
}
