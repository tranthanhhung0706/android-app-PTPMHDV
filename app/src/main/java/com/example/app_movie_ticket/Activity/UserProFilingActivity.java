package com.example.app_movie_ticket.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.app_movie_ticket.Activity.Register.RegisterActivity;
import com.example.app_movie_ticket.R;

public class UserProFilingActivity extends AppCompatActivity {
    Button btn_horor;
    ImageView img_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_pro_filing);
        setControlser();
        setEvent();
    }

    private void setEvent() {
        btn_horor.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                btn_horor.setBackgroundColor(Color.parseColor("#449EFF"));
                btn_horor.setTextColor(Color.WHITE);
            }
        });

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProFilingActivity.this, RegisterActivity.class);
                startActivity(intent);

            }
        });
    }


    private void setControlser() {

        btn_horor=findViewById(R.id.btn_horor);
        img_back = findViewById(R.id.img_back);


    }
}