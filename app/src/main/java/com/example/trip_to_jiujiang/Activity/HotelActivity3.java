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

public class HotelActivity3 extends Activity {


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
                x.setClass(HotelActivity3.this, HotelActivity.class);
                startActivity(x);
            }
        });


        initHotel();
        tv.setText("九江信华建国酒店 ");
        Picasso.with(this).load("https://p1.meituan.net/320.0/tdchoteldark/86e8a1fc8ec551c2d0cca34f9774c513230140.jpg")
                .resize(850, 350).into(imageView);
        textView.setText(
                "       电话：0791-86560055\n"+"     酒店简介  本酒店坐落于南昌市中心地段繁华美食街孺子路，地处交通枢纽，距离八一馆地铁站仅600米，且有公交直达高铁站及昌北机场，交通十分便利。酒店周边旅游景点丰富，毗邻省展览馆、八一广场、滕王阁、八一起义纪念馆等多个旅游景点。绳金塔美食街、中山路步行街、万寿宫购物商场更是举步可达，万达、丽华、天虹、沃尔玛等多个购物广场让您尽享娱乐购物天堂。周边更有南昌一中、十八中、二十中等名校环绕.风格简约、时尚，提供24小时热水沐浴、冷暖空调、液晶网络电视、高速WIFI上网等设施设备，舒适的环境、便捷贴心的服务，致力为客人打造宾至如归的感受。");
        HotelAdapter adapter = new HotelAdapter(this, R.layout.goodfood_item, foodList);
        listview.setAdapter(adapter);
    }


    private void initHotel () {
        HotelName apple = new HotelName("雅致双床房\n"+"上网  WiFi和宽带\n" +
                "卫浴  独立\n" +
                "窗户  有\n" +
                "可住  2人\n" +
                "面积  20-22㎡\n" +
                "窗户明细  朝向走廊\n" +
                "床型  大床1.8×2.0米1张", "https://p1.meituan.net/175.0/tdchoteldark/6566375a797d52c2fe925ebedfe397f01607821.jpg");
        foodList.add(apple);
        HotelName apple1 = new HotelName("优选大床房\n"+"上网  WiFi和宽带\n" +
                "卫浴  独立\n" +
                "窗户  有\n" +
                "可住  2人\n" +
                "面积  15㎡\n" +
                "窗户明细  朝向走廊\n" +
                "房间特色  预约发票\n" +
                "床型  大床1.5×2.0米1张\n", "https://p0.meituan.net/175.0/dnaimgdark/30c341c52b6813cdbe5598d4d052800c4627593.jpg");
        foodList.add(apple1);
        HotelName apple2 = new HotelName("优选双床房\n"+"上网  WiFi和宽带\n" +
                "卫浴  独立\n" +
                "窗户  有\n" +
                "可住  2人\n" +
                "面积  22-25㎡\n" +
                "床型  单人床1.2×2.0米2张\n", "https://p0.meituan.net/175.0/dnaimgdark/0e0fd0baa564f2183acc77c6bb66ffd44575666.jpg");
        foodList.add(apple2);
        HotelName apple3 = new HotelName("雅致大床房\n"+"上网  WiFi和宽带\n" +
                "卫浴  独立\n" +
                "窗户  有\n" +
                "可住  2人\n" +
                "面积  18-22㎡\n" +
                "房间特色  宽敞\n" +
                "床型  大床1.8×2.0米1张", "https://p0.meituan.net/175.0/tdchoteldark/94c9b5c26894ab76955c4a440cadb4401661389.jpg");
        foodList.add(apple3);
        HotelName apple4 = new HotelName("风情主题房\n"+"上网  WiFi和宽带\n" +
                "卫浴  独立\n" +
                "窗户  有\n" +
                "可住  3人\n" +
                "面积  22㎡\n" +
                "床型  大床1.5×2.0米1张、单人床1.1×2.0米1张", "https://p1.meituan.net/175.0/tdchoteldark/191a0b6e73e5f6eeb0c9ca672302fd95270138.jpg");
        foodList.add(apple4);

    }

}
