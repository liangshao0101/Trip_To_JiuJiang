package com.example.trip_to_jiujiang.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.trip_to_jiujiang.R;
import com.squareup.picasso.Picasso;

public class HuXiXiaoTanActivity extends AppCompatActivity {
    private ImageView imageView;
    String address = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1608014483271&di=5ebdca1ea723e203463b2d48c74614e8&imgtype=0&src=http%3A%2F%2Fwww.chinamingjia.org%2Fuserfiles%2FImage%2Fb%252811%2529.jpg";
    private ImageView imageView_back;
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.huxixiaotanactivity_layout);
        imageView = findViewById(R.id.image_huxixiaotan);
        imageView_back = findViewById(R.id.huxixiaotan_backArrow);
        Picasso.with(HuXiXiaoTanActivity.this).load(address).resize(1100,500).into(imageView);
        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HuXiXiaoTanActivity.this,InterestXunYangActivity.class);
                startActivity(intent);
            }
        });//image_back
    }
}
