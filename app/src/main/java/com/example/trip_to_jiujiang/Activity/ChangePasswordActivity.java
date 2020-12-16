/***
 * author:Liam
 * **/
package com.example.trip_to_jiujiang.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.UpdateListener;
import com.example.trip_to_jiujiang.R;
import com.example.trip_to_jiujiang.model.User;

import java.util.List;

public class ChangePasswordActivity extends AppCompatActivity {
    private EditText etv_userid;
    private EditText etv_lao_password;
    private EditText etv_new_password;
    private EditText etv_verfiy_password;
    private ImageView imageView_changepassword_arrowback;
    private Button button_ok;
    private String userId;
    private String old_password;
    private String new_password;
    private String verfiy_password;
    private String objectId;
     protected void onCreate(Bundle bundle){
         super.onCreate(bundle);
         setContentView(R.layout.changepassword_layout);
         Bmob.initialize(this, "75a00f939f327300d5b2e4a6b69d9f58");  //初始化Bmob
         initView();  //初始化组件
         button_ok.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 userId = etv_userid.getText().toString().trim();  //获取用户名
                 old_password = etv_lao_password.getText().toString().trim();  //获取密码
                 new_password = etv_new_password.getText().toString().trim();   //获取新密码
                 verfiy_password = etv_verfiy_password.getText().toString().trim();  //获取确认密码
                 ChangePassword();
             }
         });//button_ok
         imageView_changepassword_arrowback.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

             }
         });//imageView_changepassword_arrowback
     }
     /*********************初始化组件*****************/
     private void initView(){
         etv_userid = findViewById(R.id.et_userID);
         etv_lao_password = findViewById(R.id.et_lao_password);
         etv_new_password = findViewById(R.id.et_new_password);
         etv_verfiy_password = findViewById(R.id.et_verfiy_password);
         imageView_changepassword_arrowback = findViewById(R.id.changepassword_backArrow);
         button_ok = findViewById(R.id.button_wancheng);
     }//initView
    /************修改密码方法***********/
    private void ChangePassword(){

        BmobQuery<User> bmobQuery = new BmobQuery<User>();
        bmobQuery.addWhereEqualTo("userId",userId);
        bmobQuery.addWhereEqualTo("userPsd", old_password);
        bmobQuery.findObjects(new FindListener<User>() {
            @Override
            public void done(List<User> list, BmobException e) {
                if (list.size()!= 0) {
               objectId = list.get(0).getObjectId();
               User user2 = new User();
               user2.setUserPsd(new_password);
               if(new_password.equals(verfiy_password)){
                   user2.update(objectId, new UpdateListener() {
                       @Override
                       public void done(BmobException e) {
                           if(e==null){
                               Toast.makeText(ChangePasswordActivity.this,"密码更改成功！！！",Toast.LENGTH_SHORT).show();
                               etv_lao_password.setText("");
                               etv_new_password.setText("");
                               etv_verfiy_password.setText("");
                               etv_userid.setText("");
                           }//if
                           else{
                               Toast.makeText(ChangePasswordActivity.this,"密码更改失败！！！",Toast.LENGTH_SHORT).show();
                               etv_userid.setText("");
                           }//else
                       }//done2
                   });
               }//if2
                    else
               {
                   Toast.makeText(ChangePasswordActivity.this,"两次输入的密码不一致，请重新输入！！！",Toast.LENGTH_SHORT).show();
                   etv_lao_password.setText("");
                   etv_new_password.setText("");
                   etv_verfiy_password.setText("");
               }//else

                }else {
                    Toast.makeText(ChangePasswordActivity.this,"密码更改失败！！！",Toast.LENGTH_SHORT).show();
                    etv_lao_password.setText("");
                    etv_new_password.setText("");
                    etv_verfiy_password.setText("");
                    etv_userid.setText("");
                }//else
            }//done()
        });
    }//ChangePassword
}
