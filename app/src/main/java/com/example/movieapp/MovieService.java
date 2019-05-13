package com.example.movieapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {


    @GET("discover/movie")
    Call<Movie> getPopularMovies(@Query("sort_by") String sortedBy, @Query("api_key") String ApiKey
    , @Query("primary_release_year") String primaryReleaseYear);

//?sort_by=vote_average.desc&api_key=3ab13467983de19609288c9dd60aa70c&primary_release_year={id}
}


