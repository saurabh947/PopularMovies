package com.saurabh.popularmovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.saurabh.popularmovies.constants.Constants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GridAdapter extends ArrayAdapter<Movie> {
    private static final String TAG = GridAdapter.class.getCanonicalName();

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
            viewHolder.movie_thumbnail = (ImageView) convertView.findViewById(R.id.grid_movie_poster);

            viewHolder.movie_thumbnail.setScaleType(ImageView.ScaleType.CENTER_CROP);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Picasso.with(mContext)
                .load(Constants.THUMBNAIL_URL + movie.getThumbnailPath())
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_error)
                .into(viewHolder.movie_thumbnail);

        return convertView;
    }

    private static class ViewHolder {
        ImageView movie_thumbnail;
    }
}