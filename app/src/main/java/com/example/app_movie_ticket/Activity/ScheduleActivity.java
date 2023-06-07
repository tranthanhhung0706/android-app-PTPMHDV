package com.example.app_movie_ticket.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_movie_ticket.Adapter.BrandListAdapter;
import com.example.app_movie_ticket.Adapter.SheduleListAdapter;
import com.example.app_movie_ticket.Model.Brand;
import com.example.app_movie_ticket.Model.Shedule;
import com.example.app_movie_ticket.Model.Time;
import com.example.app_movie_ticket.R;
import com.example.app_movie_ticket.interfacee.RvItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class ScheduleActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Shedule> sheduleList;
    SheduleListAdapter sheduleListAdapter;
    //
    RecyclerView recyclerView2;
    List<Brand> brandList;
    List<Time> TimeList;
    BrandListAdapter brandListAdapter;
    //
    ImageView img_buy;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        img_buy=findViewById(R.id.btn_buy_ticket_brand);
        recyclerView=findViewById(R.id.choose_date_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        sheduleList=new ArrayList<>();
        sheduleList.add(new Shedule("SAT","1"));
        sheduleList.add(new Shedule("SUN","2"));
        sheduleList.add(new Shedule("MON","3"));
        sheduleList.add(new Shedule("TES","4"));
        sheduleList.add(new Shedule("WED","5"));
        sheduleList.add(new Shedule("THU","6"));
        sheduleList.add(new Shedule("FRI","6"));
        sheduleListAdapter=new SheduleListAdapter(sheduleList);
        recyclerView.setAdapter(sheduleListAdapter);

        //
        recyclerView2=findViewById(R.id.choose_brand_ver);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        TimeList=new ArrayList<>();
        TimeList.add(new Time("12:30"));
        TimeList.add(new Time("13:00"));
        TimeList.add(new Time("14:00"));
        TimeList.add(new Time("16:00"));
        TimeList.add(new Time("17:00"));
        List<Time>  TimeList2=new ArrayList<>();
        TimeList2.add(new Time("12:31"));
        TimeList2.add(new Time("13:01"));
        TimeList2.add(new Time("14:01"));
        TimeList2.add(new Time("16:01"));
        TimeList2.add(new Time("17:01"));
        brandList=new ArrayList<>();
        brandList.add(new Brand("Hung",TimeList));
        brandList.add(new Brand("Danh",TimeList2));
//      brandList.add(new Brand("Anhd"));
//      brandList.add(new Brand("Phong"));
//      brandList.add(new Brand("Phuong"));
//      brandList.add(new Brand("Quyanh"));

        brandListAdapter=new BrandListAdapter(brandList,getBaseContext());
        recyclerView2.setAdapter(brandListAdapter);
        brandListAdapter.setRvItemClickListener(new RvItemClickListener() {
            @Override
            public void onChildItemClick(int parentPosition, int childPosition, Time item) {
                Log.i("hung",brandList.get(parentPosition).getNamebrand());
                Log.i("hung2",brandList.get(parentPosition).getTime().get(childPosition).getTime());
            }
        });
        img_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    sheduleListAdapter.getday();
//                    brandListAdapter.getbrand();
            }
        });
    }
}
