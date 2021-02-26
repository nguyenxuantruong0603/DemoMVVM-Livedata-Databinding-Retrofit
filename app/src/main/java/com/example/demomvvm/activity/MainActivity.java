package com.example.demomvvm.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.demomvvm.viewmodel.LoginViewModel;
import com.example.demomvvm.R;
import com.example.demomvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        LoginViewModel loginViewModel = new LoginViewModel(MainActivity.this);

        binding.setLoginViewModel(loginViewModel);
        
    }
}