package com.example.trip_to_jiujiang.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.trip_to_jiujiang.R;

public class PlayXuYangActivity extends Activity {

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.playxu_layout);

        ImageView imageView = findViewById(R.id.back);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent();
                x.setClass(PlayXuYangActivity.this, IndexActivity.class);
                startActivity(x);
            }
        });

    }

}
