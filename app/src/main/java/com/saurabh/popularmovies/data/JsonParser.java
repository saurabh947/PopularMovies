/**
 * Copyright (C) 2015 Saurabh Agrawal
 */

package com.saurabh.popularmovies.data;

import android.util.Log;

import com.saurabh.popularmovies.constants.Constants;
import com.saurabh.popularmovies.models.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * This class parses the input JSON string and sets the Movie models.
 */

public class JsonParser {
    private static final String TAG = JsonParser.class.getSimpleName();

    /**
     * Parses the JSON and returns an ArrayList of Movie objects.
     */
    public ArrayList<Movie> parse(String input) throws JSONException {
        ArrayList<Movie> movies = new ArrayList<>();

        if (input != null) {
            JSONObject jsonObj = new JSONObject(input);
            JSONArray results = jsonObj.getJSONArray(Constants.RESULTS);

            // looping through all results
            for (int i = 0; i < results.length(); i++) {
                Movie movie = new Movie();
                JSONObject movieObject = results.getJSONObject(i);

                movie.setId(movieObject.getInt(Constants.ID));
                movie.setOriginalTitle(movieObject.getString(Constants.ORIGINAL_TITLE));
                movie.setOverview(movieObject.getString(Constants.OVERVIEW));
                movie.setPopularity(movieObject.getLong(Constants.POPULARITY));
                movie.setThumbnailPath(movieObject.getString(Constants.THUMBNAIL_PATH));
                movie.setRating(movieObject.getDouble(Constants.RATING));
                movie.setReleaseDate(movieObject.getString(Constants.RELEASE_DATE));
                movie.setPosterPath(movieObject.getString(Constants.POSTER_PATH));

                movies.add(movie);
            }
            return movies;

        } else {
            Log.e(TAG, "Error: JSON input is null");
        }
        return null;
    }
}
