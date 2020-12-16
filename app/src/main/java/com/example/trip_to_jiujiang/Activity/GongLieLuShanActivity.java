package com.example.trip_to_jiujiang.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.trip_to_jiujiang.R;
import com.squareup.picasso.Picasso;

public class GongLieLuShanActivity extends AppCompatActivity {
    private ImageView imageView_one;
    private ImageView imageView_two;
    private ImageView imageView_three;
    private ImageView imageView_four;
    private ImageView imageView_back;
    String [] address = new String[]{"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1608115324026&di=cc2763d32a67c631773a7f7276adacda&imgtype=0&src=http%3A%2F%2Fww1.sinaimg.cn%2Flarge%2Fa575eebejw1e826z7zo4oj20f0078dix.jpg",
            "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=788384291,2751155898&fm=26&gp=0.jpg",
            "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1464053749,136160520&fm=26&gp=0.jpg",
            "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3519641588,313331936&fm=15&gp=0.jpg"};
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.gonglie_lushanactivity_layout);
         imageView_one = findViewById(R.id.image_gonglie_lushan_one);
         imageView_two = findViewById(R.id.image_gonglie_lushan_two);
         imageView_three = findViewById(R.id.image_gonglie_lushan_three);
         imageView_four = findViewById(R.id.image_gonglie_lushan_four);
         imageView_back = findViewById(R.id.lushan_backArrow);
         imageView_back.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(GongLieLuShanActivity.this,XunYangGongLieActivity.class);
                 startActivity(intent);
             }
         });//image_back
        Picasso.with(GongLieLuShanActivity.this).load(address[0]).resize(1100,500).into(imageView_one);
        Picasso.with(GongLieLuShanActivity.this).load(address[1]).resize(1100,500).into(imageView_two);
        Picasso.with(GongLieLuShanActivity.this).load(address[2]).resize(1100,500).into(imageView_three);
        Picasso.with(GongLieLuShanActivity.this).load(address[3]).resize(1100,500).into(imageView_four);

    }
}
