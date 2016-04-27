package com.mobiledev.mmeapplication.adapter;

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
import com.mobiledev.mmeapplication.model.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ouentheara on 4/26/16.
 */
public class CustomNewsAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<News> newsItem;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public CustomNewsAdapter(Activity activity, List<News> newsItem) {
        this.newsItem=newsItem;
        this.activity=activity;
    }

    @Override
    public int getCount() {
        return newsItem.size();
    }

    @Override
    public Object getItem(int position) {
        return newsItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_news_item, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView thumbNail = (NetworkImageView) convertView
                .findViewById(R.id.thumbnailNewsItem);

        TextView tvTitlesItem = (TextView) convertView.findViewById(R.id.tvNewsItemTitles);
        TextView tvDescItem = (TextView) convertView.findViewById(R.id.tvNewsItemDescription);

        News n=newsItem.get(position);

        thumbNail.setImageUrl(n.getNews_image(), imageLoader);
        tvTitlesItem.setText(n.getNews_titles());
        tvDescItem.setText(n.getNews_description());

        return convertView;
    }
}
