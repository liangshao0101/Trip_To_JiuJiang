package com.example.trip_to_jiujiang.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.trip_to_jiujiang.R;
import com.squareup.picasso.Picasso;

public class GongLieShiZhongShanActivity extends AppCompatActivity {
    private ImageView imageView_one;
    private ImageView imageView_two;
    private ImageView imageView_three;
    private ImageView imageView_four;
    private ImageView imageView_five;
    private ImageView imageView_six;
    private ImageView imageView_back;
    String [] address = new String[]{"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1608120253301&di=ba80037182f820a4d22b30b6c04afa70&imgtype=0&src=http%3A%2F%2Fyouimg1.c-ctrip.com%2Ftarget%2F100a0a0000004g7ii2AF5.jpg",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1608120310807&di=eb1c22624dce8722356f613573f979e3&imgtype=0&src=http%3A%2F%2Fxywb.jjxw.cn%2Fresfile%2F2019-06-19%2FA1%2Fp37_s.jpg",
                 "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1608120372641&di=58c675a1b185ac1288b5553d0095a7f8&imgtype=0&src=http%3A%2F%2Fn1.itc.cn%2Fimg8%2Fwb%2Frecom%2F2016%2F08%2F18%2F147151202050567400.JPEG",
                 "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1608120410383&di=ef8ba1f4bac40c84811eeb070de48419&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fbaike%2Fpic%2Fitem%2F29381f30e924b8996420086965061d950a7bf647.jpg",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1608120439707&di=76e298338b1637da66dd7758a698031d&imgtype=0&src=http%3A%2F%2Fphotos.tuchong.com%2F38367%2Ff%2F7131392.jpg"};
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.gonglie_shizhongshanactivity_layout);
        imageView_one = findViewById(R.id.image_gonglie_shizhongshan_one);
        imageView_two = findViewById(R.id.image_gonglie_shizhongshan_two);
        imageView_three = findViewById(R.id.image_gonglie_shizhongshan_three);
        imageView_four = findViewById(R.id.image_gonglie_shizhongshan_four);
        imageView_five = findViewById(R.id.image_gonglie_shizhongshan_five);

        imageView_back = findViewById(R.id.shizhongshan_backArrow);
        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GongLieShiZhongShanActivity.this,XunYangGongLieActivity.class);
                startActivity(intent);
            }
        });//image_back
        Picasso.with(GongLieShiZhongShanActivity.this).load(address[0]).resize(1100,500).into(imageView_one);
        Picasso.with(GongLieShiZhongShanActivity.this).load(address[1]).resize(1100,500).into(imageView_two);
        Picasso.with(GongLieShiZhongShanActivity.this).load(address[2]).resize(1100,500).into(imageView_three);
        Picasso.with(GongLieShiZhongShanActivity.this).load(address[3]).resize(1100,500).into(imageView_four);
        Picasso.with(GongLieShiZhongShanActivity.this).load(address[4]).resize(1100,500).into(imageView_five);

    }
}
