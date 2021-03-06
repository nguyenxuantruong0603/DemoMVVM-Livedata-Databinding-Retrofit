package com.example.demomvvm.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import androidx.databinding.library.baseAdapters.BR;

import com.example.demomvvm.activity.HomeActivity;
import com.example.demomvvm.activity.MovieActivity;
import com.example.demomvvm.datamodel.User;

public class LoginViewModel extends BaseObservable {

    private String username;
    private String password;
    public ObservableField<String> message = new ObservableField<>();

    private Context context;

    public LoginViewModel(Context context) {
        this.context = context;
    }

    @Bindable
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        notifyPropertyChanged(BR.username);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    public void onclickLogin() {
        User user = new User(getUsername(), getPassword());

        if (user.checkUsername() && user.checkPassword()) {
            message.set("Ok Bro");
            Toast.makeText(context, "Login Success", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, HomeActivity.class);
            context.startActivity(intent);
        } else {
            message.set("Username or password valid");
            Toast.makeText(context, "Login Fail", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, MovieActivity.class);
            context.startActivity(intent);
        }
    }

}
