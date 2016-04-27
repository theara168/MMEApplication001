package com.mobiledev.mmeapplication.model;

/**
 * Created by ouentheara on 4/26/16.
 */
public class News {
    private int news_id;
    private String news_titles;
    private String news_image;
    private String news_description;

    public News(int news_id, String news_titles, String news_image, String news_description) {
        this.news_id = news_id;
        this.news_titles = news_titles;
        this.news_image = news_image;
        this.news_description = news_description;
    }

    public News() {

    }

    public String getNews_image() {
        return news_image;
    }

    public void setNews_image(String news_image) {
        this.news_image = news_image;
    }



    public String getNews_description() {
        return news_description;
    }

    public void setNews_description(String news_description) {
        this.news_description = news_description;
    }

    public String getNews_titles() {
        return news_titles;
    }

    public void setNews_titles(String news_titles) {
        this.news_titles = news_titles;
    }

    public int getNews_id() {
        return news_id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
    }


}
