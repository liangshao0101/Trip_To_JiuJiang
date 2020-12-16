package com.example.trip_to_jiujiang.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.trip_to_jiujiang.R;
import com.squareup.picasso.Picasso;

public class GongLieDongLinSiActivity extends AppCompatActivity {
    private ImageView imageView_one;
    private ImageView imageView_two;
    private ImageView imageView_three;
    private ImageView imageView_four;
    private ImageView imageView_back;
    String [] address = new String[]{"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1608117388173&di=209365e54ffe07717cf90715f641b40a&imgtype=0&src=http%3A%2F%2Fwww.donglin.org%2Fuploads%2Fallimg%2F180801%2F31-1PP1201607.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1608117402537&di=96a8a1b3e14f60e64edc0082588f91a7&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fforum%2Fpic%2Fitem%2F46b238dbb6fd526673697bf9ab18972bd5073612.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1608117424830&di=9500cb217351f3d251075785710d7d89&imgtype=0&src=http%3A%2F%2Fwww.donglin.org%2Fuploads%2Fallimg%2F180219%2F31-1P219153314.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1608117440897&di=645d78870dbd62b20dacbe2c1040ad2e&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20190615%2F1294c69e2a33492e90027c33f559d1be.jpeg"};
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.gonglie_donglinsiactivity_layout);
        imageView_one = findViewById(R.id.image_gonglie_donglinsi_one);
        imageView_two = findViewById(R.id.image_gonglie_donglinsi_two);
        imageView_three = findViewById(R.id.image_gonglie_donglinsi_three);
        imageView_four = findViewById(R.id.image_gonglie_donglinsi_four);
        imageView_back = findViewById(R.id.donglinsi2_backArrow);
        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GongLieDongLinSiActivity.this,XunYangGongLieActivity.class);
                startActivity(intent);
            }
        });//image_back
        Picasso.with(GongLieDongLinSiActivity.this).load(address[0]).resize(1100,500).into(imageView_one);
        Picasso.with(GongLieDongLinSiActivity.this).load(address[1]).resize(1100,500).into(imageView_two);
        Picasso.with(GongLieDongLinSiActivity.this).load(address[2]).resize(1100,500).into(imageView_three);
        Picasso.with(GongLieDongLinSiActivity.this).load(address[3]).resize(1100,500).into(imageView_four);

    }
}
