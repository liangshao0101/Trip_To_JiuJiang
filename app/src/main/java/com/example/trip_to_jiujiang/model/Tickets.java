package com.example.trip_to_jiujiang.model;

import cn.bmob.v3.BmobObject;

import java.util.Date;

public class Tickets extends BmobObject {
    private String ticketsId;      //门票订单号
    private String ticketsSort;     //门票类别
    private String ticketsArea;    //门票所属景区
    private Date ticketsDate;     //门票订单创建时间
    private int ticketsPrice;    //门票价格
    private int tiPriceDiscount;   //优惠价
    private int ticketsNumber;    //剩余票量
    private User tuserNumber;    //用户账号，用于与用户表关联

    public Tickets() {
    }

    public Tickets(String ticketsId, String ticketsSort, String ticketsArea, Date ticketsDate, int ticketsPrice, int tiPriceDiscount, int ticketsNumber, User tuserNumber) {
        this.ticketsId = ticketsId;
        this.ticketsSort = ticketsSort;
        this.ticketsArea = ticketsArea;
        this.ticketsDate = ticketsDate;
        this.ticketsPrice = ticketsPrice;
        this.tiPriceDiscount = tiPriceDiscount;
        this.ticketsNumber = ticketsNumber;
        this.tuserNumber = tuserNumber;
    }

    public String getTicketsId() {
        return ticketsId;
    }

    public void setTicketsId(String ticketsId) {
        this.ticketsId = ticketsId;
    }

    public String getTicketsSort() {
        return ticketsSort;
    }

    public void setTicketsSort(String ticketsSort) {
        this.ticketsSort = ticketsSort;
    }

    public String getTicketsArea() {
        return ticketsArea;
    }

    public void setTicketsArea(String ticketsArea) {
        this.ticketsArea = ticketsArea;
    }

    public Date getTicketsDate() {
        return ticketsDate;
    }

    public void setTicketsDate(Date ticketsDate) {
        this.ticketsDate = ticketsDate;
    }

    public int getTicketsPrice() {
        return ticketsPrice;
    }

    public void setTicketsPrice(int ticketsPrice) {
        this.ticketsPrice = ticketsPrice;
    }

    public int getTiPriceDiscount() {
        return tiPriceDiscount;
    }

    public void setTiPriceDiscount(int tiPriceDiscount) {
        this.tiPriceDiscount = tiPriceDiscount;
    }

    public int getTicketsNumber() {
        return ticketsNumber;
    }

    public void setTicketsNumber(int ticketsNumber) {
        this.ticketsNumber = ticketsNumber;
    }

    public User getTuserNumber() {
        return tuserNumber;
    }

    public void setTuserNumber(User tuserNumber) {
        this.tuserNumber = tuserNumber;
    }
}
