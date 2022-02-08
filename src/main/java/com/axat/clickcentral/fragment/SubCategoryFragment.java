package com.axat.clickcentral.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.axat.clickcentral.adapter.BestSellerAdapter;
import com.axat.clickcentral.adapter.CategoryAdapter;
import com.axat.clickcentral.databinding.CategoriesFragmentBinding;
import com.axat.clickcentral.databinding.SubcategoryFragBinding;
import com.axat.clickcentral.util.SpacesItemDecoration;

public class SubCategoryFragment  extends Fragment  {
    private SubcategoryFragBinding binding;
    StaggeredGridLayoutManager gridLayoutManager;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = SubcategoryFragBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        gridLayoutManager.invalidateSpanAssignments();
        gridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);

        binding.recyclerview.addItemDecoration(new SpacesItemDecoration(5));
        binding.recyclerview.setLayoutManager(gridLayoutManager);
        BestSellerAdapter adapter=new BestSellerAdapter(getActivity());

        binding.recyclerview.setAdapter(adapter);

    }
}
