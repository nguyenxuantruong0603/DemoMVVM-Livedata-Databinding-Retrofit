package com.example.demomvvm.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.demomvvm.datamodel.Book;

import java.util.ArrayList;
import java.util.List;

public class BookViewModel extends ViewModel {

    private MutableLiveData<List<Book>> bookListLiveData;
    private List<Book> bookList;

    public BookViewModel() {
        bookListLiveData = new MutableLiveData<>();
        initData();
    }

    private void initData() {
        bookList = new ArrayList<>();
        bookList.add(new Book("Chú Voi Con", "Ở bản đôn", "Chưa có ngà nên", 30000));
        bookListLiveData.setValue(bookList);
    }

    public MutableLiveData<List<Book>> getBookListLiveData() {
        return bookListLiveData;
    }

    public void addBook(Book book) {
        bookList.add(book);
        bookListLiveData.setValue(bookList);
    }
}
