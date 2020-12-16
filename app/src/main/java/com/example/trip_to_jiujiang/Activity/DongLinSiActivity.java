package com.example.trip_to_jiujiang.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.trip_to_jiujiang.R;
import com.squareup.picasso.Picasso;

public class DongLinSiActivity extends AppCompatActivity {
    private ImageView imageView;
    String address ="https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1689525121,3766900916&fm=26&gp=0.jpg";
    private ImageView imageView_back;
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.donglinsiactivity_layout);
        imageView = findViewById(R.id.image_donglinsi);
        imageView_back = findViewById(R.id.donglinsi_backArrow);
        Picasso.with(DongLinSiActivity.this).load(address).resize(1100,500).into(imageView);
        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DongLinSiActivity.this,InterestXunYangActivity.class);
                startActivity(intent);
            }
        });//image_back
    }
}
