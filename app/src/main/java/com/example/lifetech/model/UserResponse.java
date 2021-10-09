package com.example.lifetech.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserResponse {

    @SerializedName("message")
    String message;
    @SerializedName("logged_in")
    boolean logged_in;
   // @SerializedName("data")
    //List<Kurs> data;

    public UserResponse(String message, boolean logged_in) {
        this.message = message;
        this.logged_in = logged_in;
       // this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isLogged_in() {
        return logged_in;
    }

    public void setLogged_in(boolean logged_in) {
        this.logged_in = logged_in;
    }

//    public List<Kurs> getData() {
//        return data;
//    }
//
//    public void setData(List<Kurs> data) {
//        this.data = data;
//    }
}