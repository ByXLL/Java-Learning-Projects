package com.example.mall.service;

import com.example.mall.dao.UserMapper;
import com.example.mall.data.ApiResult;
import com.example.mall.dto.user.*;
import com.example.mall.entity.User;
import com.example.mall.utils.CommUtils;
import com.example.mall.utils.Constants;
import com.example.mall.vo.UserVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户 service
 * @author By-Lin
 */
@Service
public class UserService implements Constants {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 用户登录
     * @param userLoginDto      登录dto
     * @return                  响应数据
     */
    public ApiResult login(UserLoginDto userLoginDto) {
        if(userLoginDto == null) { return new ApiResult(WARNING_CODE,"参数不能为空"); }
        if(StringUtils.isBlank(userLoginDto.getUserName())) { return new ApiResult(WARNING_CODE,"用户名不能为空"); }
        if(StringUtils.isBlank(userLoginDto.getPassword())) { return new ApiResult(WARNING_CODE,"密码不能为空"); }
        User user = userMapper.selectUserEntityByUserName(userLoginDto.getUserName());
        if(user == null) { return new ApiResult(WARNING_CODE,"当前用户不存在"); }
        boolean checkPassword = StringUtils.equals(CommUtils.getMd5(userLoginDto.getPassword()),user.getPassword());
        if(checkPassword) {
            String token = CommUtils.getToken(user);
            Map<String,Object> data = new HashMap(16);
            data.put("token",token);
            return new ApiResult(SUCCESS_CODE,"登录成功",data);
        }
        return new ApiResult(WARNING_CODE,"密码错误");
    }

    /**
     * 添加用户
     * @param userAddDto        添加用户 dto
     * @return                  响应数据
     */
    public ApiResult insertUser(UserAddDto userAddDto) {
        if(userAddDto == null) { return new ApiResult(WARNING_CODE,"参数不能为空"); }
        if(userAddDto.getUserName() == null || StringUtils.isAllBlank(userAddDto.getUserName())
        ) { return new ApiResult(WARNING_CODE,"用户名不能为空"); }

        if(userAddDto.getPassword() == null ||  StringUtils.isAllBlank(userAddDto.getPassword())
        ) { return new ApiResult(WARNING_CODE,"密码不能为空"); }

        if(userAddDto.getPhone() == null || StringUtils.isBlank(userAddDto.getPhone()) || !CommUtils.isChinaPhoneLegal(userAddDto.getPhone())) {
            return new ApiResult(WARNING_CODE,"请填写正确的手机号码");
        }
        UserVO userVO = userMapper.selectUserByPhone(userAddDto.getPhone());
        if(userVO == null) {
            User user = new User();
            user.setUserName(userAddDto.getUserName());
            user.setPassword(CommUtils.getMd5(userAddDto.getPassword()));
            user.setBalance(new BigDecimal("0.00"));
            user.setStatus(1);
            user.setRegistTime(new Date());
            user.setPhone(userAddDto.getPhone());

            if(StringUtils.isBlank(userAddDto.getAvatar())){
                user.setAvatar(BASE_AVATAR);
            }else {
                user.setAvatar(userAddDto.getAvatar());
            }
            int row = userMapper.insertUser(user);
            if(row > 0) { return new ApiResult(SUCCESS_CODE,"用户注册成功"); }
            return new ApiResult(WARNING_CODE,"注册失败，请重试!");
        }
        return new ApiResult(WARNING_CODE,"注册失败，当前用户已存在");
    }

    /**
     * 删除用户
     * @param userId    用户id
     * @return          响应数据
     */
    public ApiResult deleteUser(Integer userId) {
        if (userId == 0) { return new ApiResult(WARNING_CODE,"用户id不能为空"); }
        UserVO userVO = userMapper.selectUserById(userId);
        if(userVO == null) { return new ApiResult(WARNING_CODE,"当前用户不存在"); }
        int row = userMapper.deleteUser(userId);
        if(row > 0) { return new ApiResult(SUCCESS_CODE,"删除用户成功"); }
        return new ApiResult(WARNING_CODE,"删除失败，请重试!");
    }

    /**
     * 更新用户
     * @param userEditDto       用户编辑 dto
     * @return                  响应数据
     */
    public ApiResult updateUser(UserEditDto userEditDto) {
        if(userEditDto == null) { return new ApiResult(WARNING_CODE,"参数不能为空"); }
        if(userEditDto.getId() == null) { return new ApiResult(WARNING_CODE,"用户id不能为空"); }

        UserVO userVO1 = userMapper.selectUserById(userEditDto.getId());
        if(userVO1 == null) { return new ApiResult(WARNING_CODE,"修改失败，当前用户不存在");}

        // 判断手机号码是否被注册
        if(!StringUtils.equals(userEditDto.getPhone(), userVO1.getPhone())) {
            UserVO userVO2 = userMapper.selectUserByPhone(userEditDto.getPhone());
            if(userVO2 != null) { return new ApiResult(WARNING_CODE,"修改失败，当前手机号码已被注册"); }
        }

        int row = userMapper.updateUser(userEditDto);
        if(row > 0) { return new ApiResult(SUCCESS_CODE,"修改成功"); }
        return new ApiResult(WARNING_CODE,"修改失败");
    }

    /**
     * 更新用户状态
     * @param userEditStatusDto     编辑用户状态 dto
     * @return      响应数据
     */
    public ApiResult updateUserStatus(UserEditStatusDto userEditStatusDto) {
        if (userEditStatusDto == null ) { return new ApiResult(WARNING_CODE,"参数不能为空"); }
        if(userEditStatusDto.getId() == null) { return new ApiResult(WARNING_CODE,"用户id不能为空");}
        UserVO userVO = userMapper.selectUserById(userEditStatusDto.getId());
        if(userVO == null) { return new ApiResult(WARNING_CODE,"当前用户不存在"); }
        int row = userMapper.updateUserState(userEditStatusDto);
        if(row > 0) { return new ApiResult(SUCCESS_CODE,"修改成功"); }
        return new ApiResult(WARNING_CODE,"修改失败");
    }

    /**
     * 修改用户余额
     * @param userEditBalanceDto    修改用户余额 dto
     * @return      响应数据
     */
    public ApiResult updateUserBalance(UserEditBalanceDto userEditBalanceDto) {
        if(userEditBalanceDto == null) { return new ApiResult(WARNING_CODE,"参数不能为空"); }
        UserVO userVO = userMapper.selectUserById(userEditBalanceDto.getId());
        if(userVO == null) { return new ApiResult(WARNING_CODE,"当前用户不存在"); }
        int row = userMapper.updateUserBalance(userEditBalanceDto);
        if( row > 0 ) { return new ApiResult(SUCCESS_CODE,"修改成功"); }
        return new ApiResult(WARNING_CODE,"修改成功");
    }

    /**
     * 修改用户密码
     * @param userEditPassWordDto   用户编辑密码 dto
     * @return              响应数据
     */
    public ApiResult updateUserPassword(UserEditPassWordDto userEditPassWordDto) {
        if(userEditPassWordDto == null) { return new ApiResult(WARNING_CODE,"参数不能为空"); }
        if(userEditPassWordDto.getId() == null) { return new ApiResult(WARNING_CODE,"用户id不能为空"); }
        if(StringUtils.isBlank(userEditPassWordDto.getPassword())) { return new ApiResult(WARNING_CODE,"新密码不能为空"); }

        UserVO userVO = userMapper.selectUserById(userEditPassWordDto.getId());
        if(userVO == null) { return new ApiResult(WARNING_CODE,"当前用户不存在"); }
        userEditPassWordDto.setPassword(CommUtils.getMd5(userEditPassWordDto.getPassword()));
        int row = userMapper.updateUserPassword(userEditPassWordDto);
        if(row > 0) { return new ApiResult(SUCCESS_CODE,"修改密码成功"); }
        return new ApiResult(WARNING_CODE,"修改密码失败");
    }

    /**
     * 通过用户 选择 dto 查询用户信息
     * @param selectDto     用户选择 dto
     * @return              响应数据
     */
    public ApiResult findUser(UserSelectDto selectDto) {
        if(selectDto == null) { return new ApiResult(WARNING_CODE,"参数不能为空"); }
        List<UserVO> userVO = userMapper.selectUser(selectDto);
        return new ApiResult(SUCCESS_CODE,"数据获取成功",userVO);
    }

    /**
     * 通过id 查询用户信息
     * @param id    用户id
     * @return      响应数据
     */
    public ApiResult findUserById(Integer id){
        if(id ==0) { return new ApiResult(WARNING_CODE,"用户id不能为空"); }
        UserVO userVO = userMapper.selectUserById(id);
        return new ApiResult(SUCCESS_CODE,"数据获取成功",userVO);
    }

    /**
     * 通过 用户名 查询用户信息
     * @param userName      用户名
     * @return              响应数据
     */
    public ApiResult findUserByUserName(String userName) {
        if(StringUtils.isBlank(userName)) { return new ApiResult(WARNING_CODE,"用户名不能为空"); }
        UserVO userVO = userMapper.selectUserByUserName(userName);
        if(userVO == null) { return new ApiResult(WARNING_CODE,"查询不到该用户"); }
        return new ApiResult(SUCCESS_CODE,"用户信息查询成功",userVO);
    }

    /**
     * 通过 用户id 查询实体信息
     * @param id        用户id
     * @return          用户实体
     */
    public User findUserEntityById(Integer id) {
        if(id ==0) { throw  new IllegalArgumentException("用户id不能为空"); }
        return userMapper.selectUserEntityById(id);
    }

    /**
     * 通过手机号码 查询用户信息
     * @param phone     手机号码
     * @return          响应数据
     */
    public ApiResult findUserByPhone(String phone) {
        if(StringUtils.isBlank(phone)) { return new ApiResult(WARNING_CODE,"手机号码不能为空"); }
        if(CommUtils.isChinaPhoneLegal(phone)) {
            UserVO userVO = userMapper.selectUserByPhone(phone);
            if(userVO == null) { return new ApiResult(WARNING_CODE,"查询不到该信息",false); }
            return new ApiResult(SUCCESS_CODE,"获取成功",userVO);
        }
        return new ApiResult(WARNING_CODE,"请填写正确的手机号码",false);
    }

}
