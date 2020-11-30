package com.example.trip_to_jiujiang.DataBase;


import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import com.example.trip_to_jiujiang.model.User;

public class UserOperation {
    private boolean flag = true;   //判断是否插入成功的标志，true代表插入成功。
    /*******************添加用户的操作方法*****************************/
    public String AddUser(User user1) {

        user1.save(new SaveListener<String>() {
            @Override
            public void done(String objectId, BmobException e) {
                if (e == null) {
                    flag = true;
                } else {
                    flag = false;
                }
            }
        });//done()
        if (flag == true) {
            return "注册账号成功！";
        } else {
            return "注册账号失败！";
        }
    }

}
