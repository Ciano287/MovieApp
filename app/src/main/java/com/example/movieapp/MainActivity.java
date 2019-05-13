package com.example.movieapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button submitBtn;
    EditText yearText;
    TextView testText;

    MainActivityViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitBtn = findViewById(R.id.submitBtn);
        yearText = findViewById(R.id.editYearText);
        testText = findViewById(R.id.testText);


        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final MovieAdapter adapter = new MovieAdapter();
        recyclerView.setAdapter(adapter);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.getPopularMovie(yearText.getText().toString());
            }
        });
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);


        viewModel.getError().observe(this, new Observer<String>() {

            @Override

            public void onChanged(@Nullable String s) {

                Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG)

                        .show();

            }

        });


        viewModel.getLiveMovie().observe(this, new Observer<String>() {

            @Override

            public void onChanged(@Nullable String s) {

                testText.setText(s);

            }

        });

    }
}
