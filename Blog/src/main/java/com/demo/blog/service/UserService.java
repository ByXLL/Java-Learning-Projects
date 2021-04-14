package com.demo.blog.service;

import com.demo.blog.dao.UserMapper;
import com.demo.blog.data.ApiResult;
import com.demo.blog.entity.User;
import com.demo.blog.utils.CommUtils;
import com.demo.blog.vo.UserVO;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 用户 service 层
 * @author By-Lin
 */
@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public ApiResult login(User user){
        if(user == null || "".equals(user.getLoginName()) || "".equals(user.getPassword())) {
            return new ApiResult(400,"请输入用户名和密码");
        }
        User user1 = userMapper.selectUser(user);
        if(user1 == null) { return new ApiResult(400,"当前用户不存在"); }
        if(!user1.getPassword().equals(CommUtils.getMd5(user.getPassword()))) {
            return new ApiResult(400,"密码错误");
        }
        String token =  CommUtils.getToken(user1);
        return new ApiResult(200,"登录成功",token);
    }

    /**
     * 通过 id 获取用户信息
     * @param userId    用户id
     * @return          响应数据
     */
    public ApiResult findUserById(Integer userId) {
        if("".equals(userId)) { return new ApiResult(400,"用户id不能为空",false); }
        User user = userMapper.selectById(userId);
        if (user != null) {
            UserVO userVO =  model2ViewModel(user);
            return new ApiResult(200,"获取用户信息成功",userVO,true);
        }
        return new ApiResult(400,"当前用户不存在",false);
    }

    /**
     * 查询用户实体
     * @param userId    用户id
     * @return          用户实体
     */
    public User findUserEntityById(int userId) {
        if("".equals(userId)) { throw  new IllegalArgumentException("用户id不能为空"); }
        User user = userMapper.selectById(userId);
        return user;
    }

    /**
     * 查询用户
     * @param user  用户实体
     * @return      响应数据
     */
    public ApiResult findUser(User user) {
        User result = userMapper.selectUser(user);
        if (result != null) {
            UserVO userVO =  model2ViewModel(result);
            return new ApiResult(200,"获取用户信息成功",userVO);
        }
        return new ApiResult(400,"当前用户不存在");
    }

    /**
     * 注册用户
     * @param user  用户实体
     * @return      响应数据
     */
    public ApiResult register(User user) {
        if(user.getPassword() == null || user.getPassword().trim().isEmpty()) { return new ApiResult(400,"密码不能为空",false);}
        ApiResult result = User.checkData(user);
        // 判断校验后的数据 是否没有缺失字段
        if(!result.getStatus()) { return result; }
        User user1 = userMapper.selectUserByEmail(user.getEmail());
        if(user1 != null) { return new ApiResult(400,"当前用户已经存在"); }
        user.setPassword(CommUtils.getMd5(user.getPassword()));
        user.setRegisteredTime(new Date());
        user.setStatus(1);
        user.setIsAdmin(2);

        int insertRow = userMapper.insertUser(user);
        if(insertRow > 0) { return new ApiResult(200, "注册成功"); }
        return new ApiResult(500,"注册失败");
    }

    /**
     * 更新用户信息
     * @param user  用户实体
     * @return      响应数据
     */
    public ApiResult updateUser(User user) {
        if(user.getUserId() == 0) { return new ApiResult(400,"用户id不能为空"); }
        User user1 = userMapper.selectById(user.getUserId());
        if(user1 == null) { return new ApiResult(400,"用户不存在"); }


        if(!user.getAvatar().isEmpty()) { user1.setAvatar(user.getAvatar());}
        if(!user.getEmail().isEmpty()) { user1.setEmail(user.getEmail());}
        if(!user.getLoginName().isEmpty()) { user1.setLoginName(user.getLoginName());}
        if(user.getIsAdmin() > 0) { user1.setIsAdmin(user.getIsAdmin());}
        if(user.getStatus() > 2) { user1.setStatus(user.getStatus());}




//        Boolean checkResult = User.checkUserIsEmpty(user);
//        if(checkResult) { return new ApiResult(400,"用户参数不能为空"); }
        int row = userMapper.updateUser(user1);
        if(row > 0) { return new ApiResult(200,"修改用户信息成功"); }
        return new ApiResult(500,"修改用户信息失败");
    }


    /**
     * 修改用户头像
     * @param userId    用户id
     * @param avatar    头像url地址
     * @return          响应数据
     */
    public ApiResult updateUserAvatar(Integer userId, String avatar) {
        if(!checkIsHasUser(userId)) { return new ApiResult(400,"当前用户不存在"); }
        if(avatar == null || "".equals(avatar)) { return new ApiResult(400,"请添加用户头像地址"); }
        User user = userMapper.selectById(userId);
        if(user == null) { return new ApiResult(400,"当前用户不存在"); }
        int row = userMapper.updateAvatar(userId,avatar);
        if(row > 0) { return new ApiResult(200,"修改用户头像成功"); }
        return new ApiResult(500,"修改用户头像失败");
    }

    /**
     * 修改用户状态
     * @param userId    用户id
     * @param status    状态值
     * @return          响应数据
     */
    public ApiResult updateUserStatus(Integer userId, Integer status) {
        if(!checkIsHasUser(userId)) { return new ApiResult(400,"当前用户不存在"); }
        if(!(status == 1 || status == 2)) { return new ApiResult(400,"请设置正确的状态值"); }
        int row = userMapper.updateStatus(userId, status);
        if(row > 0) { return new ApiResult(200,"修改用户状态成功"); }
        return new ApiResult(500,"修改用户状态失败");
    }

    /**
     * 修改用户密码
     * @param userId        用户id
     * @param password      密码
     * @return              响应体
     */
    public ApiResult updateUserPassword(Integer userId, String password) {
        if(!checkIsHasUser(userId)) { return new ApiResult(400,"当前用户不存在"); }
        if(password == null || "".equals(password)) { return new ApiResult(400,"密码不能为空"); }
        int row = userMapper.updatePassword(userId, CommUtils.getMd5(password));
        if(row > 0) { return new ApiResult(200,"修改用户密码成功"); }
        return new ApiResult(500,"修改用户密码失败");
    }

    /**
     * 内部方法 根据userid 查询是否存在用户
     * @param userId    用户id
     * @return          布尔值
     */
    private Boolean checkIsHasUser(Integer userId) {
        if("".equals(userId+"")){ return false; }
        User user = userMapper.selectById(userId);
        return user != null;
    }

    /**
     * 内部方法 模型转视图模型
     * @param user
     * @return
     */
    private UserVO model2ViewModel(User user) {
        UserVO userVO = new UserVO();
        userVO.setUserId(user.getUserId());
        userVO.setAvatar(user.getAvatar());
        userVO.setEmail(user.getEmail());
        userVO.setIsAdmin(user.getIsAdmin());
        userVO.setRegisteredTime(user.getRegisteredTime());
        userVO.setStatus(user.getStatus());
        userVO.setLoginName(user.getLoginName());
        userVO.setLastLoginTime(user.getLastLoginTime());
        return userVO;
    }
}
