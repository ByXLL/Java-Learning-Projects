package com.brodog.mall.admin.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brodog.mall.admin.dto.goods.GoodsAttrValueAddDto;
import com.brodog.mall.admin.vo.goods.GoodsBranVO;
import com.brodog.mall.common.entity.GoodsAttrValue;
import com.brodog.mall.common.entity.GoodsBrand;
import com.brodog.mall.common.entity.PagerParam;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GoodsBrandMapperTest {
    @Autowired
    private GoodsBrandMapper goodsBrandMapper;

    @Test
    void selectMyPage() {
//        IPage<GoodsBranVO> page = new Page<>();
//        goodsBrandMapper.selectMyPage(page,null);
//        System.out.println();
    }

    @Test
    void testBeanUtil() {
        GoodsAttrValue goodsAttrValue = new GoodsAttrValue();
        List<GoodsAttrValueAddDto> addDtoList = new ArrayList<>(16);
        addDtoList.add(new GoodsAttrValueAddDto(1L,1L,""));
        addDtoList.add(new GoodsAttrValueAddDto(2L,2L,"商品"));
        addDtoList.add(new GoodsAttrValueAddDto(3L,3L,""));
        for (GoodsAttrValueAddDto addDto : addDtoList) {
            BeanUtils.copyProperties(addDto,goodsAttrValue);

            System.out.println(goodsAttrValue);
            System.out.println();
        }
    }
}