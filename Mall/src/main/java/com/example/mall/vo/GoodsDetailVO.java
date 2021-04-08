package com.example.mall.vo;

import lombok.Data;

import javax.xml.soap.Text;
import java.util.Date;

/**
 * 商品详情 vo
 * @author By-Lin
 */
@Data
public class GoodsDetailVO {
    private Integer goodsId;
    private String goodsName;
    private Integer goodsPrice;
    private Integer goodsStatus;
    private Integer storeCateId;
    private Integer goodsCount;
    private Date createTime;
    private String content;
    private String mainPic;
    private String subPics;
}
