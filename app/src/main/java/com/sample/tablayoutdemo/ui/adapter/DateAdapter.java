package com.sample.tablayoutdemo.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sample.tablayoutdemo.R;
import com.sample.tablayoutdemo.data.DateModel;

import java.util.ArrayList;

public class DateAdapter extends RecyclerView.Adapter<DateAdapter.DateViewHolder> {
    private ArrayList<DateModel> list;

    public void setList(ArrayList<DateModel> list) {
        this.list = list;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @NonNull
    @Override
    public DateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_date, parent, false);
        return new DateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DateViewHolder holder, int position) {
        holder.items.setText(list.get(position).getItems());
        holder.date.setText(list.get(position).getDate());
        holder.week.setText(list.get(position).getWeek());
    }

    public static class DateViewHolder extends RecyclerView.ViewHolder {
        TextView items;
        TextView date;
        TextView week;

        DateViewHolder(View itemView) {
            super(itemView);

            items = itemView.findViewById(R.id.items);
            date = itemView.findViewById(R.id.date);
            week = itemView.findViewById(R.id.week);
        }
    }
}