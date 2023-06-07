package com.example.app_movie_ticket.API;

import com.example.app_movie_ticket.DTO.BranchDTO;
import com.example.app_movie_ticket.DTO.CommentDTO;
import com.example.app_movie_ticket.DTO.MovieDTO;
import com.example.app_movie_ticket.DTO.User;
import com.example.app_movie_ticket.DTO.UserDTO;
import com.example.app_movie_ticket.Image;
import com.example.app_movie_ticket.Model.Movie;
import com.example.app_movie_ticket.Movies;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiService {
    // Link API http://10.252.3.24:3000
    Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
    ApiService apiService = new Retrofit.Builder().baseUrl("http://192.168.1.14:8080/")
            .addConverterFactory(GsonConverterFactory.create(gson)).build().create(ApiService.class);

    // Sử dụng ở màn hình chính
    @GET("movie/{id}")
    Call<MovieDTO> getDataMovie(@Path("id") Integer id);

    @GET("brand")
    Call<List<BranchDTO>> getAgencys();

    // Màn hình comment
    @GET("api/comment/{idMovie}")
    Call<List<CommentDTO>> getComments(@Path("idMovie") Integer id);

    @POST("api/comment")
    Call<CommentDTO> addComment(@Body CommentDTO commentDTO);

    @GET("api/movies")
    Call<List<Movies>> getAllMovie();

    @PUT("api/movies/{id}")
    Call<Movies> putMovie(@Body Movies movie, @Path("id") String id);
    @POST("api/movies")
    Call<Movies> postMovie(@Body Movies movie);
    @DELETE("api/movies/{id}")
    Call<Movies> delMovie(@Path("id") String id);

    @GET("imagesz")
    Call<List<Image>> getImages();
}
