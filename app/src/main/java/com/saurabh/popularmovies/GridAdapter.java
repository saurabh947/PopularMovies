package com.saurabh.popularmovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GridAdapter extends ArrayAdapter<Movie> {
    private static final String TAG = GridAdapter.class.getCanonicalName();
    private static final String POSTER_PATH = "http://image.tmdb.org/t/p/w500";

    private Context mContext;

    public GridAdapter(Context context, ArrayList<Movie> movies) {
        super(context, 0, movies);
        mContext = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        Movie movie = getItem(position);
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.movie_grid_item, parent, false);
            viewHolder.movie_poster = (ImageView) convertView.findViewById(R.id.grid_movie_poster);
            viewHolder.movie_name = (TextView) convertView.findViewById(R.id.grid_movie_name);

            viewHolder.movie_poster.setScaleType(ImageView.ScaleType.CENTER_CROP);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Picasso.with(mContext)
                .load(POSTER_PATH + movie.getPosterPath())
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_error)
                .into(viewHolder.movie_poster);

        //viewHolder.movie_poster.setImageResource();
        viewHolder.movie_name.setText(movie.getOriginalTitle());

        return convertView;
    }

    private static class ViewHolder {
        TextView movie_name;
        ImageView movie_poster;
    }
}