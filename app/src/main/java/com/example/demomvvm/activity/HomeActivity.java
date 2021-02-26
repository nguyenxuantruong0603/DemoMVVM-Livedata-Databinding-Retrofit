package com.example.demomvvm.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.demomvvm.R;
import com.example.demomvvm.adapter.BookAdapter;
import com.example.demomvvm.databinding.ActivityHomeBinding;
import com.example.demomvvm.datamodel.Book;
import com.example.demomvvm.viewmodel.BookViewModel;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private BookAdapter bookAdapter;
    private BookViewModel bookViewModel;
    private int index = 0;
    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        binding.btnAdd.setOnClickListener(v -> addBook());
        bookViewModel = new ViewModelProvider(this).get(BookViewModel.class);
        bookViewModel.getBookListLiveData().observe(this, books -> {
            bookAdapter = new BookAdapter(books, HomeActivity.this);
            binding.rcHome.setAdapter(bookAdapter);
        });

    }

    private void addBook() {
        Book book = new Book("Có chú chim vành khuyên " + index, "Dáng trông thật xinh tươi quá " + index, "Gọi dạ bảo vâng " + index, 50000);
        bookViewModel.addBook(book);
        index++;
    }
}