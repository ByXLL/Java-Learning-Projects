package com.example.phone_store_api.vo.sku;

import com.example.phone_store_api.vo.goodscategory.TreeVO;
import com.example.phone_store_api.vo.goodsspecs.GoodsSpecsCasVO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * sku vo
 * @author By-Lin
 */
@Data
public class SkuVO {
    private List<TreeVO> tree;
    private List<GoodsSpecsCasVO> list;
    private String price;

    @JsonProperty("stock_num")
    private Integer stockNum;

    @JsonProperty("none_sku")
    private Boolean noneSku = false;

    @JsonProperty("hide_stock")
    private Boolean hideStock = false;
}
