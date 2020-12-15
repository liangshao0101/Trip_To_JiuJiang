package com.example.trip_to_jiujiang.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import com.example.trip_to_jiujiang.R;
import com.example.trip_to_jiujiang.model.User;
import java.util.List;

public class SignInActivity extends AppCompatActivity {
    private ImageView imageView_back;
    private TextView textView_signUp;
    private EditText editText_signIn_account;   //登录时的账号编辑框
    private EditText editText_signIn_password;   //登录时的密码编辑框
    private Button button_SignIn;   //登录按钮
    private String signIn_account;    //账号
    private String signIn_password;   //密码
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.sign_in_layout);
        Bmob.initialize(this, "75a00f939f327300d5b2e4a6b69d9f58");  //初始化Bmob
        initView();  //初始化组件
        button_SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn_account = editText_signIn_account.getText().toString().trim();  //获取编辑框账号
                signIn_password = editText_signIn_password.getText().toString().trim();  //获取编辑框密码
                QueryUser();
            }
        });//button_SignIn

        imageView_back.setOnClickListener(new View.OnClickListener() {//点击跳转到主登录界面
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });//imageView_back

        textView_signUp.setOnClickListener(new View.OnClickListener() {//点击跳转到登录界面
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });//textView_signUp
    }
    /***************initView()方法初始化组件****************************/
    private void initView(){
        imageView_back = findViewById(R.id.signIn_backArrow);   //返回主登录界面
        textView_signUp = findViewById(R.id.text_signUp);    //跳转到注册界面
        editText_signIn_account = findViewById(R.id.signIn_account);   //账号编辑框
        editText_signIn_password = findViewById(R.id.signIn_password);   //密码编辑框
        button_SignIn = findViewById(R.id.button_signIn);    //登录按钮
    }
    /******************查询(验证用户账号)的操作*********************/
    private void QueryUser(){
        BmobQuery<User> bmobQuery = new BmobQuery<User>();
        bmobQuery.addWhereEqualTo("userId", signIn_account);
        bmobQuery.addWhereEqualTo("userPsd", signIn_password);
        bmobQuery.findObjects(new FindListener<User>() {
            @Override
            public void done(List<User> list, BmobException e) {
                if (list.size()!= 0) {
                    Intent intent = new Intent(SignInActivity.this, IndexActivity.class);
                   startActivity(intent);
                    editText_signIn_account.setText("");
                    editText_signIn_password.setText("");

                }else {
                    Toast.makeText(SignInActivity.this, "登录失败！如果您确定已经注册了账号请重新输入账号密码，如果没有，请先注册账号！",Toast.LENGTH_LONG).show();
                }
            }
        });//done()
    }
}
