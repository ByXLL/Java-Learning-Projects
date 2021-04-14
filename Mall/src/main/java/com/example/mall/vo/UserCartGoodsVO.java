package com.example.mall.vo;

import lombok.Data;

/**
 * 购物车 商品 vo
 * @author By-Lin
 */
@Data
public class UserCartGoodsVO {
    private Integer cartId;
    private Object goodsInfo;
    private Integer count;
}
