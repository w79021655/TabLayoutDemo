package com.sample.tablayoutdemo;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.sample.tablayoutdemo.data.DateRepository;
import com.sample.tablayoutdemo.ui.DateViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(DateViewModel.class)) {
            return (T) new DateViewModel(DateRepository.getInstance());
        }

        return null;
    }
}
