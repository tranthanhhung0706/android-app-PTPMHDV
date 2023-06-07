package com.example.app_movie_ticket.API;

import com.example.app_movie_ticket.Model.Movie;
import com.example.app_movie_ticket.Movies;

import java.util.ArrayList;

public interface MovieCallback {

    void onMovieLoaded(ArrayList<Movies> movies);
}