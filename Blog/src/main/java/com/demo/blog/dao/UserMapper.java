package com.demo.blog.dao;

import com.demo.blog.entity.User;
import org.apache.ibatis.annotations.Mapper;

/***
 * 用户接口，编写操作用户的行为 在service层中实现
 * @author By-Lin
 */
@Mapper
public interface UserMapper {
    /**
     * 通过id查询用户
     * @param userId    用户id
     * @return          用户实体
     */
    User selectById(int userId);

    /**
     * 查询用户 信息
     * @param user  用户实体
     * @return      用户实体
     */
    User selectUser(User user);

    /**
     * 根据 邮箱查询是否存在用户
     * @param email     邮箱地址
     * @return          用户实体
     */
    User selectUserByEmail(String email);

    /**
     * 插如用户
     * @param user  用户实体
     * @return      影响行数
     */
    int insertUser(User user);

    /**
     * 更新用户
     * @param user  用户实体
     * @return      影响行数
     */
    int updateUser(User user);

    /**
     * 更新用户账号状态
     * @param userId    用户id
     * @param status    用户状态值
     * @return          影响行数
     */
    int updateStatus(int userId, int status);

    /**
     * 更新用户头像
     * @param userId    用户id
     * @param avatar    头像地址
     * @return          影响行数
     */
    int updateAvatar(int userId, String avatar);

    /**
     * 更改密码
     * @param userId    用户id
     * @param password  新密码
     * @return          影响行数
     */
    int updatePassword(int userId, String password);
}
