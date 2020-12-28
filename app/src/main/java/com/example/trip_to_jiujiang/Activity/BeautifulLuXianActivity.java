package com.example.trip_to_jiujiang.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.example.trip_to_jiujiang.R;

public class BeautifulLuXianActivity extends Activity {
    ListView listView;
    MyAdapter myAdapter;
    ImageView back;
    ImageView imageView;
    int[] imageIds = new int[]{R.drawable.lushan, R.drawable.lulinghu, R.drawable.jingxiugu, R.drawable.wulaofeng, R.drawable.wulongtan, R.drawable.donglingshi};
    String[] messages = new String[]{"庐山两日游", "芦林湖一日游", "锦绣谷一日游", "五老峰两日游", "乌龙谭一日游", "东林寺一日游"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beautiful_way);
        listView = findViewById(R.id.way_listview);
        imageView = findViewById(R.id.way_listview_img);
        myAdapter = new MyAdapter();

        listView.setAdapter(myAdapter);
        back = findViewById(R.id.way_t_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(BeautifulLuXianActivity.this, BeautifulBinnerActivity.class);
                Bundle bundle = new Bundle();
                switch (position) {
                    case 0:
                        bundle.putInt("imgid", R.drawable.lushan2);
                        bundle.putString("title", "庐山两日游");
                        bundle.putString("detail", "庐山站出站5米有景区大巴售票点，20元到庐山景区门口，买景区大门票和100元景区观光车门票含上山下山车票，耗时1.5-2小时；");
                        break;
                    case 1:
                        bundle.putInt("imgid", R.drawable.lulinhu2);
                        bundle.putString("title", "芦林湖一日游");
                        bundle.putString("detail", "芦林湖位于江西省九江市庐山区海拔1040米的东谷芦林盆地，故又称东湖。芦林湖四周群山环抱，苍松翠柏，湖水如镜，似发光的碧玉镶嵌在林荫秀谷之中，在缥缈的云烟衬托下，犹如天上神湖。此处原是芦草丛生、野兽出没的芦林谷地，介于玉屏、星洲两峰之间。\n" +
                                "\n" +
                                "1954年此地筑坝蓄水，于是高峡出平湖，青山绿水，山色倒影，相映成趣，为庐山添了一处胜景。\n" +
                                "\n" +
                                "从黄龙寺沿石阶曲径上行约20分钟，便到芦林大桥。一路密林蔽日，树干高耸挺拔，夏日人行其间颇感凉爽。");
                        break;
                    case 2:
                        bundle.putInt("imgid", R.drawable.jinxiugu2);
                        bundle.putString("title", "锦绣谷一日游");
                        bundle.putString("detail", "1,到火车站bai对面坐105到 十里du大楼下车，哪里zhi有直接到庐山脚下的车（dao几块钱），（南门）到了后就庐山旅游大巴到锦绣谷。\n" +
                                "2, 打车到 九威大道 路口（几块钱）做公交到庐山北门（几块钱）再坐旅游打巴到锦绣谷。");
                        break;
                    case 3:
                        bundle.putInt("imgid", R.drawable.wulaofeng2);
                        bundle.putString("title", "五老峰两日游");
                        bundle.putString("detail", "联庐公交是到海会镇的，从东门那坐10元的电瓶车到三叠泉脚下，然后再买64的三叠泉门票爬山，爬到半山腰买180的大门票上山，再上去就是三叠泉停车场，可坐观光车到五老峰山门下");
                        break;
                    case 4:
                        bundle.putInt("imgid", R.drawable.wulongtan2);
                        bundle.putString("title", "乌龙谭一日游");
                        bundle.putString("detail", "江西九江乌龙潭 乌龙潭瀑布位于芦山风景区东谷山冲底头");
                        break;
                    case 5:
                        bundle.putInt("imgid", R.drawable.donglinsi2);
                        bundle.putString("title","东林寺一日游");
                        bundle.putString("detail", "从九江火车站步行bai约250米,到达火车站\n" +
                                "\n" +
                                "2、乘坐105路内环,经过8站, 到达七一三du厂站（也可乘坐103路）\n" +
                                "\n" +
                                "3、步行约10米,到达713厂站\n" +
                                "\n" +
                                "4、乘坐7路,经过15站, 到达东林寺站");


                }
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return imageIds.length;
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
            if (convertView == null) {
                myView = getLayoutInflater().inflate(R.layout.beautiful_way_item, null);

            } else {
                myView = convertView;

            }
            ImageView imageView = myView.findViewById(R.id.way_listview_img);
            imageView.setImageResource(imageIds[position]);

            TextView textView = myView.findViewById(R.id.way_listview_text);
            textView.setText(messages[position]);

            return myView;
        }
    }




}
