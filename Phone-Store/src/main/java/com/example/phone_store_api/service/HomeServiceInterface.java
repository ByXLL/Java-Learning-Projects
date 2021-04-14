package com.example.phone_store_api.service;

import com.example.phone_store_api.vo.home.HomeVO;

/**
 * 首页 service 接口
 * @author By-Lin
 */
public interface HomeServiceInterface {
    /**
     * 查询首页数据
     * @return      首页数据 vo
     */
    HomeVO findData();
}
