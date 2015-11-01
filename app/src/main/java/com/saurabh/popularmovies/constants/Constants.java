/**
 * Copyright (C) 2015 Saurabh Agrawal
 */

package com.saurabh.popularmovies.constants;

/**
 * App wide constants are declared here.
 */

public class Constants {

    public static final String SORT_POPULARITY = "http://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=";
    public static final String SORT_RATING = "http://api.themoviedb.org/3/discover/movie?sort_by=vote_average.desc&api_key=";
    public static final String THUMBNAIL_URL = "http://image.tmdb.org/t/p/w500";
    public static final String POSTER_URL = "http://image.tmdb.org/t/p/w780";

    // JSON fields
    public static final String RESULTS = "results";
    public static final String ID = "id";
    public static final String ORIGINAL_TITLE = "original_title";
    public static final String OVERVIEW = "overview";
    public static final String THUMBNAIL_PATH = "poster_path";
    public static final String POPULARITY = "popularity";
    public static final String RATING = "vote_average";
    public static final String ADULT = "adult";
    public static final String RELEASE_DATE = "release_date";
    public static final String POSTER_PATH = "backdrop_path";
}
