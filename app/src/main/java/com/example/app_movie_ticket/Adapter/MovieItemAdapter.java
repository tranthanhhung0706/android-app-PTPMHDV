package com.example.app_movie_ticket.Adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_movie_ticket.Model.Movie;
import com.example.app_movie_ticket.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieItemAdapter extends RecyclerView.Adapter<MovieItemAdapter.ViewHolder> {
    List<Movie> list;

    public MovieItemAdapter(List<Movie> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String imageUrl;
        imageUrl=list.get(position).getImage() ;
        Picasso.get().load(imageUrl).into(holder.imgHinh);
        holder.txt_name.setText(list.get(position).getName());
//            holder.imgHinh.setImageResource(list.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        if (list!=null){
            return  list.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgHinh;
        TextView txt_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHinh=itemView.findViewById(R.id.imhHinh);
            txt_name=itemView.findViewById(R.id.txt_name);
        }
    }
}
