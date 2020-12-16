package com.example.trip_to_jiujiang.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.trip_to_jiujiang.R;
import com.squareup.picasso.Picasso;

public class GongLieBaiMuDaActivity extends AppCompatActivity {
    private ImageView imageView_one;
    private ImageView imageView_two;
    private ImageView imageView_three;
    private ImageView imageView_back;
    private String [] address = new String[]{"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1608118319942&di=871f86a4febd09b375cde699fea204b8&imgtype=0&src=http%3A%2F%2Fn.sinaimg.cn%2Fsinacn20190510s%2F243%2Fw640h403%2F20190510%2Fe964-hwsffzc3110925.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1608118362673&di=abd4dd57f50df75cfe31b1125c465a21&imgtype=0&src=http%3A%2F%2Finews.gtimg.com%2Fnewsapp_match%2F0%2F2466900498%2F0.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1608118484886&di=202f3bb5567f2002f0ffcdef50b2bd53&imgtype=0&src=http%3A%2F%2Fn.sinaimg.cn%2Fsinacn12%2F496%2Fw800h496%2F20181128%2F4079-hpinrya6800011.jpg"};
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.gonglie_baimudaactivity_layout);
        imageView_one = findViewById(R.id.image_gonglie_baimuda_one);
        imageView_two = findViewById(R.id.image_gonglie_baimuda_two);
        imageView_three = findViewById(R.id.image_gonglie_baimuda_three);
        imageView_back = findViewById(R.id.baimuda_backArrow);
        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GongLieBaiMuDaActivity.this,XunYangGongLieActivity.class);
                startActivity(intent);
            }
        });//image_back
        Picasso.with(GongLieBaiMuDaActivity.this).load(address[0]).resize(1100,500).into(imageView_one);
        Picasso.with(GongLieBaiMuDaActivity.this).load(address[1]).resize(1100,500).into(imageView_two);
        Picasso.with(GongLieBaiMuDaActivity.this).load(address[2]).resize(1100,500).into(imageView_three);
    }
}
