package com.example.app_movie_ticket.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.app_movie_ticket.Activity.Login.LoginResponse;
import com.example.app_movie_ticket.Activity.Register.RegisterResponse;
import com.example.app_movie_ticket.ChooseSeatQ;
import com.example.app_movie_ticket.HomeActivity;
import com.example.app_movie_ticket.R;

public class ConfirmActivity extends AppCompatActivity {
    Button btn_next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        TextView vLoginRespone = findViewById(R.id.vLoginRespone);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null)
        {
            LoginResponse respone = (LoginResponse) bundle.get("loginRespone");
            if(respone !=null) vLoginRespone.setText(respone.getName() + respone.getUsername());
        }
        btn_next=findViewById(R.id.btn_create_account);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ConfirmActivity.this, HomeActivity.class);
//                Intent intent=new Intent(ConfirmActivity.this, ChooseSeatQ.class);

                LoginResponse respone2 = (LoginResponse) bundle.get("loginRespone");
//                intent.putExtra("token",respone2.getToken());
                Bundle bundle = new Bundle();
                bundle.putSerializable("user",respone2);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


    }
}