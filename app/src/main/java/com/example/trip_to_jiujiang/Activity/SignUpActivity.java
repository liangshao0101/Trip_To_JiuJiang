package com.example.trip_to_jiujiang.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import cn.bmob.v3.Bmob;
import com.example.trip_to_jiujiang.DataBase.UserOperation;
import com.example.trip_to_jiujiang.R;
import com.example.trip_to_jiujiang.model.User;

public class SignUpActivity extends AppCompatActivity {
    private ImageView imageView_backUp;  //返回到主登录页面
    private TextView textView_signIn;     //返回到登录界面
    private Button button_signUp;   //注册按钮，即向用户表中添加数据
    private EditText editText_signUp_account;  //账号编辑框
    private EditText editText_signUp_password;  //密码编辑框
    private EditText editText_signUp_nickname; //昵称编辑框
    private String account;  //账号
    private String password;  //密码
    private String nickname;  //昵称
    UserOperation userOperation;  //定义用户操作类
    private String signUp_message;   //插入数据是否成功的弹框信息
     public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.sign_up_layout);
         Bmob.initialize(this, "75a00f939f327300d5b2e4a6b69d9f58");  //初始化Bmob
         initView();   //初始化组件
        button_signUp.setOnClickListener(new View.OnClickListener() {//注册用户，也就是向用户表中添加数据
            @Override
            public void onClick(View v) {
                account = editText_signUp_account.getText().toString().trim();   //获取编辑框账号
                password = editText_signUp_password.getText().toString().trim();  //获取编辑框密码
                nickname = editText_signUp_nickname.getText().toString().trim();  //获取编辑框昵称
                User user2 = new User();
                user2.setUserId(account);
                user2.setUserPsd(password);
                user2.setNickName(nickname);
              userOperation = new UserOperation();  //初始化用户操作类
              signUp_message = userOperation.AddUser(user2);    //调用用户操作类的AddUser()方法添加数据
                Toast.makeText(SignUpActivity.this,signUp_message,Toast.LENGTH_SHORT).show();//返回插入后的信息
               editText_signUp_account.setText("");
               editText_signUp_nickname.setText("");
               editText_signUp_password.setText("");
            }
        });//button_sign_Up
        textView_signIn.setOnClickListener(new View.OnClickListener() {//返回登录界面
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this,SignInActivity.class);
                startActivity(intent);
            }
        });//textView_signIn
        imageView_backUp.setOnClickListener(new View.OnClickListener() {  //返回主登录界面
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });//imageView_backUp
    }
    /***************initView()方法初始化组件*******************/
    private void initView(){
        imageView_backUp  = findViewById(R.id.signUp_backArrow);
        textView_signIn = findViewById(R.id.text_signIn);
        button_signUp = findViewById(R.id.button_signUp);
        editText_signUp_account = findViewById(R.id.signUp_account);
        editText_signUp_password = findViewById(R.id.signUp_password);
        editText_signUp_nickname = findViewById(R.id.signUp_nickname);
    }
}
