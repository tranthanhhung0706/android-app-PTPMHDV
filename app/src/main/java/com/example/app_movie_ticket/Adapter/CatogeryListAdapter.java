package com.example.app_movie_ticket.Adapter;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_movie_ticket.Api.ApiService;
import com.example.app_movie_ticket.Model.Catogery;
import com.example.app_movie_ticket.Model.Movie;
import com.example.app_movie_ticket.R;
import com.example.app_movie_ticket.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CatogeryListAdapter extends RecyclerView.Adapter<CatogeryListAdapter.ViewHolder> {
    List<Catogery> list;
    boolean check=true;
    boolean select=false;
    int row_index=-1;
    UpdateVerticalRec updateVerticalRec;
    List<Movie> movieList;
    public CatogeryListAdapter(List<Catogery> list,UpdateVerticalRec updateVerticalRec) {
        this.list = list;
        this.updateVerticalRec=updateVerticalRec;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.catogery_hor_item,parent,false));
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txt_catogery1.setText(list.get(position).getCatogery());
        if(check) {
            ApiService.apiSevice.getAllMovie().enqueue(new Callback<List<Movie>>() {
                @Override
                public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
//                    Log.i("hung","hung1");
                    movieList=new ArrayList<>();
                    movieList=response.body();
                    for (int i=0;i<movieList.size();i++){
                        movieList.get(i).setImage(Utils.ip+"/image/"+response.body().get(i).getImage()+".png");
                    }
                    updateVerticalRec.callBack(position,movieList);
                    check = false;
                }
                @Override
                public void onFailure(Call<List<Movie>> call, Throwable t) {

                }
            });
        }
        if (select){
            if (position==0){
                holder.cardView.setBackgroundResource(R.drawable.change_bg);
                select=false;
            }
        }
        else {
            if (row_index==position){
                holder.cardView.setBackgroundResource(R.drawable.change_bg);
            }else {
                holder.cardView.setBackgroundResource(R.drawable.default_bg);
            }
        }
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                row_index=position;
                notifyDataSetChanged();
                if (list.get(position).getCatogery().equals("All")){

                    ApiService.apiSevice.getAllMovie().enqueue(new Callback<List<Movie>>() {
                        @Override
                        public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                            movieList=new ArrayList<>();
                            movieList=response.body();
                            for (int i=0;i<movieList.size();i++){
                                movieList.get(i).setImage(Utils.ip+"/image/"+response.body().get(i).getImage()+".png");
                            }
                            updateVerticalRec.callBack(position,movieList);
                        }
                        @Override
                        public void onFailure(Call<List<Movie>> call, Throwable t) {

                        }
                    });

                } else if (list.get(position).getCatogery().equals("Action")) {
                    ApiService.apiSevice.getAllMovie().enqueue(new Callback<List<Movie>>() {
                        @Override
                        public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                            List<Movie> list=new ArrayList<>();
                            movieList=new ArrayList<>();
                            movieList=response.body();
                            String ip = Utils.ip;
                            for (int i=0;i<movieList.size();i++){
                                if (movieList.get(i).getCatogery().equals("Action")){
                                    movieList.get(i).setImage(ip+"/image/"+response.body().get(i).getImage()+".png");
                                    list.add(movieList.get(i));
                                }
                            }

                            updateVerticalRec.callBack(position,list);
                        }
                        @Override
                        public void onFailure(Call<List<Movie>> call, Throwable t) {

                        }
                    });
                } else if (list.get(position).getCatogery().equals("Drama")) {
                    ApiService.apiSevice.getAllMovie().enqueue(new Callback<List<Movie>>() {
                        @Override
                        public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                            List<Movie> list=new ArrayList<>();
                            movieList=new ArrayList<>();
                            movieList=response.body();
                            for (int i=0;i<movieList.size();i++){
                                if (movieList.get(i).getCatogery().equals("Drama")){
                                    movieList.get(i).setImage(Utils.ip+"/image/"+response.body().get(i).getImage()+".png");
                                    list.add(movieList.get(i));
                                }
                            }
                            updateVerticalRec.callBack(position,list);
                        }
                        @Override
                        public void onFailure(Call<List<Movie>> call, Throwable t) {

                        }
                    });
                } else if (list.get(position).getCatogery().equals("Comic")) {
                    ApiService.apiSevice.getAllMovie().enqueue(new Callback<List<Movie>>() {
                        @Override
                        public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                            List<Movie> list=new ArrayList<>();
                            movieList=new ArrayList<>();
                            movieList=response.body();
                            for (int i=0;i<movieList.size();i++){
                                if (movieList.get(i).getCatogery().equals("Comic")){
                                    movieList.get(i).setImage(Utils.ip+"/image/"+response.body().get(i).getImage()+".png");
                                    list.add(movieList.get(i));
                                }
                            }
                            updateVerticalRec.callBack(position,list);
                            check = false;
                        }
                        @Override
                        public void onFailure(Call<List<Movie>> call, Throwable t) {

                        }
                    });
                } else if (list.get(position).getCatogery().equals("Horor")) {
                    ApiService.apiSevice.getAllMovie().enqueue(new Callback<List<Movie>>() {
                        @Override
                        public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                            List<Movie> list=new ArrayList<>();
                            movieList=new ArrayList<>();
                            movieList=response.body();
                            for (int i=0;i<movieList.size();i++){
                                if (movieList.get(i).getCatogery().equals("Horor")){
                                    movieList.get(i).setImage(Utils.ip+"/image/"+response.body().get(i).getImage()+".png");
                                    list.add(movieList.get(i));
                                }
                            }
                            updateVerticalRec.callBack(position,list);
                            check = false;
                        }
                        @Override
                        public void onFailure(Call<List<Movie>> call, Throwable t) {

                        }
                    });
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        if (list!=null){
            return list.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt_catogery1;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_catogery1=itemView.findViewById(R.id.txt_catogery1);
            cardView=itemView.findViewById(R.id.cardview_catogery);
        }
    }
}
