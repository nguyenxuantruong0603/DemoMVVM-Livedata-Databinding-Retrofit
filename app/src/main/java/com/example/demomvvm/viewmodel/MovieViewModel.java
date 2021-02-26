package com.example.demomvvm.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.demomvvm.datamodel.Movie;
import com.example.demomvvm.retrofit.ApiService;
import com.example.demomvvm.retrofit.RetrofitCallMovie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MovieViewModel extends ViewModel {

    private MutableLiveData<List<Movie>> listMutableLiveData;

    // hàm khởi tạo
    public MovieViewModel() {
        listMutableLiveData = new MutableLiveData<>();

    }

    // khai báo getter của MutableLiveData<List<Movie>> để bên Acitivity gọi và lấy dữ liệu
    public MutableLiveData<List<Movie>> getListMutableLiveData() {
        return listMutableLiveData;
    }

    //lấy dữ liệu từ API và đổ vào list MutableLiveData
    public void makeApiCall() {
        ApiService apiService = RetrofitCallMovie.getInstance().create(ApiService.class);
        Call<List<Movie>> listCall = apiService.getMovieList();
        listCall.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                listMutableLiveData.postValue(response.body());
                Log.e("AAAAAA", response.body().size() + "");
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                listMutableLiveData.postValue(null);
                Log.e("AAAAAA", t.getMessage());

            }
        });
    }
}
