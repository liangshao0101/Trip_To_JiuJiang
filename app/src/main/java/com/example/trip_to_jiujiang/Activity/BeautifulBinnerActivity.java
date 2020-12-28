package com.example.trip_to_jiujiang.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.trip_to_jiujiang.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;




public class BeautifulBinnerActivity extends AppCompatActivity {

    ImageView beau_img;
    ImageView beau_img2;
    TextView beau_text;
    TextView beaU_text2;
    TextView beau_text3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beautiful_binner_activity);
        beau_img = findViewById(R.id.beau_img);
        beau_text = findViewById(R.id.beau_txt);
        beaU_text2 = findViewById(R.id.beau_txt2);
        beau_img2 = findViewById(R.id.beau_back);
        beau_text3 = findViewById(R.id.beau_txt3);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        beau_img.setImageResource(bundle.getInt("imgid"));
        beau_text.setText(bundle.getString("title"));
        beau_text3.setText(bundle.getString("detail"));
        beaU_text2.setText(bundle.getString("title"));
        beau_img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }



}
