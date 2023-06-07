package com.example.app_movie_ticket.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_movie_ticket.Activity.SeatActivity;
import com.example.app_movie_ticket.Model.Time;
import com.example.app_movie_ticket.R;
import com.example.app_movie_ticket.interfacee.OnItemClickListener;

import java.util.List;

public class TimeListAdapter extends RecyclerView.Adapter<TimeListAdapter.ViewHolder>{
    List<Time> list;
    Context context;
    String time;
    boolean check=true;
    boolean select=false;
    int row_index=-1;
    private OnItemClickListener mListener;
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
    public TimeListAdapter(List<Time> list,Context context) {
        this.list = list;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.time_movie_hor_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txt_time_movie.setText(list.get(position).getTime());
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

//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                row_index=position;
//                notifyDataSetChanged();
//              //Log.i("danhbrand",BrandList);
////                Intent intent=new Intent(context, SeatActivity.class);
////                intent.putExtra("time",list.get(position).getTime());
////                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
////                context.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        if (list!=null){
            return  list.size();
        }
        return 0;
    }



    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt_time_movie;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_time_movie=itemView.findViewById(R.id.txt_time_movie);
            cardView=itemView.findViewById(R.id.cardview_time_movie);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onItemClick(getAdapterPosition());
                    row_index=getAdapterPosition();
                     notifyDataSetChanged();
                }
            });
        }
    }
}
