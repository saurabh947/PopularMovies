/**
 * Copyright (C) 2015 Saurabh Agrawal
 */

package com.saurabh.popularmovies.ui.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.saurabh.popularmovies.R;
import com.saurabh.popularmovies.constants.Constants;
import com.saurabh.popularmovies.models.Movie;
import com.squareup.picasso.Picasso;

/**
 * Displays all the details of the clicked grid item in a new Activity.
 */

public class MovieDetailsActivity extends AppCompatActivity {
    private static final String TAG = MovieDetailsActivity.class.getSimpleName();

    private ActionBar mActionBar;
    private ImageView mMoviePoster;
    private ImageView mMovieThumbnail;
    private TextView mMovieName;
    private TextView mMovieReleaseDate;
    private TextView mMovieRating;
    private TextView mMovieSynopsis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        initComponents();
        setMovieData();
    }

    /**
     * Initializes the views.
     */
    public void initComponents() {
        mActionBar = getSupportActionBar();
        mMoviePoster = (ImageView) findViewById(R.id.movie_poster);
        mMovieThumbnail = (ImageView) findViewById(R.id.movie_thumbnail);
        mMovieName = (TextView) findViewById(R.id.movie_name);
        mMovieReleaseDate = (TextView) findViewById(R.id.movie_release_date);
        mMovieRating = (TextView) findViewById(R.id.movie_rating);
        mMovieSynopsis = (TextView) findViewById(R.id.movie_synopsis_text);
    }

    /** Sets the movie data to the views. */
    public void setMovieData() {
        Movie movie = (Movie) getIntent().getSerializableExtra("selectedMovie");

        if (movie != null) {
            mActionBar.setTitle(movie.getOriginalTitle());

            Picasso.with(this)
                    .load(Constants.POSTER_URL + movie.getPosterPath())
                    .placeholder(R.drawable.ic_placeholder)
                    .fit().centerCrop()
                    .into(mMoviePoster);
            Picasso.with(this)
                    .load(Constants.THUMBNAIL_URL + movie.getThumbnailPath())
                    .placeholder(R.drawable.ic_placeholder)
                    .fit().centerCrop()
                    .into(mMovieThumbnail);

            mMovieName.setText(movie.getOriginalTitle());
            if (movie.getReleaseDate().equals(getString(R.string.error_null))) {
                mMovieReleaseDate.setText(R.string.error_release_date);
            } else {
                mMovieReleaseDate.setText(movie.getReleaseDate());
            }

            mMovieRating.setText(String.valueOf(movie.getRating()));

            if (movie.getOverview().equals(getString(R.string.error_null))) {
                mMovieSynopsis.setText(R.string.error_overview);
            } else {
                mMovieSynopsis.setText(movie.getOverview());
            }
        }
    }
}
