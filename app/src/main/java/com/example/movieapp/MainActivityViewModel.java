package com.example.movieapp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends AndroidViewModel {
    private MovieRepository movieRepository = new MovieRepository();
    private MutableLiveData<String> movie = new MutableLiveData<>();

    private MutableLiveData<String> error = new MutableLiveData<>();


    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<String> getError() {

        return error;

    }


    public MutableLiveData<String> getLiveMovie() {

        return movie;

    }
    public void getPopularMovie(String year) {

        movieRepository

                .getPopularMovies("3ab13467983de19609288c9dd60aa70c",
                        "vote_average.desc", year)

                .enqueue(new Callback<Movie>() {

                    @Override

                    public void onResponse(@NonNull Call<Movie> call, @NonNull Response<Movie> response) {

                        if (response.isSuccessful() && response.body() != null) {
                            List<Movie> movies;





//                            movie.setValue(response.body().getResults());
//                            movie.setValue(response.body().getBackdropPath());
//                            movie.setValue(response.body().getOverview());
//                            movie.setValue(response.body().getPosterPath());
//                            movie.setValue(response.body().getReleaseDate());

                        } else {

                            error.setValue("Api Error: " + response.message());

                        }

                    }


                    @Override

                    public void onFailure(@NonNull Call<Movie> call, @NonNull Throwable t) {

                        error.setValue("Api Error: " + t.getMessage());

                    }

                });

    }
}
