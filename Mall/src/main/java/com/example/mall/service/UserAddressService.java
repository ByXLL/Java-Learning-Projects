package com.example.mall.service;

import com.example.mall.dao.UserAddressMapper;
import com.example.mall.data.ApiResult;
import com.example.mall.dto.useraddress.UserAddressAddDto;
import com.example.mall.dto.useraddress.UserAddressEditDto;
import com.example.mall.entity.UserAddress;
import com.example.mall.utils.Constants;
import com.example.mall.vo.UserAddressVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 用户地址 service 层
 * @author By-Lin
 */
@Service
public class UserAddressService implements Constants {
    private final UserAddressMapper userAddressMapper;

    public UserAddressService(UserAddressMapper userAddressMapper) {
        this.userAddressMapper = userAddressMapper;
    }

    /**
     * 插入 用户收货地址
     * @param dto     用户收货地址 add dto
     * @return                      响应数据
     */
    public ApiResult insertUserAddress(UserAddressAddDto dto) {
        if(dto == null) { return new ApiResult(WARNING_CODE,"参数不能为空"); }
        if(dto.getUserId() == null) { return new ApiResult(WARNING_CODE,"用户id不能为空"); }
        if(StringUtils.isBlank(dto.getAddress())) { return new ApiResult(WARNING_CODE,"请填写收货地址"); }
        if(StringUtils.isBlank(dto.getProvince())) { return new ApiResult(WARNING_CODE,"请选择省信息"); }
        if(StringUtils.isBlank(dto.getCity())) { return new ApiResult(WARNING_CODE,"请选择城市信息"); }
        if(StringUtils.isBlank(dto.getArea())) { return new ApiResult(WARNING_CODE,"请选择区信息"); }
        if(StringUtils.isBlank(dto.getConsignee())) { return new ApiResult(WARNING_CODE,"请填写收货人信息"); }
        if(StringUtils.isBlank(dto.getPhone())) { return new ApiResult(WARNING_CODE,"请填写手机号码"); }
        if(StringUtils.isBlank(dto.getZipCode())) { return new ApiResult(WARNING_CODE,"请填写邮政编码"); }

        UserAddress userAddress = new UserAddress();
        userAddress.setUserId(dto.getUserId());
        userAddress.setAddress(dto.getAddress());
        userAddress.setProvince(dto.getProvince());
        userAddress.setCity(dto.getCity());
        userAddress.setArea(dto.getArea());
        userAddress.setConsignee(dto.getConsignee());
        userAddress.setPhone(dto.getPhone());
        userAddress.setZipCode(dto.getZipCode());

        Integer isDefault = dto.getIsDefault();
        userAddress.setIsDefault(isDefault == 1 ? 1 : 0);
        userAddress.setCreateTime(new Date());

        if(isDefault == 1) {
            UserAddressVO userAddressVO = userAddressMapper.selectIsDefaultByUserId(dto.getUserId());
            if(userAddressVO != null) {
                userAddressMapper.cancelIsDefault(userAddressVO.getUserId());
            }
        }

        int row = userAddressMapper.insertUserAddress(userAddress);
        if(row > 0) { return new ApiResult(SUCCESS_CODE,"添加收货地址成功"); }
        return new ApiResult(ERROR_CODE,"添加收货地址失败");
    }

    /**
     * 删除收货地址
     * @param id        地址id
     * @return          响应数据
     */
    public ApiResult deleteUserAddress(Integer id) {
        if(id == null) { return new ApiResult(ERROR_CODE,"id不能为空"); }
        int row = userAddressMapper.deleteUserAddress(id);
        if(row > 0) { return new ApiResult(SUCCESS_CODE,"删除成功"); }
        return new ApiResult(ERROR_CODE,"删除失败，请重试");
    }

    /**
     * 编辑收货地址
     * @param dto   编辑地址 dto
     * @return      响应数据
     */
    public ApiResult updateUserAddress(UserAddressEditDto dto) {
        if(dto == null) { return new ApiResult(WARNING_CODE,"参数不能为空"); }
        if(dto.getId() == null) { return new ApiResult(WARNING_CODE,"id不能为空"); }
        if(dto.getUserId() == null) { return new ApiResult(WARNING_CODE,"用户id不能为空"); }

        UserAddressVO userAddressVO = userAddressMapper.selectUserAddressById(dto.getId());
        if(userAddressVO == null) { return new ApiResult(ERROR_CODE,"当前地址不存在"); }

        if(dto.getIsDefault() == 1) {
            UserAddressVO userAddressVO1 = userAddressMapper.selectIsDefaultByUserId(dto.getUserId());
            if(userAddressVO1 != null) {
                if(!userAddressVO1.getId().equals(dto.getId())) {
                    int resultRow = userAddressMapper.cancelIsDefault(dto.getId());
                    if(resultRow < 1) {
                        return new ApiResult(ERROR_CODE,"编辑失败");
                    }
                }
            }
        }
        int row = userAddressMapper.updateUserAddress(dto);
        if(row >0) { return new ApiResult(SUCCESS_CODE,"编辑成功"); }
        return new ApiResult(ERROR_CODE,"编辑失败");
    }

    /**
     * 通过 id 查询地址信息
     * @param id        地址id
     * @return          响应数据
     */
    public ApiResult selectUserAddressById(Integer id) {
        if(id == null) { return new ApiResult(WARNING_CODE,"id不能为空"); }
        UserAddressVO userAddressVO = userAddressMapper.selectUserAddressById(id);
        return new ApiResult(SUCCESS_CODE,"数据获取成功");
    }

    /**
     * 通过用户id 查询地址信息
     * @param userId    用户id
     * @return          响应数据
     */
    public ApiResult selectUserAddressByUserId(Integer userId) {
        if(userId == null) { return new ApiResult(WARNING_CODE,"用户id不能为空"); }
        List<UserAddressVO> userAddressVOList = userAddressMapper.selectUserAddressByUserId(userId);
        return new ApiResult(SUCCESS_CODE,"数据获取成功");
    }
}
