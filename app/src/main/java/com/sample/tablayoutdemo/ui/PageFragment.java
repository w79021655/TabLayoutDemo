package com.sample.tablayoutdemo.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.sample.tablayoutdemo.R;

public class PageFragment extends Fragment {
    public static PageFragment newInstance() {
        return new PageFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_page, container, false);
    }
}