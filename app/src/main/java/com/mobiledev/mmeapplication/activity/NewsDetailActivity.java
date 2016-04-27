package com.mobiledev.mmeapplication.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.mobiledev.mmeapplication.R;
import com.mobiledev.mmeapplication.fragment.NewsFragment;
import com.mobiledev.mmeapplication.imageCatch.AppController;
import com.mobiledev.mmeapplication.model.News;

public class NewsDetailActivity extends AppCompatActivity {
    TextView tvDescription,tvTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        tvTitles= (TextView) findViewById(R.id.tvTitleNewsDetail);
        tvDescription= (TextView) findViewById(R.id.tvDesctiptionNewsDetail);

        ImageLoader imageLoader = AppController.getInstance().getImageLoader();

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView thumbNail = (NetworkImageView) findViewById(R.id.thumbnailNewsDetail);

        Intent intent=getIntent();
        tvTitles.setText(intent.getStringExtra(NewsFragment.TITLES_NEWS));
        tvDescription.setText(intent.getStringExtra(NewsFragment.DESCRIPTION_NEWS));
        thumbNail.setImageUrl(intent.getStringExtra(NewsFragment.IMAGE_URL).toString(),imageLoader);
    }
}
