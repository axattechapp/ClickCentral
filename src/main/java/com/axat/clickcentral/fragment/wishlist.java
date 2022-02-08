package com.axat.clickcentral.fragment;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.axat.clickcentral.R;
import com.axat.clickcentral.adapter.OrderAdapter;
import com.axat.clickcentral.databinding.ProfileFragmentBinding;
import com.axat.clickcentral.databinding.WishlistFragmentBinding;

public class wishlist extends Fragment {

    private WishlistViewModel mViewModel;
    private WishlistFragmentBinding binding;

    public static wishlist newInstance() {
        return new wishlist();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = WishlistFragmentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.sellrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        OrderAdapter adapter=new OrderAdapter(getActivity());
        binding.sellrecyclerview.setAdapter(adapter);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(WishlistViewModel.class);
        // TODO: Use the ViewModel
    }

}