package com.example.demomvvm.datamodel;

import android.text.TextUtils;

public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkUsername() {
        return !TextUtils.isEmpty(username) && username.length() >= 6;
    }


    public boolean checkPassword() {
        return !TextUtils.isEmpty(password) && password.length() >= 8;
    }
}
