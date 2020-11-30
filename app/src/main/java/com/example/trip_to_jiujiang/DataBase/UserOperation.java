package com.example.trip_to_jiujiang.DataBase;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import com.example.trip_to_jiujiang.model.User;

import java.util.List;

public class UserOperation {
    private boolean flag = true;   //判断是否插入成功的标志，true代表插入成功。
    private boolean success = true;  //匹配成功的标志。true代表成功

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

    /******************查询(验证用户账号)的操作*********************/
    public boolean QueryUser(User user) {
        BmobQuery<User> bmobQuery = new BmobQuery<User>();
        bmobQuery.addWhereEqualTo("userId", user.getUserId());
        bmobQuery.addWhereEqualTo("userPsd", user.getUserPsd().trim());
        bmobQuery.findObjects(new FindListener<User>() {
            @Override
            public void done(List<User> list, BmobException e) {
                if (list.size() != 0) {
                    success = true;
                } else {
                    success = false;
                }
            }
        });//done()
        if (success == true) {
            return true;
        } else {
            return false;
        }
    }
}
