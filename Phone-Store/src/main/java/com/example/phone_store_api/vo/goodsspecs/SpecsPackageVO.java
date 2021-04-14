package com.example.phone_store_api.vo.goodsspecs;

import com.example.phone_store_api.vo.sku.SkuVO;
import lombok.Data;

import java.util.Map;

/**
 * 商品 规格 vo
 * @author By-Lin
 */
@Data
public class SpecsPackageVO {
    private Map<String,Object> goods;
    private SkuVO sku;
}
