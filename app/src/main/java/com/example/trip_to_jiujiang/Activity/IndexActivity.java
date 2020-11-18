package com.example.trip_to_jiujiang.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.trip_to_jiujiang.Fragment.HelpFragment;
import com.example.trip_to_jiujiang.Fragment.IndexFragment;
import com.example.trip_to_jiujiang.Fragment.MySettingFragment;
import com.example.trip_to_jiujiang.Fragment.YuYinViewFragment;
import com.example.trip_to_jiujiang.R;

public class IndexActivity extends AppCompatActivity {
    Button but_main;
    Button but_trip;
    Button but_help;
    Button but_mysetting;
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
     setContentView(R.layout.index_activity_layout);
     initView();
    }
    private void initView(){
        but_help = findViewById(R.id.help);
        but_main = findViewById(R.id.main);
        but_mysetting = findViewById(R.id.mysetting);
        but_trip = findViewById(R.id.trip);
        //设置监听事件
        but_trip.setOnClickListener(listener);
        but_mysetting.setOnClickListener(listener);
        but_main.setOnClickListener(listener);
        but_help.setOnClickListener(listener);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = new IndexFragment();
        fragmentTransaction.add(R.id.container,fragment).commit();
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fragment fragment = null;
            switch ((v.getId())){
                case R.id.main:{
                    fragment = new IndexFragment();
                    fragmentTransaction.replace(R.id.container,fragment);
                    fragmentTransaction.commit();
                    break;
                }
                case R.id.trip:{
                    fragment = new YuYinViewFragment();
                    fragmentTransaction.replace(R.id.container,fragment);
                    fragmentTransaction.commit();
                    break;
                }
                case R.id.help:{
                    fragment = new HelpFragment();
                    fragmentTransaction.replace(R.id.container,fragment);
                    fragmentTransaction.commit();
                    break;
                }
                case R.id.mysetting:{
                    fragment = new MySettingFragment();
                    fragmentTransaction.replace(R.id.container,fragment);
                    fragmentTransaction.commit();
                    break;
                }
            }
        }
    };
}
