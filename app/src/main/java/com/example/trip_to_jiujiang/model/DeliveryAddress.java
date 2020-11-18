package com.example.trip_to_jiujiang.model;

import java.util.Date;

public class DeliveryAddress {
    private String userName;   //姓名
    private String userPhone;   //电话号码
    private String userProvince;   //省份
    private String userAddress;   //详细地址
    private User duserNumber;  //用户账号，用来与用户表关联

    public DeliveryAddress() {
    }

    public DeliveryAddress(String userName, String userPhone, String userProvince, String userAddress, User duserNumber) {
        this.userName = userName;
        this.userPhone = userPhone;
        this.userProvince = userProvince;
        this.userAddress = userAddress;
        this.duserNumber = duserNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserProvince() {
        return userProvince;
    }

    public void setUserProvince(String userProvince) {
        this.userProvince = userProvince;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public User getDuserNumber() {
        return duserNumber;
    }

    public void setDuserNumber(User duserNumber) {
        this.duserNumber = duserNumber;
    }
}
