package com.mobiledev.mmeapplication.model;

/**
 * Created by ouen_theara on 3/26/2016.
 */
public class User {
    private int U_ID;
    private String U_Name;
    private String U_Pass;

    public User() {
    }

    public User(int u_ID, String u_Name, String u_Pass) {
        U_ID = u_ID;
        U_Name = u_Name;
        U_Pass = u_Pass;
    }

    public int getU_ID() {
        return U_ID;
    }

    public void setU_ID(int u_ID) {
        U_ID = u_ID;
    }

    public String getU_Name() {
        return U_Name;
    }

    public void setU_Name(String u_Name) {
        U_Name = u_Name;
    }

    public String getU_Pass() {
        return U_Pass;
    }

    public void setU_Pass(String u_Pass) {
        U_Pass = u_Pass;
    }
}
