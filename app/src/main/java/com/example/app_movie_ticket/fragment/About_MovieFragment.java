package com.example.app_movie_ticket.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.app_movie_ticket.Model.Movie;
import com.example.app_movie_ticket.R;
import com.squareup.picasso.Picasso;


public class About_MovieFragment extends Fragment {


    TextView txt_description;
    public About_MovieFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_about__movie, container, false);
        txt_description=view.findViewById(R.id.txt_description1);
        Bundle bundle=getActivity().getIntent().getExtras();
        if (bundle !=null){
            Movie movie= (Movie) bundle.get("movie");
            Log.i("hung",movie.getDescription());
            if (movie !=null){
                txt_description.setText(movie.getDescription());

            }
        }
        return  view;
    }
}