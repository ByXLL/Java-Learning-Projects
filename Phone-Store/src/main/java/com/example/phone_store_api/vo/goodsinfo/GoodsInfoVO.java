package com.example.phone_store_api.vo.goodsinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 商品 vo
 * @author By-Lin
 */
@Data
@AllArgsConstructor
public class GoodsInfoVO {
    @JsonProperty("id")
    private Integer goodsId;

    @JsonProperty("name")
    private String goodsName;

    @JsonProperty("price")
    private String goodsPrice;

    @JsonProperty("desc")
    private String goodsDescription;

    private List<Map<String,Object>> tag;

    @JsonProperty("thumb")
    private String goodsIcon;
}
