package com.example.app_movie_ticket.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.app_movie_ticket.Adapter.CatogeryListAdapter;
import com.example.app_movie_ticket.Adapter.MovieItemAdapter;
import com.example.app_movie_ticket.Adapter.MovieListAdapter;
import com.example.app_movie_ticket.Adapter.SheduleListAdapter;
import com.example.app_movie_ticket.Adapter.UpdateVerticalRec;
import com.example.app_movie_ticket.Model.Catogery;
import com.example.app_movie_ticket.Model.Movie;
import com.example.app_movie_ticket.Model.Shedule;
import com.example.app_movie_ticket.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFullActivity extends AppCompatActivity implements UpdateVerticalRec {
    RecyclerView recyclerView;
    List<Movie> movieList;
    MovieListAdapter movieListAdapter;
    SearchView searchView;
    //Horvertical Catogery
    RecyclerView recyclerView2;
    List<Catogery> catogeryList;
    CatogeryListAdapter catogeryListAdapter;
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_full);
        searchView=findViewById(R.id.searchView);
        //Horvertical Catogery
        recyclerView2=findViewById(R.id.list_movie_hor_rec);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        catogeryList=new ArrayList<>();
        catogeryList.add(new Catogery("All"));
        catogeryList.add(new Catogery("Action"));
        catogeryList.add(new Catogery("Drama"));
        catogeryList.add(new Catogery("Comic"));
        catogeryList.add(new Catogery("Horor"));
        catogeryListAdapter=new CatogeryListAdapter(catogeryList,this);
        recyclerView2.setAdapter(catogeryListAdapter);
        //
        recyclerView=findViewById(R.id.list_movie_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
//        movieList=new ArrayList<>();
//        movieList.add(new Movie(R.drawable.movie1,"Iron Man 1","16:40,Sun May 22","Action"));
//        movieList.add(new Movie(R.drawable.movie2,"Iron Man 2","13:40,Sun May 22","Action"));
//        movieList.add(new Movie(R.drawable.movie3,"Iron Man 3","15:40,Sun May 22","Action"));
//        movieList.add(new Movie(R.drawable.movie4,"Super Man","18:40,Sun May 22","Drama"));
//        movieList.add(new Movie(R.drawable.movie1,"The Spongebod","16:40,Sun May 22","Drama"));
//        movieList.add(new Movie(R.drawable.movie2,"Iron Man 6","13:40,Sun May 22","Comic"));
//        movieList.add(new Movie(R.drawable.movie3,"Onward","15:40,Sun May 22","Comic"));
//        movieList.add(new Movie(R.drawable.movie4,"Iron Man 8","18:40,Sun May 22","Horor"));
//        movieListAdapter=new MovieListAdapter(movieList);
//        recyclerView.setAdapter(movieListAdapter);
    }


    @Override
    public void callBack(int position, List<Movie> list) {
        movieListAdapter=new MovieListAdapter(list,getBaseContext());
        movieListAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(movieListAdapter);

        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<Movie> filList=new ArrayList<>();
                for (Movie item:list){
                    if (item.getName().toLowerCase().contains(newText.toLowerCase())){
                        filList.add(item);
                    }
                }
                if (filList.isEmpty()){
                    Toast.makeText(HomeFullActivity.this,"No data found",Toast.LENGTH_SHORT).show();
                }else {
                    movieListAdapter.setFilterList(filList);
                }
                return true;
            }
        });

    }
}