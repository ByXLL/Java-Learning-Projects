package com.example.phone_store_api.vo.goodsspecs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 *SpecsPackageVO -> Tree -> v
 * @author By-Lin
 */
@Data
public class GoodsSpecsVO {
    @JsonProperty("id")
    private Integer specsId;

    @JsonProperty("name")
    private String specsName;

    @JsonProperty("imgUrl")
    private String specsIcon;

    @JsonProperty("previewImgUrl")
    private String specsPreview;
}
