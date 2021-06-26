package com.sample.tablayoutdemo.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.sample.tablayoutdemo.ui.DateFragment;
import com.sample.tablayoutdemo.ui.PageFragment;

public class SectionsPagerAdapter extends FragmentStateAdapter {
    private static final Fragment[] FRAGMENTS = new Fragment[]{
            DateFragment.newInstance(),
            PageFragment.newInstance()
    };

    public SectionsPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return FRAGMENTS[position];
    }

    @Override
    public int getItemCount() {
        return FRAGMENTS.length;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}