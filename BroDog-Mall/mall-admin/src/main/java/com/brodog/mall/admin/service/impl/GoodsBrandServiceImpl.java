package com.brodog.mall.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brodog.mall.admin.dto.goods.GoodsBrandDto;
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
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    public ApiResult insert(GoodsBrandDto goodsBrandDto) {
        GoodsBrand goodsBrand = new GoodsBrand();
        BeanUtils.copyProperties(goodsBrandDto,goodsBrand);
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
    public ApiResult update(GoodsBrandDto goodsBrandDto) {
        GoodsBrand goodsBrand = goodsBrandMapper.selectById(goodsBrandDto.getId());
        if(goodsBrand == null) { throw new OperationalException(); }
        BeanUtils.copyProperties(goodsBrandDto,goodsBrand);
        int row = goodsBrandMapper.update(goodsBrand,null);
        if(row >0) { return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc()); }
        throw new OperationalException();
    }

    @Override
    public ApiResult selectByPage(PagerParam pagerParam) {
//        IPage<GoodsBranVO> page = new Page<>(1,2);
//        IPage<GoodsBranVO> mapPage = goodsBrandMapper.selectMyPage(page, null);

        List<GoodsBranVO> goodsBranVOList = goodsBrandMapper.testSql();

        return new ApiResult(200,"获取成功",goodsBranVOList);
    }

    @Override
    public ApiResult selectById(Long id) {
        if(id == null) { throw new ArgException(); }
        GoodsBrand goodsBrand = goodsBrandMapper.selectById(id);
        if(goodsBrand == null) { return new ApiResult(HttpCodeEnum.ERROR.getCode(),HttpCodeEnum.ERROR.getDesc()); }
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(),goodsBrand);
    }
}
