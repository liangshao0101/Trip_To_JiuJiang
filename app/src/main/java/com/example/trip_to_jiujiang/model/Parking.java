package com.example.trip_to_jiujiang.model;


import java.util.Date;

public class Parking {
    private String parkingId;  //停车订单号
    private String carNumber;   //车牌号
    private String parkingArea;   //停车地点
    private int parkingPrice;   //停车价格
    private Date parkingStartTime;   //开始停车时间
    private Date parkingDate;    //停车订单创建时间,停车结束时间
    private int parkingTime;   //停车时长
    private User puserNumber;  //用户账号，用来与用户表相关联

    public Parking() {
    }

    public Parking(String parkingId, String carNumber, String parkingArea, int parkingPrice, Date parkingStartTime, Date parkingDate, int parkingTime, User puserNumber) {
        this.parkingId = parkingId;
        this.carNumber = carNumber;
        this.parkingArea = parkingArea;
        this.parkingPrice = parkingPrice;
        this.parkingStartTime = parkingStartTime;
        this.parkingDate = parkingDate;
        this.parkingTime = parkingTime;
        this.puserNumber = puserNumber;
    }

    public String getParkingId() {
        return parkingId;
    }

    public void setParkingId(String parkingId) {
        this.parkingId = parkingId;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getParkingArea() {
        return parkingArea;
    }

    public void setParkingArea(String parkingArea) {
        this.parkingArea = parkingArea;
    }

    public int getParkingPrice() {
        return parkingPrice;
    }

    public void setParkingPrice(int parkingPrice) {
        this.parkingPrice = parkingPrice;
    }

    public Date getParkingStartTime() {
        return parkingStartTime;
    }

    public void setParkingStartTime(Date parkingStartTime) {
        this.parkingStartTime = parkingStartTime;
    }

    public Date getParkingDate() {
        return parkingDate;
    }

    public void setParkingDate(Date parkingDate) {
        this.parkingDate = parkingDate;
    }

    public int getParkingTime() {
        return parkingTime;
    }

    public void setParkingTime(int parkingTime) {
        this.parkingTime = parkingTime;
    }

    public User getPuserNumber() {
        return puserNumber;
    }

    public void setPuserNumber(User puserNumber) {
        this.puserNumber = puserNumber;
    }
}
