package com.example.app_movie_ticket.Adapter;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_movie_ticket.Model.Shedule;
import com.example.app_movie_ticket.R;

import java.util.List;

public class SheduleListAdapter extends RecyclerView.Adapter<SheduleListAdapter.ViewHolder> {
    List<Shedule> list;
    boolean check=true;
    boolean select=false;
    int row_index=-1;
    String day;
    public SheduleListAdapter(List<Shedule> list) {
        this.list = list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.choose_date_hor_item,parent,false));
    }
    public void getday(){
        Log.i("hung", day);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txt_day.setText(list.get(position).getDay());
        holder.txt_date.setText(list.get(position).getDate());
        if (select){
            if (position==0){
                holder.cardView.setBackgroundResource(R.drawable.change_bg_date);
                select=false;
            }
        }
        else {
            if (row_index==position){
                holder.cardView.setBackgroundResource(R.drawable.change_bg_date);
            }else {
                holder.cardView.setBackgroundResource(R.drawable.default_bg);
            }
        }
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                row_index=position;
                notifyDataSetChanged();
                //Log.i("hung", list.get(position).getDay());
                day=list.get(position).getDay();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (list!=null){
            return  list.size();

        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt_day,txt_date;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_day=itemView.findViewById(R.id.txt_day);
            txt_date=itemView.findViewById(R.id.txt_date);
            cardView=itemView.findViewById(R.id.cardview_choose_date);
        }
    }
}
