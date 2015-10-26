package com.saurabh.popularmovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class MovieGridActivity extends AppCompatActivity implements OnTaskCompleted {
    private static final String TAG = MovieGridActivity.class.getCanonicalName();

    private static final String SORT_POPULARITY = "http://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=";
    private static final String SORT_RATING = "http://api.themoviedb.org/3/discover/movie?sort_by=vote_average.desc&api_key=";
    private static final String API_KEY = "32b9737e7c098f23e9c9996cea937869";

    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_grid);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        mProgressBar.setVisibility(View.VISIBLE);

        populateGrid();
    }

    public void populateGrid() {
        DataFetcher dataFetcher = new DataFetcher(this);
        String param = SORT_POPULARITY + API_KEY;
        dataFetcher.execute(param);
    }

    @Override
    public void onTaskCompleted(ArrayList<Movie> movies) {
        mProgressBar.setVisibility(View.INVISIBLE);
        GridAdapter adapter = new GridAdapter(this, movies);
        GridView gridview = (GridView) findViewById(R.id.movie_grid);
        gridview.setAdapter(adapter);

    }
}
