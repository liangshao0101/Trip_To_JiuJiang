package com.example.trip_to_jiujiang.Fragment;
/**
 * author:zyg
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.trip_to_jiujiang.R;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.squareup.picasso.Picasso;


public class TransportActivity extends Activity {
    GridView gridView;
    String url = "https://images.pexels.com/photos/2440013/pexels-photo-2440013.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260";
    String url2 = "https://images.pexels.com/photos/3802510/pexels-photo-3802510.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260";
    MyAdapter myAdapter;
    ImageView tansport_img;
    ImageView transport_img2;

    int[] imageIds = new int[] {R.drawable.bus, R.drawable.scan, R.drawable.bicycle, R.drawable.park, R.drawable.charger, R.drawable.sun};
    String[] messages = new String[] {"查公交", "扫码乘车", "自行车", "停车场", "充电桩", "日照通"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);setContentView(R.layout.transport_fragment);
        gridView = findViewById(R.id.grid);
        myAdapter = new MyAdapter();
        gridView.setAdapter(myAdapter);
        tansport_img = findViewById(R.id.transport_image);
        Picasso.with(this).load(url).resize(1000, 400).into(tansport_img);
        transport_img2 = findViewById(R.id.t_back);
        transport_img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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
            if(convertView == null) {
                myView = getLayoutInflater().inflate(R.layout.transport_fragment_item, null);

            } else {
                myView = convertView;

            }
            ImageView imageView = myView.findViewById(R.id.tr_img);
            imageView.setImageResource(imageIds[position]);
            TextView textView = myView.findViewById(R.id.tr_text);
            textView.setText(messages[position]);


            return myView;
        }
    }
}

