package com.example.app_movie_ticket.Activity;

import androidx.appcompat.app.AppCompatActivity;
import com.example.app_movie_ticket.R;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class SeatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat);
        Intent intent=getIntent();
        String time1=intent.getStringExtra("time");
        Log.i("hung2",time1);
    }
}