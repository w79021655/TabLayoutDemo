package com.sample.tablayoutdemo.ui;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sample.tablayoutdemo.data.DateModel;
import com.sample.tablayoutdemo.data.DateRepository;

import java.util.ArrayList;

public class DateViewModel extends ViewModel {
    private final DateRepository repository;
    private final MutableLiveData<ArrayList<DateModel>> dateList = new MutableLiveData<>();

    public DateViewModel(DateRepository repository) {
        this.repository = repository;
    }

    public void fetchDateList(Context context) {
        ArrayList<DateModel> list = repository.getDateList(context);
        dateList.postValue(list);
    }

    public LiveData<ArrayList<DateModel>> getDateList() {
        return dateList;
    }
}