package com.example.trip_to_jiujiang.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.trip_to_jiujiang.R;
import com.squareup.picasso.Picasso;

public class TimeMoneyActivity extends AppCompatActivity {
    private ImageView imageView;
    String address = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1608014679489&di=d8c14be808f49e182263813090cc7281&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20170215%2Fba4bc7f1b9f04e50853e8adfe074baac_th.jpeg";
    private ImageView imageView_back;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.timemoneyactivity_layout);
        imageView = findViewById(R.id.image_timeandmoney);
        imageView_back = findViewById(R.id.timeandmoney_backArrow);
        Picasso.with(TimeMoneyActivity.this).load(address).resize(1100, 500).into(imageView);
        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TimeMoneyActivity.this, InterestXunYangActivity.class);
                startActivity(intent);
            }
        });//image_back
    }
}
