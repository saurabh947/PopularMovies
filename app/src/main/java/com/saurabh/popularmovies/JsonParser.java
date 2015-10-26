package com.saurabh.popularmovies;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonParser {
    private static final String TAG = JsonParser.class.getSimpleName();
    private static final String RESULTS = "results";
    private static final String ID = "id";
    private static final String ORIGINAL_TITLE = "original_title";
    private static final String OVERVIEW = "overview";
    private static final String POSTER_PATH = "poster_path";
    private static final String POPULARITY = "popularity";
    private static final String RATING = "vote_average";
    private static final String RELEASE_DATE = "release_date";

    private String mInput;

    public JsonParser(String input) {
        mInput = input;
    }

    public ArrayList<Movie> parse() {
        ArrayList<Movie> movies = new ArrayList<>();

        if (mInput != null) {
            try {
                JSONObject jsonObj = new JSONObject(mInput);
                JSONArray results = jsonObj.getJSONArray(RESULTS);

                // looping through all results
                for (int i = 0; i < results.length(); i++) {
                    Movie movie = new Movie();
                    JSONObject movieObject = results.getJSONObject(i);

                    movie.setId(movieObject.getInt(ID));
                    movie.setOriginalTitle(movieObject.getString(ORIGINAL_TITLE));
                    movie.setOverview(movieObject.getString(OVERVIEW));
                    movie.setPopularity(movieObject.getLong(POPULARITY));
                    movie.setPosterPath(movieObject.getString(POSTER_PATH));
                    movie.setRating(movieObject.getLong(RATING));
                    movie.setReleaseDate(movieObject.getString(RELEASE_DATE));

                    movies.add(movie);
                }
                Log.i(TAG, "" + movies);
                return movies;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            Log.i(TAG, "JSON parse error -> input is null.");
        }
        return null;
    }
}
