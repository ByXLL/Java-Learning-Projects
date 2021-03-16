package com.demo.blog.entity;

import com.demo.blog.data.ApiResult;

import java.util.Date;

public class User {
    private int userId;
    private String loginName;
    private String email;
    private String password;
    private String avatar;
    private int status;
    private Date registeredTime;
    private Date lastLoginTime;
    private int isAdmin;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getRegisteredTime() {
        return registeredTime;
    }

    public void setRegisteredTime(Date registeredTime) {
        this.registeredTime = registeredTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public static ApiResult checkData(User user) {
        if(user.getLoginName() == null || user.getLoginName().trim().isEmpty()) { return new ApiResult(400,"用户名不能为空",false);}
        if(user.getEmail() == null || user.getEmail().trim().isEmpty()) { return new ApiResult(400,"邮箱不能为空",false);}
        if(user.getAvatar() == null ||  user.getAvatar().trim().isEmpty()) { return new ApiResult(400,"头像不能为空",false);}
        return new ApiResult(200,true);
    }
    public static Boolean checkUserIsEmpty(User user) {
        if(
            (user.getLoginName() == null || user.getLoginName().trim().isEmpty()) &&
            (user.getAvatar() == null ||  user.getAvatar().trim().isEmpty()) &&
            user.getStatus() == 0
        ) { return true; }
        return false;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", loginName='" + loginName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", status=" + status +
                ", registeredTime=" + registeredTime +
                ", lastLoginTime=" + lastLoginTime +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
