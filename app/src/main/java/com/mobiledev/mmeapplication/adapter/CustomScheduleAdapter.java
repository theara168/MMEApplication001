package com.mobiledev.mmeapplication.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.mobiledev.mmeapplication.R;
import com.mobiledev.mmeapplication.imageCatch.AppController;
import com.mobiledev.mmeapplication.model.News;
import com.mobiledev.mmeapplication.model.Schedule;

import java.util.List;

/**
 * Created by ouentheara on 4/27/16.
 */
public class CustomScheduleAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private Activity activity;
    private List<Schedule>schedulesItem;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public CustomScheduleAdapter(Activity activity, List<Schedule> schedulesItem) {
        this.activity = activity;
        this.schedulesItem = schedulesItem;
    }

    @Override
    public int getCount() {
        return schedulesItem.size();
    }

    @Override
    public Object getItem(int position) {
        return schedulesItem.get(position);
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
            convertView = inflater.inflate(R.layout.list_schedule_item, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView thumbNail = (NetworkImageView) convertView
                .findViewById(R.id.thumbnailScheduleItem);

        TextView tvTitlesItem = (TextView) convertView.findViewById(R.id.tvScheduleItemTitles);
        TextView tvDescItem = (TextView) convertView.findViewById(R.id.tvScheduleItemDescription);
        TextView tvFloorItem = (TextView) convertView.findViewById(R.id.tvScheduleItemFloor);
        TextView tvTimeItem = (TextView) convertView.findViewById(R.id.tvScheduleItemTime);

        Schedule sch=schedulesItem.get(position);

        thumbNail.setImageUrl(sch.getSchedule_image(), imageLoader);
        tvTitlesItem.setText(sch.getSchedule_titles());
        tvFloorItem.setText(sch.getSchedule_floor());
        tvTimeItem.setText(sch.getSchedule_time());
        tvDescItem.setText(sch.getSchedule_description());

        return convertView;
    }
}
