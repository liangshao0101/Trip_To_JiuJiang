package com.example.trip_to_jiujiang.Activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.multidex.MultiDex;
import cn.bmob.v3.Bmob;
import com.example.trip_to_jiujiang.R;

public class MainActivity extends AppCompatActivity {
     private Button button_login;
     private Button button_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MultiDex.install(this);
        setContentView(R.layout.main_layout);
        Bmob.initialize(this, "75a00f939f327300d5b2e4a6b69d9f58");  //初始化Bmob
        button_login = findViewById(R.id.home_signIn);
        button_register = findViewById(R.id.home_signUp);
        button_login.setOnClickListener(new View.OnClickListener() {//跳转到登录界面
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SignInActivity.class);
                startActivity(intent);
            }
        });
        button_register.setOnClickListener(new View.OnClickListener() {//跳转到注册界面
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}