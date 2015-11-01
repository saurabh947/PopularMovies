/**
 * Copyright (C) 2015 Saurabh Agrawal
 */

package com.saurabh.popularmovies.ui.helpers;

import com.saurabh.popularmovies.models.Movie;

import java.util.ArrayList;

/**
 * The interface used for returning the list of movies from the AsyncTask
 */

public interface OnTaskCompleted {

    /**
     * Called when the AsyncTask is finished executing
     */
    void onTaskCompleted(ArrayList<Movie> response);
}