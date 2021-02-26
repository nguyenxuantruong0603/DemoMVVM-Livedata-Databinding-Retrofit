package com.example.demomvvm.retrofit;

import com.example.demomvvm.datamodel.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/photos")
    Call<List<Movie>> getMovieList();
}
