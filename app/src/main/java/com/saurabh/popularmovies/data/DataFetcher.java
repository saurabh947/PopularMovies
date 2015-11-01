/**
 * Copyright (C) 2015 Saurabh Agrawal
 */

package com.saurabh.popularmovies.data;

import android.os.AsyncTask;
import android.util.Log;

import com.saurabh.popularmovies.ui.helpers.OnTaskCompleted;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * An AsyncTask which queries themoviedb.org API for the list of movies
 * based on a particular sort order.
 */

// TODO: Change to IntentService to make the app robust
public class DataFetcher extends AsyncTask<String, Void, String> {
    private static final String TAG = DataFetcher.class.getSimpleName();
    private OnTaskCompleted mTaskCompleted;

    public DataFetcher(OnTaskCompleted context) {
        this.mTaskCompleted = context;
    }

    @Override
    protected String doInBackground(String... urls) {
        try {
            return getData(urls[0]);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Calls the JsonParser class to parse the AsyncTask JSON result.
     *
     * @param inputJson the JSON result
     */
    @Override
    protected void onPostExecute(String inputJson) {
        try {
            mTaskCompleted.onTaskCompleted(new JsonParser().parse(inputJson));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /** Connects to the server and gets the input stream. */
    private String getData(String myUrl) throws IOException {
        InputStream inputStream = null;

        try {
            URL url = new URL(myUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            inputStream = connection.getInputStream();
            return readInputStream(inputStream);

        } catch (Exception e) {
            Log.e(TAG, "Error: Could not connect to remote server.");
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return null;
    }

    /** Reads an InputStream and converts it to JSON String. */
    public String readInputStream(InputStream stream) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader rd = new BufferedReader(new InputStreamReader(stream));
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }
}
