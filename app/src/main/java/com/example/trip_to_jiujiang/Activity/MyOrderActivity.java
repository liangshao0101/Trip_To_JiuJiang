/**
 * author:Liam
 * */
package com.example.trip_to_jiujiang.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.example.trip_to_jiujiang.Fragment.MyMessageFragment;
import com.example.trip_to_jiujiang.R;

public class MyOrderActivity extends AppCompatActivity {
   private LinearLayout linearLayout_specialty;
   private LinearLayout linearLayout_parking;
   private LinearLayout linearLayout_hotel;
   private LinearLayout linearLayout_tickets;
   private ImageView imageView_backMyMessage;
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.myorder_layout);
        initView();
        imageView_backMyMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyOrderActivity.this, MyMessageFragment.class);
                startActivity(intent);
            }
        });//imageView_backMyMessage
        linearLayout_specialty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyOrderActivity.this, MySpecialtyActivity.class);
                startActivity(intent);
            }
        });// linearLayout_specialty
        linearLayout_tickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyOrderActivity.this, MyTicketsActivity.class);
                startActivity(intent);
            }
        });//linearLayout_tickets
        linearLayout_hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyOrderActivity.this, MyHotelActivity.class);
                startActivity(intent);
            }
        });//linearLayout_hotel
        linearLayout_parking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyOrderActivity.this, MyParkingActivity.class);
                startActivity(intent);
            }
        });//linearLayout_parking
    }
    private void initView(){
        linearLayout_hotel = findViewById(R.id.linearlayout_hotel);
        linearLayout_parking = findViewById(R.id.linearlayout_parking);
        linearLayout_specialty = findViewById(R.id.linearlayout_specialty);
        linearLayout_tickets = findViewById(R.id.linearlayout_tickets);
        imageView_backMyMessage = findViewById(R.id.myorder_backArrow);
    }
}
