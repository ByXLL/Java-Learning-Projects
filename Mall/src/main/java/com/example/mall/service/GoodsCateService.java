package com.example.mall.service;

import com.example.mall.dao.GoodsCateMapper;
import com.example.mall.data.ApiResult;
import com.example.mall.dto.goodscate.GoodsCateAddDto;
import com.example.mall.dto.goodscate.GoodsCateEditDto;
import com.example.mall.dto.goodscate.GoodsCateSelectDto;
import com.example.mall.entity.GoodsCate;
import com.example.mall.utils.Constants;
import com.example.mall.utils.GoodsCateUtils;
import com.example.mall.vo.GoodsCateTreeVO;
import com.example.mall.vo.GoodsCateVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 商品分类 service 层
 * @author By-Lin
 */
@Service
public class GoodsCateService implements Constants {
    private final GoodsCateMapper goodsCateMapper;

    public GoodsCateService(GoodsCateMapper goodsCateMapper) {
        this.goodsCateMapper = goodsCateMapper;
    }

    /**
     * 添加商品分类
     * @param goodsCateAddDto       商品分类添加 dto
     * @return                      响应数据
     */
    public ApiResult insertGoodsCate(GoodsCateAddDto goodsCateAddDto) {
        if(goodsCateAddDto == null) { return new ApiResult(WARNING_CODE,"商品分类信息不能为空"); }
        if(StringUtils.isBlank(goodsCateAddDto.getCateName())) { return new ApiResult(WARNING_CODE,"商品分类名不能为空"); }

        GoodsCate goodsCate = new GoodsCate();
        goodsCate.setCateName(goodsCateAddDto.getCateName());
        if(goodsCateAddDto.getCatePid() == null) { goodsCate.setCatePid(0); }
        else{ goodsCate.setCatePid(goodsCateAddDto.getCatePid()); }

        int row = goodsCateMapper.insertGoodsCate(goodsCate);
        if(row > 0) { return new ApiResult(SUCCESS_CODE,"添加商品分类成功"); }
        return new ApiResult(ERROR_CODE,"添加商品分类失败");
    }

    /**
     * 删除商品分类
     * @param goodsCateId       商品分类id
     * @return                  响应数据
     */
    public ApiResult deleteGoodsCate(Integer goodsCateId) {
        if( goodsCateId == null ) { return new ApiResult(WARNING_CODE,"商品分类id不能为空"); }
        List<GoodsCateVO> childList = goodsCateMapper.selectGoodsCateByPid(goodsCateId);
        if(childList.size() > 0) {  return new ApiResult(WARNING_CODE,"删除失败，当前分类下存在子分类");  }
        int row = goodsCateMapper.deleteGoodsCate(goodsCateId);
        if(row > 0) { return new ApiResult(SUCCESS_CODE,"删除商品分类成功"); }
        return new ApiResult(ERROR_CODE,"删除商品分类失败");
    }

    /**
     * 修改商品分类
     * @param goodsCateEditDto      商品修改 dto
     * @return                      响应数据
     */
    public ApiResult updateGoodsCate(GoodsCateEditDto goodsCateEditDto) {
        if(goodsCateEditDto == null) {  return new ApiResult(WARNING_CODE,"商品分类信息不能为空"); }
        if(goodsCateEditDto.getCateId() == null ) { return new ApiResult(WARNING_CODE,"商品分类id不能为空"); }
        if(goodsCateEditDto.getCatePid() != null) {
            GoodsCateVO goodsCateVO = goodsCateMapper.selectGoodsCateById(goodsCateEditDto.getCatePid());
            if(goodsCateVO == null) { return new ApiResult(WARNING_CODE,"上级商品分类不存在"); }
            if(goodsCateVO.getCateId().equals(goodsCateEditDto.getCatePid())) {
                return new ApiResult(WARNING_CODE,"不能将上级商品分类设置为当前分类");
            }
        }

        int row = goodsCateMapper.updateGoodsCate(goodsCateEditDto);
        if( row > 0 ) { return new ApiResult(SUCCESS_CODE,"修改商品分类成功"); }
        return new ApiResult(ERROR_CODE,"修改商品分类失败");
    }

    /**
     * 通过id 获取商品分类
     * @param goodsCateId       商品分类id
     * @return                  响应数据
     */
    public ApiResult selectGoodsCateById(Integer goodsCateId) {
        if(goodsCateId == null) { return new ApiResult(WARNING_CODE,"商品分类id不能为空"); }
        GoodsCateVO goodsCateVO = goodsCateMapper.selectGoodsCateById(goodsCateId);
        return new ApiResult(SUCCESS_CODE,"商品分类获取成功",goodsCateVO);
    }

    /**
     * 通过 分类名 获取商品分类
     * @param goodsCateName     商品分类名
     * @return                  响应数据
     */
    public ApiResult selectGoodsCateName(String goodsCateName) {
        if(StringUtils.isBlank(goodsCateName)) { return new ApiResult(WARNING_CODE,"商品分类名不能为空"); }
        List<GoodsCateVO> GoodsCateVOList = goodsCateMapper.selectGoodsCateName(goodsCateName);
        return new ApiResult(SUCCESS_CODE,"商品分类获取成功",GoodsCateVOList);
    }

    /**
     * 通过 查询dto 获取商品分类
     * @param goodsCateSelectDto        查询dto
     * @return                          响应数据
     */
    public ApiResult selectGoodsCate(GoodsCateSelectDto goodsCateSelectDto) {
        if(goodsCateSelectDto.getCateId() != null) {
            GoodsCateVO goodsCateVO = goodsCateMapper.selectGoodsCateById(goodsCateSelectDto.getCateId());
            return new ApiResult(SUCCESS_CODE,"商品分类获取成功",goodsCateVO);
        }
        if(goodsCateSelectDto.getCateName() != null) {
            List<GoodsCateVO> goodsCateVOList = goodsCateMapper.selectGoodsCateName(goodsCateSelectDto.getCateName());
            return new ApiResult(SUCCESS_CODE,"商品分类获取成功",goodsCateVOList);
        }
        List<GoodsCateVO> goodsCateVOAll = goodsCateMapper.selectAllGoodsCate();
        return new ApiResult(SUCCESS_CODE,"商品分类获取成功",goodsCateVOAll);
    }

    /**
     * 获取所有商品分类
     * @return
     */
    public ApiResult selectAllGoodsCate() {
        List<GoodsCateVO> goodsCateVOList = goodsCateMapper.selectAllGoodsCate();
        return new ApiResult(SUCCESS_CODE,"商品分类获取成功",goodsCateVOList);
    }

    /**
     * 获取分类树
     * @return
     */
    public ApiResult selectAllGoodsCateTree() {
        List<GoodsCateTreeVO> goodsCateTreeVOList = goodsCateMapper.selectAllGoodsCate2();
        if(goodsCateTreeVOList.size() > 0) {
            List<GoodsCateTreeVO> goodsCateTreeVOs = GoodsCateUtils.buildTree2(goodsCateTreeVOList);
            return new ApiResult(SUCCESS_CODE,"商品分类获取成功",goodsCateTreeVOs);

        }
        return new ApiResult(SUCCESS_CODE,"商品分类获取成功",goodsCateTreeVOList);
    }
}
