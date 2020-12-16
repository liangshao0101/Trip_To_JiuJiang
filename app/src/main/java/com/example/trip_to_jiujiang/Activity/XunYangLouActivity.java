package com.example.trip_to_jiujiang.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.trip_to_jiujiang.R;
import com.squareup.picasso.Picasso;

public class XunYangLouActivity extends AppCompatActivity {
    private ImageView imageView;
    String address = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1608014421870&di=7fff2fe04bd93b2b1065dd9532657ece&imgtype=0&src=http%3A%2F%2Fwww.nyrwx.cn%2Ftour%2Fimg%2F20111128155842347.jpg";
    private ImageView imageView_back;
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.xunyanglouactivity_layout);
        imageView = findViewById(R.id.image_xunyanglou);
        imageView_back = findViewById(R.id.xunyanglou_backArrow);
        Picasso.with(XunYangLouActivity.this).load(address).resize(1100,500).into(imageView);
        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(XunYangLouActivity.this,InterestXunYangActivity.class);
                startActivity(intent);
            }
        });//image_back
    }
}
