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

public class HotelActivity2 extends Activity {


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
                x.setClass(HotelActivity2.this, HotelActivity.class);
                startActivity(x);
            }
        });


        initHotel();
        tv.setText("如家酒店");
        Picasso.with(this).load("https://p0.meituan.net/320.0/tdchoteldark/6b1c84bde1f2b9fa44bbed69a572db20389186.jpg")
                .resize(850, 350).into(imageView);
        textView.setText(
                "       电话：0791-86166666\n"+"     酒店简介  酒店按国际标准打造，特聘请国际知名设计师进行整体设计规划，匠心、典雅精致、使文化与艺术融为一体，具有国际级接待水准。酒店位于天佑路距南昌火车站、地铁2号线丁公路南站仅100米之遥。交通方便，房间干净优雅，性价比较高，以良好的服务态度受到大量回头客的好评，出门既有到达飞机场以及高铁站的专线以及直达八一广场步行街的公交，内有停车场，已优质服务欢迎美团用户的到来。");
        HotelAdapter adapter = new HotelAdapter(this, R.layout.goodfood_item, foodList);
        listview.setAdapter(adapter);
    }


    private void initHotel () {
        HotelName apple = new HotelName("时尚单人间\n"+"上网  WiFi和宽带\n" +
                "卫浴  独立\n" +
                "窗户  有\n" +
                "可住  2人\n" +
                "面积  20-22㎡\n" +
                "窗户明细  朝向走廊\n" +
                "床型  大床1.8×2.0米1张", "https://p1.meituan.net/175.0/tdchotel/f7b05eceaf0dee03a63d552542c15f5b968176.jpg");
        foodList.add(apple);
        HotelName apple1 = new HotelName("时尚标准间\n"+"上网  WiFi和宽带\n" +
                "卫浴  独立\n" +
                "窗户  有\n" +
                "可住  2人\n" +
                "面积  15㎡\n" +
                "窗户明细  朝向走廊\n" +
                "房间特色  预约发票\n" +
                "床型  大床1.5×2.0米1张\n", "https://p1.meituan.net/175.0/tdchotel/ee8a13605a5f2e3ff7c05f2e7e342b09926165.jpg");
        foodList.add(apple1);
        HotelName apple2 = new HotelName("豪华大床间\n"+"上网  WiFi和宽带\n" +
                "卫浴  独立\n" +
                "窗户  有\n" +
                "可住  2人\n" +
                "面积  22-25㎡\n" +
                "床型  单人床1.2×2.0米2张\n", "https://p0.meituan.net/175.0/tdchotel/5150255f7908575594f02837bc58981249693.jpg");
        foodList.add(apple2);
        HotelName apple3 = new HotelName("豪华标准间\n"+"上网  WiFi和宽带\n" +
                "卫浴  独立\n" +
                "窗户  有\n" +
                "可住  2人\n" +
                "面积  18-22㎡\n" +
                "房间特色  宽敞\n" +
                "床型  大床1.8×2.0米1张", "https://p1.meituan.net/175.0/tdchotel/d28bf76e9a5e56d0fcca01d95edfeba6940039.jpg");
        foodList.add(apple3);
        HotelName apple4 = new HotelName("家庭套房\n"+"上网  WiFi和宽带\n" +
                "卫浴  独立\n" +
                "窗户  有\n" +
                "可住  3人\n" +
                "面积  22㎡\n" +
                "床型  大床1.5×2.0米1张、单人床1.1×2.0米1张", "https://p0.meituan.net/175.0/tdchotel/26e96e989aba422efb306c931620dfcf830713.jpg");
        foodList.add(apple4);

    }

}
