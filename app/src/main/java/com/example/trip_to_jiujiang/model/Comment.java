package com.example.trip_to_jiujiang.model;

import java.util.Date;

public class Comment {
    private String commentId;   //用户评论号
    private Date commentTime;   //用户评论时间
    private String commentContext;   //用户评论内容
    private User cuserNumber;    //用户账号，用于与用户表相关联

    public Comment() {
    }

    public Comment(String commentId, Date commentTime, String commentContext, User cuserNumber) {
        this.commentId = commentId;
        this.commentTime = commentTime;
        this.commentContext = commentContext;
        this.cuserNumber = cuserNumber;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public String getCommentContext() {
        return commentContext;
    }

    public void setCommentContext(String commentContext) {
        this.commentContext = commentContext;
    }

    public User getCuserNumber() {
        return cuserNumber;
    }

    public void setCuserNumber(User cuserNumber) {
        this.cuserNumber = cuserNumber;
    }
}
