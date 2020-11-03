package com.example.trip_to_jiujiang.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.trip_to_jiujiang.R;

public class SignInActivity extends AppCompatActivity {
    private ImageView imageView_back;
    private TextView textView_signUp;
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.sign_in_layout);
        imageView_back = findViewById(R.id.signIn_backArrow);
        textView_signUp = findViewById(R.id.text_signUp);
        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        textView_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
