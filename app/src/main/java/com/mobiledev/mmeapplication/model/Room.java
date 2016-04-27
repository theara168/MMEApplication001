package com.mobiledev.mmeapplication.model;

import java.util.ArrayList;

/**
 * Created by Mr.Sotheara on 4/5/2016.
 */
public class Room {
    private int room_id;
    private String room_name;
    private String room_description;

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    private String urlImage;
    private int floor;
    private String link;
    private ArrayList<String> arrayList;

    public Room(int room_id, String room_name, String room_description, int floor, String link,String urlImage, ArrayList<String> arrayList) {
        this.room_id = room_id;
        this.room_name = room_name;
        this.room_description = room_description;
        this.floor = floor;
        this.link = link;
        this.urlImage=urlImage;
        this.arrayList = arrayList;
    }

    public Room() {

    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public String getRoom_description() {
        return room_description;
    }

    public void setRoom_description(String room_description) {
        this.room_description = room_description;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public ArrayList<String> getArrayList() {
        return arrayList;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setArrayList(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }
}
