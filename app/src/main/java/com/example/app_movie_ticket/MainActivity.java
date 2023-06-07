package com.example.app_movie_ticket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.app_movie_ticket.Activity.Login.LoginActivity;
import com.example.app_movie_ticket.Activity.Register.RegisterActivity;

public class MainActivity extends AppCompatActivity {
     Button btn_get_start;
     TextView txt_sign_in, vCreateAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }

    private void setEvent() {
        btn_get_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, ChartActivity.class);
                startActivity(intent);
            }
        });
        txt_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        vCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

    private void setControl() {
        btn_get_start=findViewById(R.id.btn_getstart);
        txt_sign_in=findViewById(R.id.txt_sign_in);
        vCreateAccount = findViewById(R.id.vCreateAccount);
    }
}