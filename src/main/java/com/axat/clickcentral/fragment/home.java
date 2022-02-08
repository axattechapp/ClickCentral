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
import com.axat.clickcentral.adapter.ArrivalAdapter;
import com.axat.clickcentral.adapter.BestSellerAdapter;
import com.axat.clickcentral.adapter.HomeBannerAdapter;
import com.axat.clickcentral.adapter.HotCategoryAdapter;
import com.axat.clickcentral.databinding.HomeFragmentBinding;

public class home extends Fragment implements View.OnClickListener {
    private HomeViewModel mViewModel;
    private HomeFragmentBinding binding;

    public static home newInstance() {
        return new home();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = HomeFragmentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding.leftNav.setOnClickListener(this);
        binding.rightNav.setOnClickListener(this);

        binding.sellrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        BestSellerAdapter adapter=new BestSellerAdapter(getActivity());
        binding.sellrecyclerview.setAdapter(adapter);

        binding.cateegoryrecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        HotCategoryAdapter adapter1=new HotCategoryAdapter(getActivity());
        binding.cateegoryrecycler.setAdapter(adapter1);

        binding.arrivalyrecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        ArrivalAdapter adapter3=new ArrivalAdapter(getActivity());
        binding.arrivalyrecycler.setAdapter(adapter3);

        binding.trendingrecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        ArrivalAdapter adapter4=new ArrivalAdapter(getActivity());
        binding.trendingrecycler.setAdapter(adapter4);

        HomeBannerAdapter sliderAdapter = new HomeBannerAdapter( getActivity());
        binding.tutSlider.setAdapter(sliderAdapter);

    }


    @Override
    public void onClick(View view) {
        if(view == binding.leftNav){
            int tab = binding.tutSlider.getCurrentItem();
            if (tab > 0) {
                tab--;
                binding.tutSlider.setCurrentItem(tab);
            } else if (tab == 0) {
                binding.tutSlider.setCurrentItem(tab);
            }
        }
        else if(view == binding.rightNav){
            int tab = binding.tutSlider.getCurrentItem();
            tab++;
            binding.tutSlider.setCurrentItem(tab);

        }
    }
}