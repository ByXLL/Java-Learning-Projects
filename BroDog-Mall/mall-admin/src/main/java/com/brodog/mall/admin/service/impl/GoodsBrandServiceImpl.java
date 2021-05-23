package com.brodog.mall.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brodog.mall.admin.dto.goods.GoodsBrandAddDto;
import com.brodog.mall.admin.dto.goods.GoodsBrandEditDto;
import com.brodog.mall.admin.vo.goods.GoodsBranVO;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.GoodsBrand;
import com.brodog.mall.admin.mapper.GoodsBrandMapper;
import com.brodog.mall.admin.service.GoodsBrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brodog.mall.common.entity.PagerParam;
import com.brodog.mall.common.enums.HttpCodeEnum;
import com.brodog.mall.common.exception.ArgException;
import com.brodog.mall.common.exception.OperationalException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品品牌 服务实现类
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
@Service
public class GoodsBrandServiceImpl extends ServiceImpl<GoodsBrandMapper, GoodsBrand> implements GoodsBrandService {
    private final GoodsBrandMapper goodsBrandMapper;

    public GoodsBrandServiceImpl(GoodsBrandMapper goodsBrandMapper) {
        this.goodsBrandMapper = goodsBrandMapper;
    }

    @Override
    public ApiResult insert(GoodsBrandAddDto goodsBrandAddDto) {
        GoodsBrand goodsBrand = new GoodsBrand();
        BeanUtils.copyProperties(goodsBrandAddDto,goodsBrand);
        int row = goodsBrandMapper.insert(goodsBrand);
        if(row>0){ return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc()); }
        throw new OperationalException();
    }

    @Override
    public ApiResult delete(Long id) {
        if(id == null) { throw new ArgException(); }
        GoodsBrand goodsBrand = goodsBrandMapper.selectById(id);
        if(goodsBrand == null) { throw new OperationalException(); }
        int row = goodsBrandMapper.deleteById(id);
        if(row>0) { return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc()); }
        throw new OperationalException();
    }

    @Override
    public ApiResult update(GoodsBrandEditDto goodsBrandEditDto) {
        GoodsBrand goodsBrand = goodsBrandMapper.selectById(goodsBrandEditDto.getId());
        if(goodsBrand == null) { throw new OperationalException(); }
        BeanUtils.copyProperties(goodsBrandEditDto,goodsBrand);
        int row = goodsBrandMapper.updateById(goodsBrand);
        if(row >0) { return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc()); }
        throw new OperationalException();
    }

    @Override
    public ApiResult selectByPage(PagerParam pagerParam, String name) {
//        QueryWrapper<GoodsBrand> queryWrapper = new QueryWrapper<>();
//        queryWrapper.select("id","name","first_letter","sort","is_show","logo","big_pic");
//        if (!StringUtils.isBlank(name)) {
//            queryWrapper.like("name",name);
//        }
//        IPage<GoodsBrand> mapPage = goodsBrandMapper.selectPage(
//            new Page<>(pagerParam.getPage(), pagerParam.getSize()),
//            queryWrapper
//        );
//        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(), mapPage);

        QueryWrapper<GoodsBranVO> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isBlank(name)) {
            queryWrapper.like("name",name);
        }
        queryWrapper.eq("is_del",0);
        IPage<GoodsBranVO> mapPage = goodsBrandMapper.selectMyPage(
            new Page<>(pagerParam.getPage(), pagerParam.getSize()),
            queryWrapper
        );
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(), mapPage);
    }

    @Override
    public ApiResult selectById(Long id) {
        if(id == null) { throw new ArgException(); }
        GoodsBrand goodsBrand = goodsBrandMapper.selectById(id);
        if(goodsBrand == null) { return new ApiResult(HttpCodeEnum.ERROR.getCode(),HttpCodeEnum.ERROR.getDesc()); }
        GoodsBranVO goodsBranVO = new GoodsBranVO();
        BeanUtils.copyProperties(goodsBrand,goodsBranVO);
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(),goodsBranVO);
    }
}
