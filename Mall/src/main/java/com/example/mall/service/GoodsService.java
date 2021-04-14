package com.example.mall.service;

import com.example.mall.dao.GoodsDescMapper;
import com.example.mall.dao.GoodsMainPicMapper;
import com.example.mall.dao.GoodsMapper;
import com.example.mall.dao.GoodsSubPicMapper;
import com.example.mall.data.ApiResult;
import com.example.mall.dto.goods.GoodsAddDto;
import com.example.mall.dto.goods.GoodsEditDto;
import com.example.mall.dto.goods.GoodsSelectDto;
import com.example.mall.dto.goodsdesc.GoodsDescDto;
import com.example.mall.dto.goodspic.GoodsPicDto;
import com.example.mall.entity.Goods;
import com.example.mall.utils.Constants;
import com.example.mall.vo.GoodsDetailVO;
import com.example.mall.vo.GoodsVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 商品 service
 * @author By-Lin
 */
@Service
public class GoodsService implements Constants {
    private final GoodsDescMapper goodsDescMapper;

    private final GoodsMainPicMapper goodsMainPicMapper;

    private final GoodsSubPicMapper goodsSubPicMapper;

    private final GoodsMapper goodsMapper;

    public GoodsService(GoodsDescMapper goodsDescMapper, GoodsMainPicMapper goodsMainPicMapper, GoodsSubPicMapper goodsSubPicMapper, GoodsMapper goodsMapper) {
        this.goodsDescMapper = goodsDescMapper;
        this.goodsMainPicMapper = goodsMainPicMapper;
        this.goodsSubPicMapper = goodsSubPicMapper;
        this.goodsMapper = goodsMapper;
    }

    /**
     *
     * 事务待处理
     *
     *
     */

    /**
     * 添加商品
     * @param goodsAddDto   商品添加 dto
     * @return              响应数据
     */
//    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    @Transactional
    public ApiResult insertGoods(GoodsAddDto goodsAddDto) {
        if(goodsAddDto == null) { return new ApiResult(WARNING_CODE,"商品参数不能为空"); }
        if(StringUtils.isBlank(goodsAddDto.getGoodsName())) { return new ApiResult(WARNING_CODE,"商品名称不能为空"); }
        if(goodsAddDto.getGoodsPrice() == null) { return new ApiResult(WARNING_CODE,"商品价格不能为空"); }
        if(goodsAddDto.getGoodsStatus() == null) { return new ApiResult(WARNING_CODE,"商品状态不能为空"); }
        if(goodsAddDto.getStoreCateId() == null) { return new ApiResult(WARNING_CODE,"商品分类不能为空"); }
        if(goodsAddDto.getGoodsCount() == null) { return new ApiResult(WARNING_CODE,"商品个数不能为空"); }

        if(StringUtils.isBlank(goodsAddDto.getContent())) { return new ApiResult(WARNING_CODE,"商品详情不能为空"); }
        if(StringUtils.isBlank(goodsAddDto.getMainPic())) { return new ApiResult(WARNING_CODE,"商品主图"); }
        if(StringUtils.isBlank(goodsAddDto.getSubPics())) { return new ApiResult(WARNING_CODE,"商品小图不能为空"); }


        Goods goods = new Goods();
        goods.setGoodsName(goodsAddDto.getGoodsName());
        goods.setGoodsPrice(goodsAddDto.getGoodsPrice());
        goods.setGoodsStatus(goodsAddDto.getGoodsStatus());
        goods.setStoreCateId(goodsAddDto.getStoreCateId());
        goods.setGoodsCount(goodsAddDto.getGoodsCount());
        goods.setIsDel(0);
        goods.setCreateTime(new Date());
        int result1 = goodsMapper.insertGoods(goods);

        // 封装商品详情数据
        GoodsDescDto goodsDescDto = new GoodsDescDto();
        goodsDescDto.setGoodsId(goods.getGoodsId());
        goodsDescDto.setContent(goodsAddDto.getContent());
        int result2 = goodsDescMapper.insertGoodsDesc(goodsDescDto);

        // 封装商品主图数据
        GoodsPicDto goodsMainPics = new GoodsPicDto();
        goodsMainPics.setGoodsId(goods.getGoodsId());
        goodsMainPics.setUrl(goodsAddDto.getMainPic());
        int result3 = goodsMainPicMapper.insertGoodsMainPic(goodsMainPics);

        // 封装商品小图数据
        GoodsPicDto goodsSubPics = new GoodsPicDto();
        goodsSubPics.setGoodsId(goods.getGoodsId());
        goodsSubPics.setUrl(goodsAddDto.getSubPics());
        int result4 = goodsSubPicMapper.insertGoodsSubPic(goodsSubPics);


        if(result1 >0 && result2 >0 && result3 >0 && result4 > 0) {
            return new ApiResult(SUCCESS_CODE,"商品添加成功");
        }
        return new ApiResult(ERROR_CODE,"商品添加失败");
    }

    /**
     * 删除商品
     * @param goodsId       商品id
     * @return              响应数据
     */
    public ApiResult deleteGoods(Integer goodsId) {
        if(goodsId == null) { return new ApiResult(WARNING_CODE,"商品id不能为空"); }
        if(!checkIsHasGoods(goodsId)) { return new ApiResult(ERROR_CODE,"当前商品不存在"); }

        int row = goodsMapper.deleteGoods(goodsId);
        if(row >0) { return new ApiResult(SUCCESS_CODE,"删除成功"); }
        return new ApiResult(ERROR_CODE,"删除失败");
    }

    /**
     * 编辑商品
     * @param goodsEditDto      编辑商品 dto
     * @return                  响应数据
     */
//    @Transactional
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public ApiResult updateGoods(GoodsEditDto goodsEditDto) {
        if(goodsEditDto == null) { return new ApiResult(WARNING_CODE,"商品信息不能为空"); }
        if(goodsEditDto.getGoodsId() == null) { return new ApiResult(WARNING_CODE,"商品id不能为空"); }
        GoodsVO goodsVO = goodsMapper.selectGoodsById(goodsEditDto.getGoodsId());
        if(goodsVO == null) { return new ApiResult(ERROR_CODE,"当前商品不存在"); }

        int result1 = goodsMapper.updateGoods(goodsEditDto);

        // 封装商品详情
        GoodsDescDto goodsDescDto = new GoodsDescDto();
        goodsDescDto.setGoodsId(goodsVO.getGoodsId());
        goodsDescDto.setContent(goodsEditDto.getContent());
        int result2 = goodsDescMapper.updateGoodsDesc(goodsDescDto);

        // 封装商品主图数据
        GoodsPicDto goodsMainPics = new GoodsPicDto();
        goodsMainPics.setGoodsId(goodsEditDto.getGoodsId());
        goodsMainPics.setUrl(goodsEditDto.getMainPic());
        int result3 = goodsMainPicMapper.updateGoodsMainPic(goodsMainPics);

        // 封装商品小图数据
        GoodsPicDto goodsSubPics = new GoodsPicDto();
        goodsSubPics.setGoodsId(goodsEditDto.getGoodsId());
        goodsSubPics.setUrl(goodsEditDto.getSubPics());
        int result4 = goodsSubPicMapper.updateGoodsSubPic(goodsSubPics);


        if(result1 >0 && result2 >0 && result3 >0 && result4 > 0) {
            return new ApiResult(SUCCESS_CODE,"修改成功");
        }
        return new ApiResult(ERROR_CODE,"修改失败");
    }

    /**
     * 通过商品dto 查询商品简介
     * @param goodsSelectDto    查询dto
     * @return                  响应数据
     */
    public ApiResult selectGoods(GoodsSelectDto goodsSelectDto) {
        List<GoodsVO> goodsVOList = goodsMapper.selectGoods(goodsSelectDto);
        return new ApiResult(SUCCESS_CODE,"查询成功",goodsVOList);
    }

    /**
     * 通过商品 id查询商品简介
     * @param goodsId       商品id
     * @return              响应数据
     */
    public ApiResult selectGoodsById(Integer goodsId) {
        if(goodsId == null) { return new ApiResult(ERROR_CODE,"商品id不能为空"); }
        GoodsVO goodsVO = goodsMapper.selectGoodsById(goodsId);
        return new ApiResult(SUCCESS_CODE,"查询成功",goodsVO);
    }

    /**
     * 通过商品dto 查询商品详情
     * @param goodsSelectDto        查询dto
     * @return                      响应数据
     */
    public ApiResult selectGoodsDetail(GoodsSelectDto goodsSelectDto) {
        List<GoodsDetailVO> goodsDetailVOList = goodsMapper.selectGoodsDetail(goodsSelectDto);
        return new ApiResult(SUCCESS_CODE,"查询成功",goodsDetailVOList);
    }

    /**
     * 通过商品 id查询商品详情
     * @param goodsId       商品id
     * @return              响应数据
     */
    public ApiResult selectGoodsDetailById(Integer goodsId) {
        if(goodsId == null) { return new ApiResult(ERROR_CODE,"商品id不能为空"); }
        GoodsDetailVO goodsDetailVO = goodsMapper.selectGoodsDetailById(goodsId);
        return new ApiResult(SUCCESS_CODE,"查询成功",goodsDetailVO);
    }

    /**
     * 私有方法 通过 id 查询是否存在 商品
     * @param goodsId           商品id
     * @return                  true/false
     */
    private Boolean checkIsHasGoods(Integer goodsId) {
        GoodsVO goodsVO = goodsMapper.selectGoodsById(goodsId);
        return goodsVO != null;
    }
}
