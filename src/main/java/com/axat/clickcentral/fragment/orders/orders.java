package com.axat.clickcentral.fragment.orders;

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
import com.axat.clickcentral.adapter.BestSellerAdapter;
import com.axat.clickcentral.adapter.OrderAdapter;
import com.axat.clickcentral.databinding.HomeFragmentBinding;
import com.axat.clickcentral.databinding.OrdersFragmentBinding;

public class orders extends Fragment {
     private OrdersFragmentBinding binding;
    private OrdersViewModel mViewModel;

    public static orders newInstance() {
        return new orders();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = OrdersFragmentBinding.inflate(inflater, container, false);
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
        mViewModel = new ViewModelProvider(this).get(OrdersViewModel.class);
        // TODO: Use the ViewModel
    }

}