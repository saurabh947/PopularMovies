//package com.saurabh.popularmovies;
//
//import android.os.AsyncTask;
//import android.util.Log;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//public class DataFetcher extends AsyncTask<String, Integer, String> {
//    private static final String TAG = DataFetcher.class.getCanonicalName();
//
//    @Override
//    protected String doInBackground(String... urls) {
//        try {
//            return getData(urls[0]);
//        } catch (IOException e) {
//            return "Unable to retrieve web page. URL may be invalid.";
//        }
//
//    }
//
//    protected void onPostExecute(Long result) {
//
//    }
//
//    private String getData(String myUrl) throws IOException {
//        InputStream inputStream = null;
//        // Only display the first 500 characters of the retrieved
//        // web page content.
////        int len = 500;
//
//        try {
//            URL url = new URL(myUrl);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
////            conn.setReadTimeout(10000 /* milliseconds */);
////            conn.setConnectTimeout(15000 /* milliseconds */);
//            conn.setRequestMethod("GET");
////            conn.setDoInput(true);
//
//            // Starts the query
//            conn.connect();
//            int response = conn.getResponseCode();
//            Log.d(TAG, "The response is: " + response);
//            inputStream = conn.getInputStream();
//
//            // Convert the InputStream into a string
//            String contentAsString = readIt(inputStream, len);
//            return contentAsString;
//
//            // Makes sure that the InputStream is closed after the app is
//            // finished using it.
//        } finally {
//            if (is != null) {
//                is.close();
//            }
//        }
//    }
//
//}
