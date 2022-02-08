package com.axat.clickcentral.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.axat.clickcentral.adapter.HelpAdapter;

import com.axat.clickcentral.databinding.HelpListFragBinding;

public class HelpListFragment extends Fragment {
    private HelpListFragBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = HelpListFragBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.helprecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        HelpAdapter adapter=new HelpAdapter(getActivity());
        binding.helprecyclerview.setAdapter(adapter);


    }
}
