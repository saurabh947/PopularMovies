package com.saurabh.popularmovies;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageAdapter extends BaseAdapter {
    private static final String TAG = ImageAdapter.class.getCanonicalName();
    private Context mContext;

    public ImageAdapter(Context context) {
        mContext = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
//            imageView.setLayoutParams(new GridView.LayoutParams(540, 600));
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView = (ImageView) convertView;
        }

        Picasso.with(mContext).load("http://i.imgur.com/DvpvklR.png").into(imageView);

        //imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}