package com.saurabh.popularmovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.saurabh.popularmovies.constants.Constants;

import java.util.ArrayList;

public class MovieGridActivity extends AppCompatActivity implements OnTaskCompleted {
    private static final String TAG = MovieGridActivity.class.getCanonicalName();

    ProgressBar mProgressBar;
    GridView gridview;

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
        String param = Constants.SORT_POPULARITY + Constants.API_KEY;
        dataFetcher.execute(param);
    }

    @Override
    public void onTaskCompleted(final ArrayList<Movie> movies) {
        if (movies == null) {
            mProgressBar.setVisibility(View.INVISIBLE);
            Toast.makeText(this, "Error -> Could not retrieve the movies.", Toast.LENGTH_LONG).show();
            return;
        }

        mProgressBar.setVisibility(View.INVISIBLE);
        Toast.makeText(this, "Success!", Toast.LENGTH_LONG).show();
        GridAdapter adapter = new GridAdapter(this, movies);
        gridview = (GridView) findViewById(R.id.movie_grid);
        gridview.setAdapter(adapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MovieGridActivity.this, MovieDetailsActivity.class);
                intent.putExtra("selectedMovie", movies.get(position));
                startActivity(intent);
            }
        });
    }
}
