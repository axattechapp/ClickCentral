package com.axat.clickcentral.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.axat.clickcentral.R;
import com.axat.clickcentral.databinding.HelpFragBinding;
import com.axat.clickcentral.databinding.SupportFragBinding;

public class HelpFragment extends Fragment implements View.OnClickListener {
    private HelpFragBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = HelpFragBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnhelp.setOnClickListener(this);
        binding.btnfaq.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        if(view == binding.btnhelp){
            HelpListFragment fragment2=new HelpListFragment();
            FragmentManager fragmentManager= ((AppCompatActivity)getActivity()).getSupportFragmentManager();
            //getActivity().getFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.nav_host_fragment_content_home,fragment2,"HelpListFragment");
            //  fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        else if(view == binding.btnfaq) {
            FaqFragment fragment2=new FaqFragment();
            FragmentManager fragmentManager= ((AppCompatActivity)getActivity()).getSupportFragmentManager();

            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.nav_host_fragment_content_home,fragment2,"FaqFragment");

            fragmentTransaction.commit();
        }
    }
}
