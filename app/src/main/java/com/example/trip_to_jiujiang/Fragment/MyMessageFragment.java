package com.example.trip_to_jiujiang.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.example.trip_to_jiujiang.Activity.ChangePasswordActivity;
import com.example.trip_to_jiujiang.Activity.MyOrderActivity;
import com.example.trip_to_jiujiang.Activity.SignInActivity;
import com.example.trip_to_jiujiang.Activity.TestActivity;
import com.example.trip_to_jiujiang.R;

public class MyMessageFragment extends Fragment {
    private ImageView imageView;          //头像
    private Button button_setting;        //设置
    private TextView textView_name;      //用户名
    private TextView textView_id;         //用户ID
    private TextView textView_Myspeclity;  //我的订单
    private TextView textView_MyYangQuan;     //我的浔阳圈
    private TextView textView_XunYangQuan;      //浔阳圈
    private TextView textView_ChangePassword;      //更改密码
    private TextView textView_exit;                //退出
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mView;
        mView = inflater.inflate(R.layout.mymessage_fragment, null);
        initView(mView);
        textView_MyYangQuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });//textView_MyYangQuan
        textView_XunYangQuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });//textView_XunYangQuan
        textView_ChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(getActivity(), ChangePasswordActivity.class);
               startActivity(intent);
            }
        });//textView_ChangePassword
        textView_Myspeclity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent intent = new Intent(getActivity(), MyOrderActivity.class);
             startActivity(intent);
             getActivity().finish();
            }
        });//textView_Myspecilty
        textView_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SignInActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });//textView_id
        return mView;
    }
    private void initView(View view){
        imageView = view.findViewById(R.id.imageIcon);
        textView_name = view.findViewById(R.id.name);
        textView_id = view.findViewById(R.id.accountID);
        textView_MyYangQuan = view.findViewById(R.id.myxunyangquan);
        textView_XunYangQuan = view.findViewById(R.id.xunyangquan);
        textView_ChangePassword = view.findViewById(R.id.changePassword);
        textView_exit = view.findViewById(R.id.exitAccount);
        button_setting = view.findViewById(R.id.setting);
        textView_Myspeclity = view.findViewById(R.id.speclity);
    }
}
