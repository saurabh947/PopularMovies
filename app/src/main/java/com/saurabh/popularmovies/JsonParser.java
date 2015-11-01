package com.saurabh.popularmovies;

import android.util.Log;

import com.saurabh.popularmovies.constants.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonParser {
    private static final String TAG = JsonParser.class.getSimpleName();

    private String mInput;

    public JsonParser(String input) {
        mInput = input;
    }

    public ArrayList<Movie> parse() {
        ArrayList<Movie> movies = new ArrayList<>();

        if (mInput != null) {
            try {
                JSONObject jsonObj = new JSONObject(mInput);
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
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            Log.e(TAG, "Error: JSON input is null.");
        }
        return null;
    }
}
