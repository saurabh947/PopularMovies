package com.saurabh.popularmovies;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DataFetcher extends AsyncTask<String, Void, String> {
    private static final String TAG = DataFetcher.class.getCanonicalName();
    private OnTaskCompleted taskCompleted;

    public DataFetcher(OnTaskCompleted activityContext) {
        this.taskCompleted = activityContext;
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

    @Override
    protected void onPostExecute(String inputJson) {
        taskCompleted.onTaskCompleted(new JsonParser(inputJson).parse());
    }

    private String getData(String myUrl) throws IOException {
        InputStream inputStream = null;

        try {
            URL url = new URL(myUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            inputStream = connection.getInputStream();
            return readInputStream(inputStream);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return null;
    }

    // Reads an InputStream and converts it to a String.
    public String readInputStream(InputStream stream) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader rd = new BufferedReader(new InputStreamReader(stream));
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        Log.i(TAG, "" + sb.toString());
        return sb.toString();
    }
}
