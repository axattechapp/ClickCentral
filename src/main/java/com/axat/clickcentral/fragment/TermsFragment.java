package com.axat.clickcentral.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.axat.clickcentral.databinding.SettingsFragmentBinding;
import com.axat.clickcentral.databinding.TermsFragBinding;

public class TermsFragment extends Fragment {
    TermsFragBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = TermsFragBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }
}
