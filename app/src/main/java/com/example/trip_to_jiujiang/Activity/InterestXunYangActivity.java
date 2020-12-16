package com.example.trip_to_jiujiang.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.example.trip_to_jiujiang.R;
import com.squareup.picasso.Picasso;

public class InterestXunYangActivity extends AppCompatActivity {
    String[] introduce = new String[]{"九江文人陶渊明，九江人的骄傲", "九江名楼楼，江南十大名楼之一(浔阳楼)",
            "“虎溪三笑”典故，正确认识九江文人", "东林寺古迹，几百年的佛教寺庙", "一寸光阴一寸金，这个典故大家都知道，快来 看看吧"};
    String[] imageAddress = new String[]{"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1608014229511&di=bc170540f265754e924734930b886348&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20190822%2F5aa52ed4a1a74efc922004940a0ec3fc.jpeg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1608014398862&di=cde65e9a516fc2ec5e2ddc86b459b5c0&imgtype=0&src=http%3A%2F%2Fwh111.oss-cn-hangzhou.aliyuncs.com%2Fekcms%2F20180622%2Ff49186fe0b9fb436.png",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1608014467378&di=853979f09ae632d79086bb1ee151dc24&imgtype=0&src=http%3A%2F%2Fpicture1.yidianchina.com%2Fassets%2Fupload%2Fproduct%2F0b9b5a170c98dd48dcbab6aaffa0d72f.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1608014516386&di=743f83ab647f1b8465133bb5b510b031&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20180917%2Fcd2f5197c41347ccbadbd78c0eab1836.jpeg",
            "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3278522477,400088846&fm=26&gp=0.jpg"};
    private ListView listView;
    MyAdapter myAdapter = new MyAdapter();
    private ImageView imageView_interestXunYang_backArrow;
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.interestxuyang_layout);
        listView = findViewById(R.id.listview_interestXunYang);
        listView.setAdapter(myAdapter);
        imageView_interestXunYang_backArrow = findViewById(R.id.interestXunYang_backArrow);
        imageView_interestXunYang_backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InterestXunYangActivity.this,IndexActivity.class);
                startActivity(intent);
            }
        });//imageView_interestXunYang_backArrow
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    switch (position){
                        case 0: {
                            Intent intent = new Intent(InterestXunYangActivity.this, TaoYuanMingActivity.class);
                            startActivity(intent);
                        }
                        break;
                        case 1:{
                            Intent intent = new Intent(InterestXunYangActivity.this, XunYangLouActivity.class);
                            startActivity(intent);
                        }
                        break;
                        case 2:{
                            Intent intent = new Intent(InterestXunYangActivity.this, HuXiXiaoTanActivity.class);
                            startActivity(intent);
                        }
                        break;
                        case 3:{
                            Intent intent = new Intent(InterestXunYangActivity.this, DongLinSiActivity.class);
                            startActivity(intent);
                        }
                        break;
                        case 4:{
                            Intent intent = new Intent(InterestXunYangActivity.this, TimeMoneyActivity.class);
                            startActivity(intent);
                        }
                        break;
                    }//switch
            }
        });//onItemClick
    }

    /*************自定义Adapter****************/
    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return introduce.length;
        }

        @Override
        public Object getItem(int position) {
            return introduce[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(InterestXunYangActivity.this, R.layout.interestxunyang_item_layout, null);
            TextView textView_introduce = view.findViewById(R.id.textview_introduce);
            ImageView imageView = view.findViewById(R.id.image_interestXunYang);
            Picasso.with(InterestXunYangActivity.this).load(imageAddress[position]).resize(1100, 400).into(imageView);
            textView_introduce.setText(introduce[position]);
            return view;
        }
    }//MyAdapter
}
