package com.example.trip_to_jiujiang.model;

public class User {
    private String userId;    //用户账号
    private String userPsd;    //用户密码
    private String nickName;    //用户昵称

    public User() {
    }

    public User(String userId, String userPsd, String nickName) {
        this.userId = userId;
        this.userPsd = userPsd;
        this.nickName = nickName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPsd() {
        return userPsd;
    }

    public void setUserPsd(String userPsd) {
        this.userPsd = userPsd;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
