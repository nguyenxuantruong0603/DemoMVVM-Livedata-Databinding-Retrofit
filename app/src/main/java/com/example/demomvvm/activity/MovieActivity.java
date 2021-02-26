package com.example.demomvvm.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.demomvvm.R;
import com.example.demomvvm.adapter.MovieAdapter;
import com.example.demomvvm.databinding.ActivityMovieBinding;
import com.example.demomvvm.datamodel.Movie;
import com.example.demomvvm.viewmodel.MovieViewModel;

import java.util.List;

public class MovieActivity extends AppCompatActivity implements MovieAdapter.ItemClickListener {
    private ActivityMovieBinding binding;
    private MovieAdapter movieAdapter;
    private MovieViewModel movieViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // đăng ký Databinding cho activity_movie
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie);

        //đăng ký MovieViewModel
        movieViewModel = new ViewModelProvider(this).get(MovieViewModel.class);

        // gọi getListMutableLiveData từ bên MovieViewModel để lắng nghe khi có dữ liệu thay đổi
        movieViewModel.getListMutableLiveData().observe(this, movies -> {
            if (movies != null) {
                movieAdapter = new MovieAdapter(movies, this, this);
                binding.rcMovie.setAdapter(movieAdapter);
                binding.tvCheck.setText("có dữ liệu");
            } else {
                binding.tvCheck.setText("méo có dữ liệu");

            }
        });

        movieViewModel.makeApiCall();
    }

    @Override
    public void clickItem(Movie movie) {
        Toast.makeText(this, "Bạn đã cờ lích vào thằng " + movie.getTitle(), Toast.LENGTH_SHORT).show();
    }
}