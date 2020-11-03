package com.example.trip_to_jiujiang.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.trip_to_jiujiang.R;

public class MyMessageActivity extends AppCompatActivity {
    private ImageView imageView;          //头像
    private Button button_setting;        //设置
    private TextView textView_name;      //用户名
    private TextView textView_id;         //用户ID
    private TextView textView_MyYangQuan;     //我的浔阳圈
    private TextView textView_XunYangQuan;      //浔阳圈
    private TextView textView_ChangePassword;      //更改密码
    private TextView textView_exit;                //退出
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.my_message_layout);
        initView();   //加载layout组件
        button_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }//onclick
        });//button_setting

    }

    //加载组件
    private void initView(){
        imageView = findViewById(R.id.imageIcon);
        textView_name = findViewById(R.id.name);
        textView_id = findViewById(R.id.accountID);
        textView_MyYangQuan = findViewById(R.id.myxunyangquan);
        textView_XunYangQuan = findViewById(R.id.xunyangquan);
        textView_ChangePassword = findViewById(R.id.changePassword);
        textView_exit = findViewById(R.id.exitAccount);
        button_setting = findViewById(R.id.setting);
    }
}
