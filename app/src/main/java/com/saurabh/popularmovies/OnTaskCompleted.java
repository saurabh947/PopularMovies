package com.saurabh.popularmovies;

import java.util.ArrayList;

public interface OnTaskCompleted {
    void onTaskCompleted(ArrayList<Movie> response);
}