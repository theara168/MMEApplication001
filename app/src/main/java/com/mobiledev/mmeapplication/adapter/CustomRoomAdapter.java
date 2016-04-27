package com.mobiledev.mmeapplication.adapter;

/**
 * Created by ouen_theara on 3/28/2016.
 */

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.mobiledev.mmeapplication.R;
import com.mobiledev.mmeapplication.imageCatch.AppController;
import com.mobiledev.mmeapplication.model.Movie;


public class CustomRoomAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Movie> roomItems;

    public CustomRoomAdapter(Activity activity, List<Movie> roomItems) {
        this.activity = activity;
        this.roomItems = roomItems;
    }

    public CustomRoomAdapter(FragmentActivity activity, List<Movie> movieList) {
    }

    @Override
    public int getCount() {
        return roomItems.size();
    }

    @Override
    public Object getItem(int location) {
        return roomItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return convertView;
    }
}