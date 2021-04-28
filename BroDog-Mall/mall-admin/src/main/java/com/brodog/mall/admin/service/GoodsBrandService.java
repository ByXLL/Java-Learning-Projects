package com.brodog.mall.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brodog.mall.admin.dto.goods.GoodsBrandDto;
import com.brodog.mall.admin.vo.goods.GoodsBranVO;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.GoodsBrand;
import com.baomidou.mybatisplus.extension.service.IService;
import com.brodog.mall.common.entity.PagerParam;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 商品品牌 服务类
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
@Repository
public interface GoodsBrandService extends IService<GoodsBrand> {
    /**
     * 添加品牌
     * @param goodsBrandDto     品牌dto
     * @return                  响应数据
     */
    ApiResult insert(GoodsBrandDto goodsBrandDto);

    /**
     * 删除
     * @param id        品牌id
     * @return          响应数据
     */
    ApiResult delete(Long id);

    /**
     * 编辑品牌
     * @param goodsBrandDto     品牌dto
     * @return                  响应数据
     */
    ApiResult update(GoodsBrandDto goodsBrandDto);

    /**
     * 分页查询 品牌
     * @param pagerParam      分页对象
     * @param name            品牌名
     * @return                响应数据
     */
    ApiResult selectByPage(PagerParam pagerParam, String name);

    /**
     * 通过 id 获取品牌
     * @param id        品牌id
     * @return          响应数据
     */
    ApiResult selectById(Long id);
}
