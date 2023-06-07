package com.example.app_movie_ticket.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_movie_ticket.Activity.DetailMovieActivity;
import com.example.app_movie_ticket.Model.Movie;
import com.example.app_movie_ticket.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {
    List<Movie> list;
    Context context;
    public MovieListAdapter(List<Movie> list,Context context) {
        this.list = list;
        this.context=context;
    }

    public void setFilterList(List<Movie> filterList){
        this.list=filterList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_movie_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String imageUrl;
        imageUrl=list.get(position).getImage() ;
        Picasso.get().load(imageUrl).into(holder.imageView);
//        holder.imageView.setImageResource(list.get(position).getImage());
        holder.txt_name.setText(list.get(position).getName());
        holder.txt_date.setText(list.get(position).getDate());
        holder.txt_catogery.setText(list.get(position).getAuthor());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), list.get(position).getName(),Toast.LENGTH_LONG).show();
                Intent intent=new Intent(context, DetailMovieActivity.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("movie",list.get(position));
                intent.putExtras(bundle);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (list !=null){
            return  list.size();
        }
        return 0;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView txt_name,txt_date,txt_catogery;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.img_movie);
            txt_name=itemView.findViewById(R.id.txt_name);
            txt_date=itemView.findViewById(R.id.txt_date);
            txt_catogery=itemView.findViewById(R.id.txt_catogery);
            cardView=itemView.findViewById(R.id.cardview);
        }
    }
}
