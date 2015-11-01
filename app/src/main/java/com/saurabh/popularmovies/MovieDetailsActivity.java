package com.saurabh.popularmovies;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.saurabh.popularmovies.constants.Constants;
import com.squareup.picasso.Picasso;

public class MovieDetailsActivity extends AppCompatActivity {
    private static final String TAG = MovieDetailsActivity.class.getSimpleName();

    ImageView moviePoster;
    ImageView movieThumbnail;
    TextView movieName;
    TextView movieReleaseDate;
    TextView movieRating;
    TextView movieSynopsis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        initComponents();
        setMovieData();
    }

    public void initComponents() {
        moviePoster = (ImageView) findViewById(R.id.movie_poster);
        movieThumbnail = (ImageView) findViewById(R.id.movie_thumbnail);
        movieName = (TextView) findViewById(R.id.movie_name);
        movieReleaseDate = (TextView) findViewById(R.id.movie_release_date);
        movieRating = (TextView) findViewById(R.id.movie_rating);
        movieSynopsis = (TextView) findViewById(R.id.movie_synopsis_text);
    }

    public void setMovieData() {
        Movie movie = (Movie) getIntent().getSerializableExtra("selectedMovie");

        if (movie != null) {
            ActionBar bar = getSupportActionBar();
            bar.setTitle(movie.getOriginalTitle());

            Picasso.with(this)
                    .load(Constants.POSTER_URL + movie.getPosterPath())
                    .placeholder(R.drawable.ic_placeholder)
                    .fit().centerCrop()
                    .into(moviePoster);
            Picasso.with(this)
                    .load(Constants.THUMBNAIL_URL + movie.getThumbnailPath())
                    .placeholder(R.drawable.ic_placeholder)
                    .fit().centerCrop()
                    .into(movieThumbnail);

            movieName.setText(movie.getOriginalTitle());
            movieReleaseDate.setText(movie.getReleaseDate());
            movieRating.setText("" + movie.getRating());
            movieSynopsis.setText(movie.getOverview());
        }
    }
}
