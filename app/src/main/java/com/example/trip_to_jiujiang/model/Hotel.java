package com.example.trip_to_jiujiang.model;

import cn.bmob.v3.BmobObject;

import java.util.Date;

public class Hotel extends BmobObject {
    private String hotelId;    //酒店订单号
    private String hotelSort;    //房间类型
    private String hotelName;    //酒店名称
    private int hotelNumber;  //酒店剩余数量
    private int hoPriceDiscount;   //酒店优惠价格
    private int hotelPrice;   //酒店价格
    private Date hotelDate;    //订单创建时间
    private String huserNumber;   //用户账号，用来与用户表关联

    public Hotel() {
    }

    public Hotel(String hotelId, String hotelSort, String hotelName, int hotelNumber, int hoPriceDiscount, int hotelPrice, Date hotelDate, String huserNumber) {
        this.hotelId = hotelId;
        this.hotelSort = hotelSort;
        this.hotelName = hotelName;
        this.hotelNumber = hotelNumber;
        this.hoPriceDiscount = hoPriceDiscount;
        this.hotelPrice = hotelPrice;
        this.hotelDate = hotelDate;
        this.huserNumber = huserNumber;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelSort() {
        return hotelSort;
    }

    public void setHotelSort(String hotelSort) {
        this.hotelSort = hotelSort;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getHotelNumber() {
        return hotelNumber;
    }

    public void setHotelNumber(int hotelNumber) {
        this.hotelNumber = hotelNumber;
    }

    public int getHoPriceDiscount() {
        return hoPriceDiscount;
    }

    public void setHoPriceDiscount(int hoPriceDiscount) {
        this.hoPriceDiscount = hoPriceDiscount;
    }

    public int getHotelPrice() {
        return hotelPrice;
    }

    public void setHotelPrice(int hotelPrice) {
        this.hotelPrice = hotelPrice;
    }

    public Date getHotelDate() {
        return hotelDate;
    }

    public void setHotelDate(Date hotelDate) {
        this.hotelDate = hotelDate;
    }

    public String getHuserNumber() {
        return huserNumber;
    }

    public void setHuserNumber(String huserNumber) {
        this.huserNumber = huserNumber;
    }
}
