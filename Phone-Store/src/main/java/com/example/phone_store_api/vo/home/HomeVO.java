package com.example.phone_store_api.vo.home;

import com.example.phone_store_api.vo.goodscategory.GoodsCategoryVO;
import com.example.phone_store_api.vo.goodsinfo.GoodsInfoVO;
import lombok.Data;

import java.util.List;

/**
 * 首页数据 vo
 * @author By-Lin
 */
@Data
public class HomeVO {
    private List<GoodsCategoryVO> categories;
    private List<GoodsInfoVO> goods;
}
