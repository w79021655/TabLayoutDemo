package com.sample.tablayoutdemo.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import com.sample.tablayoutdemo.ViewModelFactory;
import com.sample.tablayoutdemo.data.DateModel;
import com.sample.tablayoutdemo.databinding.FragmentDateBinding;
import com.sample.tablayoutdemo.ui.adapter.DateAdapter;

import org.jetbrains.annotations.NotNull;

public class DateFragment extends Fragment {
    private FragmentDateBinding binding;
    private RecyclerView.SmoothScroller smoothScroller;
    private final DateAdapter adapter = new DateAdapter();

    public static DateFragment newInstance() {
        return new DateFragment();
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDateBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setupUi();
        setupViewModel();
    }

    private void setupUi() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false);
        binding.recyclerView.setLayoutManager(layoutManager);
        adapter.setList(new DateModel().getList(requireActivity()));
        binding.recyclerView.setAdapter(adapter);

        binding.top.setOnClickListener(v -> {
            smoothScroller.setTargetPosition(0);
            layoutManager.startSmoothScroll(smoothScroller);
        });

        smoothScroller = new LinearSmoothScroller(requireActivity()) {
            @Override
            protected int getVerticalSnapPreference() {
                return LinearSmoothScroller.SNAP_TO_START;
            }
        };
    }

    private void setupViewModel() {
        DateViewModel viewModel = new ViewModelProvider(this, new ViewModelFactory()).get(DateViewModel.class);
        viewModel.fetchDateList(requireActivity());
        viewModel.getDateList().observe(requireActivity(), dateList -> {
            adapter.setList(dateList);
            adapter.notifyDataSetChanged();
        });
    }
}