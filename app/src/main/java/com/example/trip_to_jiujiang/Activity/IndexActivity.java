package com.example.trip_to_jiujiang.Activity;

import android.app.LocalActivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.example.trip_to_jiujiang.Fragment.HelpFragment;
import com.example.trip_to_jiujiang.Fragment.IndexFragment;
import com.example.trip_to_jiujiang.Fragment.MyMessageFragment;
import com.example.trip_to_jiujiang.Fragment.YuYinFragment;
import com.example.trip_to_jiujiang.R;

public class IndexActivity extends AppCompatActivity{
    private RadioGroup rpTab;
    private RadioButton index;
    private RadioButton yuyin;
    private RadioButton help;
    private RadioButton my;
    private Fragment fragment_index;
    private Fragment fragment_yuyin;
    private Fragment fragment_help;
   private Fragment fragment_my;
    FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_activity_layout);
        initView();
        ChangeMainFragment(R.id.rb_index);
        //默认显示主界面
        rpTab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ChangeMainFragment(checkedId);
            }
        });
        my.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void initView() {
        rpTab = findViewById(R.id.rd_group);
        index = findViewById(R.id.rb_index);
        yuyin = findViewById(R.id.rb_yunyin);
        help = findViewById(R.id.rb_help);
        my = findViewById(R.id.rb_my);
        index.setChecked(true);
    }

    public void hideAllFragment(FragmentTransaction transaction){
        if(fragment_index!=null){
            transaction.hide(fragment_index);
        }
        if(fragment_yuyin !=null){
            transaction.hide(fragment_yuyin);
        }
        if(fragment_help!=null){
            transaction.hide(fragment_help);
        }
        if(fragment_my!=null){
            transaction.hide(fragment_my);
        }
    }
/**************************切换主Fragment***************************/
private void ChangeMainFragment(int checkId){
    fragmentTransaction = getSupportFragmentManager().beginTransaction();
    hideAllFragment(fragmentTransaction);
    switch (checkId){
        case R.id.rb_index:
            if(fragment_index==null){
                fragment_index = new IndexFragment();
                fragmentTransaction.add(R.id.fragment_container,fragment_index);
            }else{
                fragmentTransaction.show(fragment_index);
            }
            break;
        case R.id.rb_yunyin:
            if(fragment_yuyin==null){
                fragment_yuyin = new YuYinFragment();
                fragmentTransaction.add(R.id.fragment_container,fragment_yuyin);
            }else{
                fragmentTransaction.show(fragment_yuyin);
            }
            break;
        case R.id.rb_help:
            if(fragment_help==null){
                fragment_help = new HelpFragment();
                fragmentTransaction.add(R.id.fragment_container,fragment_help);
            }else{
                fragmentTransaction.show(fragment_help);
            }
            break;
        case R.id.rb_my:
            if(fragment_my==null){
                fragment_my = new MyMessageFragment();
                fragmentTransaction.add(R.id.fragment_container,fragment_my);
            }else{
                fragmentTransaction.show(fragment_my);
            }
            break;
    }
    fragmentTransaction.commit();

       }//ChangeMainFragment()
}
