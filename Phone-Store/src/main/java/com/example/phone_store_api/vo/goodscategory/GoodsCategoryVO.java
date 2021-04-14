package com.example.phone_store_api.vo.goodscategory;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 商品分类 vo
 * @author By-Lin
 */
@Data
@AllArgsConstructor
public class GoodsCategoryVO {
    /**
     * JsonProperty 将实体的字段修改成别的提交回去
     */
    @JsonProperty("id")
    private Integer categoryId;

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;
}
