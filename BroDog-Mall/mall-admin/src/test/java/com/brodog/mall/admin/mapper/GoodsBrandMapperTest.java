package com.brodog.mall.admin.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brodog.mall.admin.vo.goods.GoodsBranVO;
import com.brodog.mall.common.entity.GoodsBrand;
import com.brodog.mall.common.entity.PagerParam;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}