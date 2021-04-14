package com.example.phone_store_api.utils;

import com.example.phone_store_api.enums.HttpCodeEnum;
import com.example.phone_store_api.vo.ResultVO;
import lombok.Data;

/**
 * 统一响应数据 工具类
 * @author By-Lin
 */
@Data
public class ApiResultUtil {
    /**
     * 成功
     * @param data      数据
     * @return          响应数据 vo
     */
    public static ResultVO<Object> success(Object data) {
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(HttpCodeEnum.SUCCESS.getCode());
        resultVO.setMsg(HttpCodeEnum.SUCCESS.getDesc());
        resultVO.setData(data);
        return resultVO;
    }

    /**
     * 错误
     * @param data      数据
     * @return          响应数据 vo
     */
    public static ResultVO error(Object data) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(HttpCodeEnum.ERROR.getCode());
        resultVO.setMsg(HttpCodeEnum.ERROR.getDesc());
        resultVO.setData(data);
        return resultVO;
    }

    /**
     * 参数错误
     * @param data      数据
     * @return          响应数据 vo
     */
    public static ResultVO argError(Object data) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(HttpCodeEnum.ARG_ERROR.getCode());
        resultVO.setMsg(HttpCodeEnum.ARG_ERROR.getDesc());
        resultVO.setData(data);
        return resultVO;
    }

    /**
     * 权限异常
     * @param data      数据
     * @return          响应数据 vo
     */
    public static ResultVO authError(Object data) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(HttpCodeEnum.AUTH_ERROR.getCode());
        resultVO.setMsg(HttpCodeEnum.AUTH_ERROR.getDesc());
        resultVO.setData(data);
        return resultVO;
    }
}
