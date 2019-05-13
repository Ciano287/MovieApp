package com.example.movieapp;

import retrofit2.Call;

public class MovieRepository {

    private MovieService movieService = MovieApi.create();

    public Call<Movie> getPopularMovies(String apiKey, String sortedBy, String year){
        return movieService.getPopularMovies(sortedBy, apiKey, year);
    }
}
