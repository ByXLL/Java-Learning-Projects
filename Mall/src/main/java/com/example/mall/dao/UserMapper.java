package com.example.mall.dao;

import com.example.mall.dto.user.*;
import com.example.mall.entity.User;
import com.example.mall.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户 mapper
 * @author By-Lin
 */
@Mapper
public interface UserMapper {
    /**
     * 添加用户
     * @param user    用户实体
     * @return        影响行数
     */
    int insertUser(User user);

    /**
     * 删除用户
     * @param userId    用户id
     * @return          影响行数
     */
    int deleteUser(int userId);

    /**
     * 修改用户
     * @param userEditDto   用户编辑 dto
     * @return              影响行数
     */
    int updateUser(UserEditDto userEditDto);

    /**
     * 编辑 用户状态
     * @param userEditStatusDto     用户状态 dto
     * @return                      影响行数
     */
    int updateUserState(UserEditStatusDto userEditStatusDto);

    /**
     * 编辑 用户余额
     * @param userEditBalanceDto    编辑用户余额 dto
     * @return                      影响行数
     */
    int updateUserBalance(UserEditBalanceDto userEditBalanceDto);

    /**
     * 修改用户密码
     * @param userEditPassWordDto   用户编辑密码 dto
     * @return              影响行数
     */
    int updateUserPassword(UserEditPassWordDto userEditPassWordDto);

    /**
     * 查询 用户
     * @param userSelectDto     用户查询 dto
     * @return              用户 vo
     */
    List<UserVO> selectUser(UserSelectDto userSelectDto);

    /**
     * 通过 id 查询用户信息
     * @param id        用户id
     * @return          用户 vo
     */
    UserVO selectUserById(int id);

    /**
     * 通过 用户名 查询用户信息
     * @param userName      用户名
     * @return              用户 vo
     */
    UserVO selectUserByUserName(String userName);

    /**
     * 通过 用户名 查询用户实体
     * @param userName      用户名
     * @return              用户实体
     */
    User selectUserEntityByUserName(String userName);

    /**
     * 通过 用户id 查询用户实体
     * @param userId        用户id
     * @return              用户实体
     */
    User selectUserEntityById(int userId);

    /**
     * 通过 手机号码 查询用户信息
     * @param phone     手机号码
     * @return           用户 vo
     */
    UserVO selectUserByPhone(String phone);

}
