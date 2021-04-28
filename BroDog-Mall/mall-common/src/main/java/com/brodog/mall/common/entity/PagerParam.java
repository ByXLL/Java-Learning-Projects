package com.brodog.mall.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分页参数实体
 * @author By-Lin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagerParam {
    private Integer page = 1;
    private Integer size = 10;
}
