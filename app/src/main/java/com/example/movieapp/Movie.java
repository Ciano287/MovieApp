package com.example.movieapp;

import com.google.gson.annotations.SerializedName;

public class Movie {

    @SerializedName("results")
    private Result results;

    public Movie(Result results) {
        this.results = results;
    }

    public Result getResults() {
        return results;
    }
}


