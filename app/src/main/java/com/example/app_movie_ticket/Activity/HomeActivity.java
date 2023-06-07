package com.example.app_movie_ticket.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;

import com.example.app_movie_ticket.Adapter.AdapterViewPager;
import com.example.app_movie_ticket.Adapter.SliderAdapter;
import com.example.app_movie_ticket.Model.SliderItem;
import com.example.app_movie_ticket.R;
import com.example.app_movie_ticket.fragment.FragmentFavorite;
import com.example.app_movie_ticket.fragment.FragmentHome;
import com.example.app_movie_ticket.fragment.FragmentUser;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
//    private ViewPager2 viewPager2;
//    private Handler sliderHandler=new Handler();

    ViewPager2 pageMain;
    ArrayList<Fragment> fragmentArrayList=new ArrayList<>();
    BottomNavigationView bottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        viewPager2=findViewById(R.id.viewPager);
//        List<SliderItem> sliderItems=new ArrayList<>();
//        sliderItems.add(new SliderItem(R.drawable.banner1));
//        sliderItems.add(new SliderItem(R.drawable.banner2));
//        sliderItems.add(new SliderItem(R.drawable.banner3));
//        sliderItems.add(new SliderItem(R.drawable.banner1));
//        sliderItems.add(new SliderItem(R.drawable.banner2));
//        sliderItems.add(new SliderItem(R.drawable.banner3));
//        viewPager2.setAdapter(new SliderAdapter(sliderItems,viewPager2));
//        viewPager2.setClipToPadding(false);
//        viewPager2.setClipChildren(false);
//        viewPager2.setOffscreenPageLimit(3);
//        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
//        CompositePageTransformer compositePageTransformer=new CompositePageTransformer();
//        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
//        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
//            @Override
//            public void transformPage(@NonNull View page, float position) {
//                float r=1-Math.abs(position);
//                page.setScaleY(0.85f+r * 0.14f);
//            }
//        });
//        viewPager2.setPageTransformer(compositePageTransformer);
//        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
//            @Override
//            public void onPageSelected(int position) {
//                super.onPageSelected(position);
//
//                sliderHandler.removeCallbacks(sliderRunnable);
//                sliderHandler.postDelayed(sliderRunnable,3000);
//
//            }
//        });
        //
        pageMain=findViewById(R.id.pageMain);
        bottomNav=findViewById(R.id.bottomNav);
        fragmentArrayList.add(new FragmentHome());
        fragmentArrayList.add(new FragmentFavorite());
        fragmentArrayList.add(new FragmentUser());
        AdapterViewPager adapterViewPager=new AdapterViewPager(this,fragmentArrayList);
        pageMain.setAdapter(adapterViewPager);
        pageMain.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bottomNav.setSelectedItemId(R.id.itHome);
                        break;
                    case 1:
                        bottomNav.setSelectedItemId(R.id.itFavorite);
                        break;
                    case  2:
                        bottomNav.setSelectedItemId(R.id.itUser);
                        break;

                }
                super.onPageSelected(position);
            }
        });
        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.itHome:
                        pageMain.setCurrentItem(0);
                        break;
                    case  R.id.itFavorite:
                        pageMain.setCurrentItem(1);
                        break;
                    case R.id.itUser:
                        pageMain.setCurrentItem(2);
                        break;
                }
                return true;
            }
        });
    }
//    private  Runnable sliderRunnable=new Runnable() {
//        @Override
//        public void run() {
//            viewPager2.setCurrentItem(viewPager2.getCurrentItem()+1);
//        }
//    };
}