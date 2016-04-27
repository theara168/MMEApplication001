package com.mobiledev.mmeapplication.model;

/**
 * Created by Mr.Sotheara on 4/20/2016.
 */
public class RoomInfo {
    private int room_info_id;
    private String room_info_name;
    private String room_info_image;
    private String room_info_desc;

    public int getRoom_info_id() {
        return room_info_id;
    }

    public void setRoom_info_id(int room_info_id) {
        this.room_info_id = room_info_id;
    }

    public String getRoom_info_name() {
        return room_info_name;
    }

    public void setRoom_info_name(String room_info_name) {
        this.room_info_name = room_info_name;
    }

    public String getRoom_info_image() {
        return room_info_image;
    }

    public void setRoom_info_image(String room_info_image) {
        this.room_info_image = room_info_image;
    }

    public String getRoom_info_desc() {
        return room_info_desc;
    }

    public void setRoom_info_desc(String room_info_desc) {
        this.room_info_desc = room_info_desc;
    }

    public RoomInfo(int room_info_id, String room_info_name, String room_info_image, String room_info_desc) {
        this.room_info_id = room_info_id;
        this.room_info_name = room_info_name;
        this.room_info_image = room_info_image;
        this.room_info_desc = room_info_desc;
    }
    public RoomInfo(){}
}
