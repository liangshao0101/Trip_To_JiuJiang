package com.example.trip_to_jiujiang.model;

import cn.bmob.v3.BmobObject;

import java.util.Date;

public class Specialty extends BmobObject {
    private String specialtyId;  //特产订单号
    private String specialtySort;   //特产类别
    private String specialtyName;    //特产名称
    private int specialtyPrice;   //特产价格
    private Date specialtyDate;   //特产创建日期
    private String  suserNumber;   //用户账号，用来和用户表相关联

    public Specialty() {
    }

    public Specialty(String specialtyId, String specialtySort, String specialtyName, int specialtyPrice, Date specialtyDate, String suserNumber) {
        this.specialtyId = specialtyId;
        this.specialtySort = specialtySort;
        this.specialtyName = specialtyName;
        this.specialtyPrice = specialtyPrice;
        this.specialtyDate = specialtyDate;
        this.suserNumber = suserNumber;
    }

    public String getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(String specialtyId) {
        this.specialtyId = specialtyId;
    }

    public String getSpecialtySort() {
        return specialtySort;
    }

    public void setSpecialtySort(String specialtySort) {
        this.specialtySort = specialtySort;
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    public int getSpecialtyPrice() {
        return specialtyPrice;
    }

    public void setSpecialtyPrice(int specialtyPrice) {
        this.specialtyPrice = specialtyPrice;
    }

    public Date getSpecialtyDate() {
        return specialtyDate;
    }

    public void setSpecialtyDate(Date specialtyDate) {
        this.specialtyDate = specialtyDate;
    }

    public String getSuserNumber() {
        return suserNumber;
    }

    public void setSuserNumber(String suserNumber) {
        this.suserNumber = suserNumber;
    }
}
