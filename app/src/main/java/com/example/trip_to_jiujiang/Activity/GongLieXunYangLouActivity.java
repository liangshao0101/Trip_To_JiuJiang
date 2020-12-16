package com.example.trip_to_jiujiang.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.trip_to_jiujiang.R;
import com.squareup.picasso.Picasso;

public class GongLieXunYangLouActivity extends AppCompatActivity {
    private ImageView imageView_one;
    private ImageView imageView_two;
    private ImageView imageView_three;
    private ImageView imageView_back;
    String [] address = new String[]{"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1212103765,2282021214&fm=26&gp=0.jpg",
            "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=911105434,3351008259&fm=26&gp=0.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1608119187183&di=6403ddea15735348ed845a38242aeedf&imgtype=0&src=http%3A%2F%2Fstatic.shicishijie.cn%2F20160504%2F572968d6ea95f.jpg"};
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.gonglie_xunyanglouactivity_layout);
        imageView_one = findViewById(R.id.image_gonglie_xunyanglou_one);
        imageView_two = findViewById(R.id.image_gonglie_xunyanglou_two);
        imageView_three = findViewById(R.id.image_gonglie_xunyanglou_three);
        imageView_back = findViewById(R.id.xunyanglou2_backArrow);
        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GongLieXunYangLouActivity.this,XunYangGongLieActivity.class);
                startActivity(intent);
            }
        });//image_back
        Picasso.with(GongLieXunYangLouActivity.this).load(address[0]).resize(1100,500).into(imageView_one);
        Picasso.with(GongLieXunYangLouActivity.this).load(address[1]).resize(1100,500).into(imageView_two);
        Picasso.with(GongLieXunYangLouActivity.this).load(address[2]).resize(1100,500).into(imageView_three);
    }
}
