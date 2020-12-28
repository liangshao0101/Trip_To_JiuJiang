package com.example.trip_to_jiujiang.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.trip_to_jiujiang.R;

public class TicketsOrderActivity extends Activity {
    GridView gridView;
    ListView listView;
    MyAdapter myAdapter;
    MyAdapter2 myAdapter2;

    ImageView door_back;
    int[] imgIds = new int[] {R.drawable.door_scenne, R.drawable.door_catering, R.drawable.door_hotel, R.drawable.door_tc, R.drawable.door_combination, R.drawable.door_search};
    int[] imgIds2 = new int[] {R.drawable.lushan, R.drawable.lulinghu, R.drawable.jingxiugu, R.drawable.wulaofeng, R.drawable.wulongtan, R.drawable.donglingshi};
    String[] getStrMessage = new String[] {"庐山", "芦林湖", "锦绣谷", "五老峰", "乌龙潭", "东林寺"};
    String[] strMessage = new String[] {"景点", "餐饮", "酒店", "特产", "精选组合", "搜索"};
    String[] strMessage2 = new String[] {"庐山，又称匡山、匡庐，位于中国江西省九江市南郊，是联合国教科文组织评定的文化遗产和世界地质公园，同时还是中国国家5A级旅游景区和文明旅游风景区、世界名山大会的发起者", "芦林湖是中国江西省庐山山顶部山谷中的一个人工湖，面积约9公顷，海拔1040米，修建于1954年到1955年。拦截湖水的石坝大桥长120米，高32米。此湖为牯岭居民的主要水源。芦林湖被周围的玉屏、星洲两峰所环抱，景色优美","锦绣谷，位于江西省九江市的庐山，由大林峰与天池山交汇而成。因第四纪冰川作用，锦绣谷这块面向西南的山间凹地，经过冰川的反复刻切，形成了一个平底陡壁的山谷",
    "五老峰是中国江西省庐山东南部的一座山峰，海拔1358米，为庐山第二高峰，东临鄱阳湖。五老峰东北的山谷中有三叠泉瀑布，东部山麓有白鹿洞书院", "乌龙潭原由三个大小不一的潭渊组成，古书中记载：“乌龙潭凡三潭，中、上两潭皆高数十百丈，下潭稍平夷。”至今，只见一潭", "东林寺位于九江市庐山西麓，北距九江市16公里，东距庐山牯岭街50公里。因处于西林寺以东，故名。东林寺建于东晋大元九年，为庐山上历史悠久的寺院之一"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tickets_order_activity);
        gridView = findViewById(R.id.door_grid);
        listView = findViewById(R.id.door_listview);
        myAdapter = new MyAdapter();
        myAdapter2 = new MyAdapter2();
        gridView.setAdapter(myAdapter);
        listView.setAdapter(myAdapter2);
        door_back = findViewById(R.id.t_back);
        door_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TicketsOrderActivity.this, TicketsItemListen.class);
                Bundle bundle = new Bundle();
                switch (position) {
                    case 0:
                        bundle.putInt("imgid", R.drawable.lushan2);
                        bundle.putString("title", "庐山");
                        bundle.putString("price", "$109");
                        break;
                    case 1:
                        bundle.putInt("imgid", R.drawable.lulinhu2);
                        bundle.putString("title", "芦林湖");
                        bundle.putString("price", "$49");
                        break;
                    case 2:
                        bundle.putInt("imgid", R.drawable.jinxiugu2);
                        bundle.putString("title", "锦绣谷");
                        bundle.putString("price", "$39");
                        break;
                    case 3:
                        bundle.putInt("imgid", R.drawable.wulaofeng2);
                        bundle.putString("title", "五老峰");
                        bundle.putString("price", "$45");
                        break;
                    case 4:
                        bundle.putInt("imgid", R.drawable.wulongtan2);
                        bundle.putString("title", "乌龙谭");
                        bundle.putString("price", "$29");
                        break;
                    case 5:
                        bundle.putInt("imgid", R.drawable.donglinsi2);
                        bundle.putString("title","东林寺");
                        bundle.putString("price", "$30");


                }
                intent.putExtras(bundle);
                startActivity(intent);
            }
            });


    }
    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return imgIds.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View myView;
            if(convertView == null) {
                myView = getLayoutInflater().inflate(R.layout.door_listview1_item, null);

            } else {
                myView = convertView;

            }
            ImageView imageView = myView.findViewById(R.id.door_img);
            imageView.setImageResource(imgIds[position]);
            TextView textView = myView.findViewById(R.id.door_text);
            textView.setText(strMessage[position]);


            return myView;
        }
    }
    class MyAdapter2 extends BaseAdapter {

        @Override
        public int getCount() {
            return imgIds2.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View myView;
            if(convertView == null) {
                myView = getLayoutInflater().inflate(R.layout.door_listview2_item, null);

            } else {
                myView = convertView;

            }
            ImageView imageView = myView.findViewById(R.id.door_listview3_img);
            imageView.setImageResource(imgIds2[position]);
            TextView textView = myView.findViewById(R.id.door_listview3_text);
            textView.setText(getStrMessage[position]);
            TextView textView1 = myView.findViewById(R.id.door_listview3_text2);
            textView1.setText(strMessage2[position]);


            return myView;
        }
    }


}
