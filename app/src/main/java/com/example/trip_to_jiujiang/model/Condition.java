package com.example.trip_to_jiujiang.model;

import java.util.Date;

public class Condition {
    private String conditionId;   //用户动态号
    private Date conditionTime;   //动态发布时间
    private String conditionContext;  //动态内容
    private User cuserNumber;    //用户账号，用于和用户表相关联

    public Condition() {
    }

    public Condition(String conditionId, Date conditionTime, String conditionContext, User cuserNumber) {
        this.conditionId = conditionId;
        this.conditionTime = conditionTime;
        this.conditionContext = conditionContext;
        this.cuserNumber = cuserNumber;
    }

    public String getConditionId() {
        return conditionId;
    }

    public void setConditionId(String conditionId) {
        this.conditionId = conditionId;
    }

    public Date getConditionTime() {
        return conditionTime;
    }

    public void setConditionTime(Date conditionTime) {
        this.conditionTime = conditionTime;
    }

    public String getConditionContext() {
        return conditionContext;
    }

    public void setConditionContext(String conditionContext) {
        this.conditionContext = conditionContext;
    }

    public User getCuserNumber() {
        return cuserNumber;
    }

    public void setCuserNumber(User cuserNumber) {
        this.cuserNumber = cuserNumber;
    }
}
