package com.example.trip_to_jiujiang.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.trip_to_jiujiang.DataBase.HotelAdapter;
import com.example.trip_to_jiujiang.R;
import com.example.trip_to_jiujiang.model.HotelName;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class HotelActivity1 extends Activity {


    private List<HotelName> foodList=new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.hotel);
        TextView tv=findViewById(R.id.hotel_name);//name
        ImageView imageView = findViewById(R.id.hotel_image);//大图
        TextView textView=findViewById(R.id.hotel_info);//info
        ListView listview=findViewById(R.id.hotel_list);

        ImageView imageView1 = findViewById(R.id.back_hotel);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent();
                x.setClass(HotelActivity1.this, HotelActivity.class);
                startActivity(x);
            }
        });


        initHotel();
       tv.setText("天海·迈尔斯酒店");
        Picasso.with(this).load("https://p0.meituan.net/320.0/tdchoteldark/1eec106202d9071a2d1a23ed14af71666758619.jpg")
                .resize(850, 350).into(imageView);
        textView.setText(
                "       电话：0791-86126679\n"+"     酒店简介  酒店坐落于英雄城南昌广场南路18号，毗邻八一广场和南昌火车站，交通便利、环境清爽。" +
                " 【交通part】酒店距火车站、八一广场仅1km，门口乘坐公交直达徐家坊客运站、洪都集团、江铃集团、八大山人风景区，" +
                "向南步行250m在丁公路南地铁站一站直达南昌火车站，向西步行400m在永叔路地铁站可前往滕王阁、秋水广场、南昌西站。" +
                " 【娱乐part】酒店对面有大型超市、影院、商业综合体，包括大润发、沃尔玛、苏宁易购、国美、万达影院等。" +
                "【环境part】酒店采用流行简约实用的设计风格，内部环境优良，客房门窗配有专业的隔音条，干净清爽，物美价廉、是您出差、" +
                "旅游、走亲访友的优质选择。 【其他part】酒店24小时前台，客房支持高速WIFI和有线上网。");
        HotelAdapter adapter = new HotelAdapter(this, R.layout.goodfood_item, foodList);
        listview.setAdapter(adapter);
    }


    private void initHotel () {
        HotelName apple = new HotelName("温馨大床房\n"+"上网  WiFi和宽带\n" +
                "卫浴  独立\n" +
                "窗户  有\n" +
                "可住  2人\n" +
                "面积  20-22㎡\n" +
                "窗户明细  朝向走廊\n" +
                "床型  大床1.8×2.0米1张", "https://p0.meituan.net/175.0/tdchoteldark/f4a44f8fc16bbc8014259e7c7f6ba6d53293390.jpg");
        foodList.add(apple);
        HotelName apple1 = new HotelName("特惠大床房\n"+"上网  WiFi和宽带\n" +
                "卫浴  独立\n" +
                "窗户  有\n" +
                "可住  2人\n" +
                "面积  15㎡\n" +
                "窗户明细  朝向走廊\n" +
                "房间特色  预约发票\n" +
                "床型  大床1.5×2.0米1张\n", "https://p0.meituan.net/175.0/tdchoteldark/4c82599bba8b163aa507eafcd1cf4f103916016.jpg");
        foodList.add(apple1);
        HotelName apple2 = new HotelName("风华双床房\n"+"上网  WiFi和宽带\n" +
                "卫浴  独立\n" +
                "窗户  有\n" +
                "可住  2人\n" +
                "面积  22-25㎡\n" +
                "床型  单人床1.2×2.0米2张\n", "https://p0.meituan.net/175.0/hotelbiz/ee92cfb96d3b290eeea3453dea19562598699.jpg");
        foodList.add(apple2);
        HotelName apple3 = new HotelName("风华大床房\n"+"上网  WiFi和宽带\n" +
                "卫浴  独立\n" +
                "窗户  有\n" +
                "可住  2人\n" +
                "面积  18-22㎡\n" +
                "房间特色  宽敞\n" +
                "床型  大床1.8×2.0米1张", "https://p1.meituan.net/175.0/tdchoteldark/7299357f0d17d2cd1a2ab1212e3328d42524741.jpg");
        foodList.add(apple3);
        HotelName apple4 = new HotelName("好友三人房\n"+"上网  WiFi和宽带\n" +
                "卫浴  独立\n" +
                "窗户  有\n" +
                "可住  3人\n" +
                "面积  22㎡\n" +
                "床型  大床1.5×2.0米1张、单人床1.1×2.0米1张", "https://p0.meituan.net/175.0/tdchoteldark/11ae2648b98f6abaabddf75faca354054348849.jpg");
        foodList.add(apple4);

    }

}
