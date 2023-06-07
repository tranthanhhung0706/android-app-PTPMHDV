package com.example.app_movie_ticket.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.example.app_movie_ticket.Activity.Edit_Your_Profile_Activity;
import com.example.app_movie_ticket.Adapter.SliderAdapter;
import com.example.app_movie_ticket.Model.SliderItem;
import com.example.app_movie_ticket.R;

import java.util.ArrayList;
import java.util.List;


public class FragmentUser extends Fragment {
    TextView txt_edit_profile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_user, container, false);
        txt_edit_profile=view.findViewById(R.id.txt_edit_profile);
        txt_edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), Edit_Your_Profile_Activity.class);
                startActivity(intent);
            }
        });
        return view;
    }

}