package com.example.trip_to_jiujiang.DataBase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.example.trip_to_jiujiang.Activity.GoodFoodActivity;
import com.example.trip_to_jiujiang.R;
import com.example.trip_to_jiujiang.model.GoodFood;
import com.example.trip_to_jiujiang.model.HotelName;
import com.squareup.picasso.Picasso;

import java.util.List;
//吕明骏
public class Hotel_itemAdapter extends ArrayAdapter<HotelName> {
    private int resourceId;

    public Hotel_itemAdapter(Context context, int textViewResourceId, List<HotelName> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        HotelName goodFood=getItem(position);   //获取当前项的实例
        View view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        ImageView fruitImage=(ImageView)view.findViewById(R.id.goodfood_image);
        TextView fruitName=(TextView) view.findViewById(R.id.goodfood_text);
//        fruitImage.setImageResource(goodFood.getImageId());
        Picasso.with(getContext()).load(goodFood.getImageId()).resize(350, 150).into(fruitImage);
        fruitName.setText(goodFood.getName());
        return view;
    }

}
