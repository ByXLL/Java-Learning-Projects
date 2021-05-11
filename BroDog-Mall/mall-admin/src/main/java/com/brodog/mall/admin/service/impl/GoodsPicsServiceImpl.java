package com.brodog.mall.admin.service.impl;

import com.brodog.mall.admin.dto.goods.GoodsPicsAddDto;
import com.brodog.mall.admin.dto.goods.GoodsPicsEditDto;
import com.brodog.mall.admin.vo.goods.GoodsPicVO;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.GoodsPics;
import com.brodog.mall.admin.mapper.GoodsPicsMapper;
import com.brodog.mall.admin.service.GoodsPicsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brodog.mall.common.enums.HttpCodeEnum;
import com.brodog.mall.common.exception.ArgException;
import com.brodog.mall.common.exception.OperationalException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
@Service
public class GoodsPicsServiceImpl extends ServiceImpl<GoodsPicsMapper, GoodsPics> implements GoodsPicsService {

    private final GoodsPicsMapper mapper;

    public GoodsPicsServiceImpl(GoodsPicsMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public ApiResult insert(@Valid GoodsPicsAddDto goodsPicsAddDto) {
        GoodsPics goodsPics = new GoodsPics();
        BeanUtils.copyProperties(goodsPicsAddDto,goodsPics);
        goodsPics.setIsDel(0);
        int row = mapper.insert(goodsPics);
        if(row > 0) {return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(),goodsPics,true); }
        throw new OperationalException();
    }

    @Override
    public ApiResult delete(Long id) {
        if(id == null) { throw new ArgException(); }
        GoodsPics goodsPics = mapper.selectById(id);
        if(goodsPics == null) { throw new OperationalException(); }
        int row = mapper.deleteById(id);
        if(row >0) { return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(),true);}
        throw new OperationalException();
    }

    @Override
    public ApiResult selectByGoodsId(Long id) {
        if(id == null) { throw new ArgException(); }
        List<GoodsPicVO> urlList = mapper.selectPicsByGoodsId(id).stream().map(item -> new GoodsPicVO(
                item.getId(),
                item.getUrl()
        )).collect(Collectors.toList());
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(),urlList,true);
    }
}
