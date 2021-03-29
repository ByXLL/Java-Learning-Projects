package com.example.mall.dao;

import com.example.mall.dto.goodscate.GoodsCateAddDto;
import com.example.mall.dto.goodscate.GoodsCateEditDto;
import com.example.mall.entity.GoodsCate;
import com.example.mall.vo.GoodsCateTreeVO;
import com.example.mall.vo.GoodsCateVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 商品分类 mapper 接口
 * @author By-Lin
 */
@Mapper
public interface GoodsCateMapper {
    /**
     * 添加商品分类
     * @param goodsCate       商品分类实体
     * @return                影响行数
     */
    int insertGoodsCate(GoodsCate goodsCate);

    /**
     * 删除商品分类
     * @param goodsCateId       商品分类id
     * @return                  影响行数
     */
    int deleteGoodsCate(Integer goodsCateId);

    /**
     * 编辑商品分类
     * @param goodsCateEditDto      编辑商品分类 dto
     * @return                      影响行数
     */
    int updateGoodsCate(GoodsCateEditDto goodsCateEditDto);

    /**
     * 通过商品分类id 查询商品分类信息
     * @param goodsCateId           商品分类id
     * @return                      商品分类 vo
     */
    GoodsCateVO selectGoodsCateById(Integer goodsCateId);

    /**
     * 通过 商品分类父id 查询商品分类
     * @param goodsCatePid          商品分类父id
     * @return                      商品分类 vo List
     */
    List<GoodsCateVO> selectGoodsCateByPid(Integer goodsCatePid);

    /**
     * 通过 商品分类名 查询商品分类
     * @param goodsCateName          商品分类名
     * @return                      商品分类 vo List
     */
    List<GoodsCateVO> selectGoodsCateName(String goodsCateName);


    /**
     * 查询所有 商品分类
     * @return      商品分类 vo list
     */
    List<GoodsCateVO> selectAllGoodsCate();

    /**
     * 查询所有 商品分类
     * @return 商品分类树 vo list
     */
    List<GoodsCateTreeVO> selectAllGoodsCate2();

}
