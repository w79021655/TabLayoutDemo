package com.sample.tablayoutdemo.data;

import android.content.Context;

import java.util.ArrayList;

public class DateRepository {
    private static DateRepository instance;

    public static DateRepository getInstance() {
        if (instance == null) {
            instance = new DateRepository();
        }
        return instance;
    }

    public ArrayList<DateModel> getDateList(Context context) {
        return new DateModel().getList(context);
    }
}