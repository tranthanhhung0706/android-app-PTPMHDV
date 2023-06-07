package com.example.app_movie_ticket.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_movie_ticket.Model.Brand;
import com.example.app_movie_ticket.Model.Time;
import com.example.app_movie_ticket.R;
import com.example.app_movie_ticket.interfacee.OnItemClickListener;
import com.example.app_movie_ticket.interfacee.RvItemClickListener;

import java.util.List;

public class BrandListAdapter extends RecyclerView.Adapter<BrandListAdapter.ViewHolder>{
    List<Brand> list;
    List<Time> TimeList;
    Context context;
    String brand;
    RvItemClickListener rvItemClickListener;
    public void setRvItemClickListener(RvItemClickListener rvItemClickListener){
        this.rvItemClickListener = rvItemClickListener;
    }
    public BrandListAdapter(List<Brand> list,Context context) {
        this.list = list;
//        this.TimeList = TimeList;
        this.context=context;
    }
    public BrandListAdapter(){

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.brand_ver_item,parent,false));
    }
    public void getbrand(){
            Log.i("getbrand",brand);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//            Brand liBrand=list.get(position);
            Brand model=list.get(position);
            boolean isExpandable = list.get(position).isExpandable();
            holder.expandableLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);
            if (isExpandable){
            holder.mArrowImage.setImageResource(R.drawable.arrow_up);
            }else{
            holder.mArrowImage.setImageResource(R.drawable.arrow_down);
            }
            holder.txt_namebrand.setText(list.get(position).getNamebrand());

            TimeListAdapter timeListAdapter=new TimeListAdapter(TimeList,context);
            holder.recyclerView.setLayoutManager(new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false));
            holder.recyclerView.setAdapter(timeListAdapter);
            timeListAdapter.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(int timePosition) {
                   Time item=TimeList.get(timePosition);
                    rvItemClickListener.onChildItemClick(holder.getAdapterPosition(), timePosition,item);
                }
            });
            holder.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        model.setExpandable(!model.isExpandable());
                        TimeList = model.getTime();
                        notifyItemChanged(holder.getAdapterPosition());
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



    public class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout linearLayout;
        private RelativeLayout expandableLayout;
        TextView txt_namebrand;
        RecyclerView recyclerView;
        ImageView mArrowImage;
        List<Time> timeList;
        TimeListAdapter timeListAdapter;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_namebrand=itemView.findViewById(R.id.txt_namebrand);
            recyclerView=itemView.findViewById(R.id.time_movie_start);
            linearLayout=itemView.findViewById(R.id.linear_brand);
            expandableLayout=itemView.findViewById(R.id.expandable_layout);
            mArrowImage=itemView.findViewById(R.id.arro_imageview);

        }
    }
}
