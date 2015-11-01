/**
 * Copyright (C) 2015 Saurabh Agrawal
 */

package com.saurabh.popularmovies.models;

import java.io.Serializable;

/**
 * Movie model used for storing & retrieving movie data. Each object contains all
 * the relevant movie information.
 */

// TODO: Change to use Android's Parcelable Interface to make the app faster.
public class Movie implements Serializable {
    private static final String TAG = Movie.class.getSimpleName();

    private int mId;
    private String mThumbnailPath;
    private String mOriginalTitle;
    private String mOverview;
    private double mPopularity;
    private double mRating;
    private String mReleaseDate;
    private String mPosterPath;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getThumbnailPath() {
        return mThumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.mThumbnailPath = thumbnailPath;
    }

    public String getOriginalTitle() {
        return mOriginalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.mOriginalTitle = originalTitle;
    }

    public String getOverview() {
        return mOverview;
    }

    public void setOverview(String overview) {
        this.mOverview = overview;
    }

    public double getPopularity() {
        return mPopularity;
    }

    public void setPopularity(double popularity) {
        this.mPopularity = popularity;
    }

    public double getRating() {
        return mRating;
    }

    public void setRating(double rating) {
        this.mRating = rating;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.mReleaseDate = releaseDate;
    }

    public String getPosterPath() {
        return mPosterPath;
    }

    public void setPosterPath(String posterPath) {
        this.mPosterPath = posterPath;
    }
}