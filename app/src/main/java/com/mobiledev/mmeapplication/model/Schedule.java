package com.mobiledev.mmeapplication.model;

import java.util.ArrayList;

/**
 * Created by ouen_theara on 3/26/2016.
 */
public class Schedule {
    private String schedule_floor;
    private String schedule_description;
    private String schedule_time;
    private int schedule_id;
    private String schedule_titles;
    private String schedule_image;


    public Schedule(int schedule_id, String schedule_titles, String schedule_image, String schedule_floor, String schedule_description, String schedule_time) {
        this.schedule_id = schedule_id;
        this.schedule_titles = schedule_titles;
        this.schedule_image = schedule_image;
        this.schedule_floor = schedule_floor;
        this.schedule_description = schedule_description;
        this.schedule_time = schedule_time;
    }


    public Schedule() {
    }

    public String getSchedule_floor() {
        return schedule_floor;
    }

    public void setSchedule_floor(String schedule_floor) {
        this.schedule_floor = schedule_floor;
    }

    public int getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }

    public String getSchedule_titles() {
        return schedule_titles;
    }

    public void setSchedule_titles(String schedule_titles) {
        this.schedule_titles = schedule_titles;
    }

    public String getSchedule_image() {
        return schedule_image;
    }

    public void setSchedule_image(String schedule_image) {
        this.schedule_image = schedule_image;
    }

    public String getSchedule_description() {
        return schedule_description;
    }

    public void setSchedule_description(String schedule_description) {
        this.schedule_description = schedule_description;
    }

    public String getSchedule_time() {
        return schedule_time;
    }

    public void setSchedule_time(String schedule_time) {
        this.schedule_time = schedule_time;
    }

}
