package com.example.phone_store_api.vo.goodsspecs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 *SpecsPackageVO -> List
 * @author By-Lin
 */
@Data
public class GoodsSpecsCasVO {
    @JsonProperty("id")
    private Integer specsId;

    @JsonProperty("stock_num")
    private Integer specsStock;

    @JsonProperty("price")
    private BigDecimal specsPrice;
}
