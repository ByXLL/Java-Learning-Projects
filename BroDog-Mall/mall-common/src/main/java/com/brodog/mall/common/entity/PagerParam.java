package com.brodog.mall.common.entity;

import lombok.Data;

/**
 * 分页参数实体
 * @author By-Lin
 */
@Data
public class PagerParam {
    private Integer page = 1;
    private Integer size = 10;
}
