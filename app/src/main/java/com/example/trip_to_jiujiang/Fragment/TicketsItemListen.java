package com.example.trip_to_jiujiang.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.trip_to_jiujiang.R;

public class TicketsItemListen extends Activity {
    ImageView d_listen_back;
    ImageView d_listen_img;
    TextView d_listen_txt;
    TextView getD_listen_txt;
    TextView getD_listen_txt2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.door_listview_item_listen);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        d_listen_back = findViewById(R.id.d_listen_img);
        d_listen_img = findViewById(R.id.d_listen_img2);
        d_listen_txt = findViewById(R.id.d_listen_txt);
        getD_listen_txt = findViewById(R.id.d_listen_txt2);
        getD_listen_txt2 = findViewById(R.id.d_listen_txt3);
        d_listen_txt.setText("赣游");
        d_listen_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        d_listen_img.setImageResource(bundle.getInt("imgid"));
        getD_listen_txt.setText(bundle.getString("title"));
        getD_listen_txt2.setText(bundle.getString("price"));
    }
}
