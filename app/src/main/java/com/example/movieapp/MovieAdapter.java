package com.example.movieapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.Movieholder> {
    private List<Movie> movies = new ArrayList<>();

    @NonNull
    @Override
    public Movieholder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_movie_detail, parent, false);
        return new Movieholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Movieholder movieholder, int position) {
        Movie currentMovie = movies.get(position);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class Movieholder extends RecyclerView.ViewHolder{


        public Movieholder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
