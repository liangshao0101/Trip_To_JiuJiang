package com.example.trip_to_jiujiang.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.trip_to_jiujiang.R;

public class SignUpActivity extends AppCompatActivity {
    private ImageView imageView_backUp;
    private TextView textView_signIn;
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.sign_up_layout);
        imageView_backUp  = findViewById(R.id.signUp_backArrow);
        textView_signIn = findViewById(R.id.text_signIn);
        imageView_backUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
