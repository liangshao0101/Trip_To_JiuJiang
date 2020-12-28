package com.example.trip_to_jiujiang.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;


import com.example.trip_to_jiujiang.DataBase.GoodFoodAdapter;
import com.example.trip_to_jiujiang.DataBase.HotelAdapter;
import com.example.trip_to_jiujiang.R;
import com.example.trip_to_jiujiang.model.HotelName;

import java.util.ArrayList;
import java.util.List;

public class HotelActivity extends Activity {


    private List<HotelName> foodList=new ArrayList<>();
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.hotel_layout);
        inithotel();

        ImageView imageView = findViewById(R.id.back);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent();
                x.setClass(HotelActivity.this, IndexActivity.class);
                startActivity(x);
            }
        });

        HotelAdapter adapter = new HotelAdapter(this, R.layout.goodfood_item, foodList);
        ListView listview = (ListView) findViewById(R.id.list_view);
        listview.setAdapter(adapter);



        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub

//                if(position == 0){
//                    Intent intent = new Intent(HotelActivity.this, HotelActivity1.class);
//                    startActivity(intent);
                switch (position){
                    case 0:
                        Intent intent = new Intent(HotelActivity.this, HotelActivity1.class);
                        startActivity(intent);
                        break;
//


                    case 1:
                        Intent intent1 = new Intent(HotelActivity.this, HotelActivity2.class);
                        startActivity(intent1);
                        break;

                    case 2:
                        Intent intent2 = new Intent(HotelActivity.this, HotelActivity3.class);
                        startActivity(intent2);
                        break;

                    default:
                        Intent intent3= new Intent(HotelActivity.this, HotelActivity3.class);
                        startActivity(intent3);
                                    break;
                }
            }
        });

    }




        private void inithotel () {
            HotelName apple = new HotelName("天海·迈尔斯酒店(大中路步行街店) \n" + "[九江站]\n 浔阳区滨江路299号信华城市广场\n" +
                    "行李寄存  无线上网  免费停车", "https://p0.meituan.net/320.0/tdchoteldark/1eec106202d9071a2d1a23ed14af71666758619.jpg");
            foodList.add(apple);

            HotelName appl = new HotelName("如家酒店(九江甘棠湖三中店) ", "https://p0.meituan.net/320.0/tdchoteldark/7ba4acc5dae8373fd7305e39c4d242c73744629.jpg");
            foodList.add(appl);

            HotelName appe = new HotelName("九江信华建国酒店 ", "https://p0.meituan.net/320.0/tdchoteldark/83dab6a470f1bd667b63213dff4438a22517284.jpg");
            foodList.add(appe);
            HotelName ple = new HotelName("梦逸主题宾馆", "https://p0.meituan.net/320.0/hotelbiz/73cbc301533c8db42f156acaf75e6509370372.jpg");
            foodList.add(ple);
            HotelName apple1 = new HotelName("五洲快捷酒店(九江快乐城店) ", "https://p0.meituan.net/320.0/tdchoteldark/92fb7797c7f4efc4a59e62654b105d3a267806.jpg");
            foodList.add(apple1);
            HotelName apple2 = new HotelName("天海连锁酒店(裕园火车站店) ", "https://p0.meituan.net/320.0/tdchotel/a1855ec35f0c64a96de80f03f0217ea32177165.png");
            foodList.add(apple2);
            HotelName apple3 = new HotelName("锦龙王朝酒店(九江开发区快乐城店) ", "https://p0.meituan.net/320.0/tdchoteldark/72fc5bb94326aa38e56bb330abe9bcc4565563.jpg");
            foodList.add(apple3);
            HotelName apple4 = new HotelName("行乐轻奢民宿 ", "https://p1.meituan.net/320.0/hotelbiz/d789f501dcb6b79c7a5dd5dc4343849b233889.jpg");
            foodList.add(apple4);
            HotelName apple5 = new HotelName("修水君豪大酒店 ", "https://p0.meituan.net/320.0/dnaimgdark/ad39611fa0c36e3dffa73cf17c660d42310813.png");
            foodList.add(apple5);
            HotelName apple6 = new HotelName("欧尚·遇见主题酒店(四码头店)", "https://p1.meituan.net/320.0/tdchotel/0f3ba9f00ded13c31740a9181800eb45165341.jpg");
            foodList.add(apple6);
        }







}