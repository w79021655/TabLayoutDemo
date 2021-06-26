package com.sample.tablayoutdemo.data;

import android.content.Context;

import com.sample.tablayoutdemo.R;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateModel {
    private String items;
    private String date;
    private String week;

    public DateModel() {
    }

    public DateModel(String items, String date, String week) {
        this.items = items;
        this.date = date;
        this.week = week;
    }

    public String getItems() {
        return items;
    }

    public String getDate() {
        return date;
    }

    public String getWeek() {
        return week;
    }

    public ArrayList<DateModel> getList(Context context) {
        ArrayList<DateModel> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DATE, i);
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
            LocalDate localDate = LocalDate.of(year, month, dayOfMonth);

            int items = i + 1;
            String itemsStr = context.getString(R.string.items) + items;

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd");
            String date = localDate.format(formatter);

            String dayOfWeek = localDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.US);
            String week = String.format(context.getString(R.string.week), dayOfWeek);
            list.add(new DateModel(itemsStr, date, week));
        }

        return list;
    }
}