package com.example.phone_store_api.service.impl;

import com.example.phone_store_api.entity.GoodsCategory;
import com.example.phone_store_api.entity.GoodsInfo;
import com.example.phone_store_api.repository.GoodsCategoryRepository;
import com.example.phone_store_api.repository.GoodsInfoRepository;
import com.example.phone_store_api.service.HomeServiceInterface;
import com.example.phone_store_api.utils.GoodsUtil;
import com.example.phone_store_api.vo.goodscategory.GoodsCategoryVO;
import com.example.phone_store_api.vo.goodsinfo.GoodsInfoVO;
import com.example.phone_store_api.vo.home.HomeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 首页 service 接口实现类
 * @author By-Lin
 */
@Service
public class HomeService implements HomeServiceInterface {
    private final GoodsInfoRepository goodsInfoRepository;

    private final GoodsCategoryRepository goodsCategoryRepository;

    public HomeService(GoodsInfoRepository goodsInfoRepository, GoodsCategoryRepository goodsCategoryRepository) {
        this.goodsInfoRepository = goodsInfoRepository;
        this.goodsCategoryRepository = goodsCategoryRepository;
    }

    @Override
    public HomeVO findData() {
        HomeVO homeVO = new HomeVO();
        // 商品类型
        List<GoodsCategory> goodsCategoryList = goodsCategoryRepository.findAll();

        /**
         * 使用 Java 8 的新特性 先将数据库查询出来的 结果转换成流
         * 然后通过map 函数循环 拉姆达表达式  每循环一一遍 通过构造函数 新增一个对应的vo
         * 最后循环完成，返回的是一个新的数据流
         * 然后再将这个数据流 转换为 list
         */
        List<GoodsCategoryVO> goodsCategoryVOList = goodsCategoryList.stream().map(item -> new GoodsCategoryVO(
                                                        item.getCategoryId(),
                                                        item.getCategoryName(),
                                                        item.getCategoryType()
                                                    )).collect(Collectors.toList());
        homeVO.setCategories(goodsCategoryVOList);

        // 商品列表
        List<GoodsInfo> goodsInfoList = goodsInfoRepository.findAll();

        List<GoodsInfoVO> goodsInfoVOList = goodsInfoList.stream().map(item -> new GoodsInfoVO(
                item.getGoodsId(),
                item.getGoodsName(),
                item.getGoodsPrice()+".00",
                item.getGoodsDescription(),
                GoodsUtil.getTagArray(item.getGoodsTag()),
                item.getGoodsIcon()
        )).collect(Collectors.toList());
        homeVO.setGoods(goodsInfoVOList);

        return homeVO;
    }
}
