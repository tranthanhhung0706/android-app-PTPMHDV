package com.example.app_movie_ticket.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.example.app_movie_ticket.Activity.HomeFullActivity;
import com.example.app_movie_ticket.Adapter.MovieItemAdapter;
import com.example.app_movie_ticket.Adapter.SliderAdapter;
import com.example.app_movie_ticket.Api.ApiService;
import com.example.app_movie_ticket.Model.Movie;
import com.example.app_movie_ticket.Model.SliderItem;
import com.example.app_movie_ticket.R;
import com.example.app_movie_ticket.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentHome extends Fragment {

    private ViewPager2 viewPager2;
    private Handler sliderHandler=new Handler();

    private ImageView img_filter;
    //
    private RecyclerView recyclerView;
    List<Movie> movieList;
    MovieItemAdapter movieItemAdapter;

    TextView txt_viewAll;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home,container,false);
        viewPager2=view.findViewById(R.id.viewPager);
        img_filter=view.findViewById(R.id.img_filter);
        txt_viewAll=view.findViewById(R.id.txt_View);
        txt_viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), HomeFullActivity.class);
                startActivity(intent);
            }
        });
        img_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"hung",Toast.LENGTH_LONG).show();
            }
        });
        List<SliderItem> sliderItems=new ArrayList<>();
        sliderItems.add(new SliderItem(R.drawable.banner1));
        sliderItems.add(new SliderItem(R.drawable.banner2));
        sliderItems.add(new SliderItem(R.drawable.banner3));
        sliderItems.add(new SliderItem(R.drawable.banner1));
        sliderItems.add(new SliderItem(R.drawable.banner2));
        sliderItems.add(new SliderItem(R.drawable.banner3));
        viewPager2.setAdapter(new SliderAdapter(sliderItems,viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        CompositePageTransformer compositePageTransformer=new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r=1-Math.abs(position);
                page.setScaleY(0.85f+r * 0.14f);
            }
        });
        viewPager2.setPageTransformer(compositePageTransformer);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable,3000);

            }
        });
        //
        recyclerView=view.findViewById(R.id.list_movie_ver);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        ApiService.apiSevice.getAllMovie().enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                movieList=new ArrayList<>();
                movieList=response.body();
                for (int i=0;i<movieList.size();i++){
                    movieList.get(i).setImage(Utils.ip +"/image/"+response.body().get(i).getImage()+".png");
                }
                movieItemAdapter=new MovieItemAdapter(movieList);
                recyclerView.setAdapter(movieItemAdapter);
            }
            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {

            }
        });
//        movieList=new ArrayList<>();
//        movieList.add(new Movie(1,"http://192.168.1.16:8081/image/movie1.png","Iron Man 1","16:40,Sun May 22","Action"));
//        movieList.add(new Movie(2,"http://192.168.1.16:8081/image/movie2.png","Iron Man 2","13:40,Sun May 22","Action"));
//        movieList.add(new Movie(3,"http://192.168.1.16:8081/image/movie3.png","Iron Man 3","15:40,Sun May 22","Action"));
//        movieList.add(new Movie(4,"http://192.168.1.16:8081/image/movie4.png","Super Man","18:40,Sun May 22","Drama"));
//        movieList.add(new Movie(5,"http://192.168.1.16:8081/image/movie5.png","The Spongebod","16:40,Sun May 22","Drama"));
//        movieList.add(new Movie(6,"http://192.168.1.16:8081/image/movie6.png","Iron Man 6","13:40,Sun May 22","Comic"));
//        movieList.add(new Movie(7,"http://192.168.1.16:8081/image/movie1.png","Onward","15:40,Sun May 22","Comic"));
//        movieList.add(new Movie(8,"http://192.168.1.16:8081/image/movie2.png","Iron Man 8","18:40,Sun May 22","Horor"));
        return view;
    }
    private  Runnable sliderRunnable=new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem()+1);
        }
    };
}