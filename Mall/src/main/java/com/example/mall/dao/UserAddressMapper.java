package com.example.mall.dao;

import com.example.mall.dto.useraddress.UserAddressAddDto;
import com.example.mall.dto.useraddress.UserAddressEditDto;
import com.example.mall.entity.UserAddress;
import com.example.mall.vo.UserAddressVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户地址 mapper 接口
 * @author By-Lin
 */
@Mapper
public interface UserAddressMapper {
    /**
     * 插入 用户地址
     * @param userAddress           用户地址 实体
     * @return                      影响行数
     */
    int insertUserAddress(UserAddress userAddress);

    /**
     * 删除 用户地址
     * @param id        主键id
     * @return           影响行数
     */
    int deleteUserAddress(Integer id);

    /**
     * 编辑  用户地址
     * @param userAddressEditDto        用户编辑地址 dto
     * @return                          影响行数
     */
    int updateUserAddress(UserAddressEditDto userAddressEditDto);

    /**
     * 取消默认地址
     * @param id        地址 id
     * @return          影响行数
     */
    int cancelIsDefault(Integer id);

    /**
     * 通过 id 查询用户地址
     * @param id  主键id
     * @return     用户地址 vo
     */
    UserAddressVO selectUserAddressById(Integer id);

    /**
     * 通过用户id 查询用户地址
     * @param userId        用户id
     * @return              用户地址 vo list
     */
    List<UserAddressVO> selectUserAddressByUserId(Integer userId);

    /**
     * 查询 某个用户 默认的收货地址
     * @param userId    用户id
     * @return          用户地址 vo
     */
    UserAddressVO selectIsDefaultByUserId(Integer userId);

}
