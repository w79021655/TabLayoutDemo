package com.sample.tablayoutdemo.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayoutMediator;
import com.sample.tablayoutdemo.R;
import com.sample.tablayoutdemo.databinding.ActivityMainBinding;
import com.sample.tablayoutdemo.ui.adapter.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupUi();
    }

    private void setupUi() {
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), getLifecycle());
        binding.viewPager.setAdapter(sectionsPagerAdapter);

        String[] title = new String[]{getString(R.string.tab_text_1), getString(R.string.tab_text_2)};
        new TabLayoutMediator(binding.tabs, binding.viewPager, (tab, position) -> tab.setText(title[position])).attach();
    }
}