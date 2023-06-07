package com.example.app_movie_ticket.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app_movie_ticket.Model.Movie;
import com.example.app_movie_ticket.R;
import com.example.app_movie_ticket.fragment.FragmentAdapter;
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

public class DetailMovieActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    FragmentAdapter fragmentAdapter;
    TextView txt_name,txt_catogery;
    ImageView img_movie_detail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        tabLayout=findViewById(R.id.tab_layout);
        viewPager2=findViewById(R.id.view_pager2);
        txt_name=findViewById(R.id.txt_name_movie);
        txt_catogery=findViewById(R.id.txt_catogery_movie);
        img_movie_detail=findViewById(R.id.img_movie_detail);
        FragmentManager fm=getSupportFragmentManager();
        fragmentAdapter=new FragmentAdapter(fm,getLifecycle());
        viewPager2.setAdapter(fragmentAdapter);
        tabLayout.addTab(tabLayout.newTab().setText("About Movie"));
        tabLayout.addTab(tabLayout.newTab().setText("Review"));
        tabLayout.setTabTextColors(Color.parseColor("#a2a4b5"),Color.parseColor("#FFFFFFFF"));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
        Bundle bundle=getIntent().getExtras();
        if (bundle !=null){
            Movie movie= (Movie) bundle.get("movie");
            if (movie !=null){
                    txt_name.setText(movie.getName());
                    txt_catogery.setText(movie.getCatogery());
                    Picasso.get().load(movie.getImage()).into(img_movie_detail);
            }
        }

    }
}