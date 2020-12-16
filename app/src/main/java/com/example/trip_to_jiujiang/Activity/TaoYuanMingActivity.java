package com.example.trip_to_jiujiang.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.trip_to_jiujiang.R;
import com.squareup.picasso.Picasso;

public class TaoYuanMingActivity extends AppCompatActivity {
    private ImageView imageView;
    String address = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1608014293510&di=d6bd41d1043c79109968c2d216068e9f&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20181113%2Fb006a17fcc8d4f48b7655b113ee1baa5.jpeg";
    private ImageView imageView_back;
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.taoyuuanmingactivity_layout);
        imageView = findViewById(R.id.image_taoyuanming);
        imageView_back = findViewById(R.id.taoyuanming_backArrow);
        Picasso.with(TaoYuanMingActivity.this).load(address).resize(1100,500).into(imageView);
        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TaoYuanMingActivity.this,InterestXunYangActivity.class);
                startActivity(intent);
            }
        });//image_back
    }
}
