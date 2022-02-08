package com.axat.clickcentral.fragment;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.axat.clickcentral.R;
import com.axat.clickcentral.adapter.CategoryAdapter;
import com.axat.clickcentral.databinding.CategoriesFragmentBinding;
import com.axat.clickcentral.databinding.HomeFragmentBinding;
import com.axat.clickcentral.util.SpacesItemDecoration;

public class categories extends Fragment {
    private CategoriesFragmentBinding binding;
    private CategoriesViewModel mViewModel;
    StaggeredGridLayoutManager gridLayoutManager;
    public static categories newInstance() {
        return new categories();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = CategoriesFragmentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        gridLayoutManager.invalidateSpanAssignments();
        gridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);


        binding.categoryrecyclerview.addItemDecoration(new SpacesItemDecoration(5));
        binding.categoryrecyclerview.setLayoutManager(gridLayoutManager);
        CategoryAdapter adapter=new CategoryAdapter(getActivity());
        binding.categoryrecyclerview.setAdapter(adapter);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CategoriesViewModel.class);
        // TODO: Use the ViewModel
    }

}