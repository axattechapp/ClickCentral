package com.axat.clickcentral.fragment.settings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
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
import com.axat.clickcentral.databinding.CartFragmentBinding;
import com.axat.clickcentral.databinding.SettingsFragmentBinding;
import com.axat.clickcentral.fragment.HelpFragment;
import com.axat.clickcentral.fragment.PrivacyFragment;
import com.axat.clickcentral.fragment.SupportFragment;
import com.axat.clickcentral.fragment.TermsFragment;

public class settings extends Fragment implements View.OnClickListener {

    private SettingsViewModel mViewModel;
    private SettingsFragmentBinding binding;

    public static settings newInstance() {
        return new settings();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = SettingsFragmentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnhelp.setOnClickListener(this);
        binding.btnsupport.setOnClickListener(this);
        binding.tvterms.setOnClickListener(this);
        binding.tvprivacy.setOnClickListener(this);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SettingsViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onClick(View view) {

        if(view == binding.btnhelp){
            HelpFragment fragment2=new HelpFragment();
            FragmentManager fragmentManager= ((AppCompatActivity)getActivity()).getSupportFragmentManager();
            //getActivity().getFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.nav_host_fragment_content_home,fragment2,"HelpFragment");
            //  fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        else if(view == binding.btnsupport){
            SupportFragment fragment2=new SupportFragment();
            FragmentManager fragmentManager= ((AppCompatActivity)getActivity()).getSupportFragmentManager();
            //getActivity().getFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.nav_host_fragment_content_home,fragment2,"SupportFragment");
            //  fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        else if(view == binding.tvterms){
            TermsFragment fragment2=new TermsFragment();
            FragmentManager fragmentManager= ((AppCompatActivity)getActivity()).getSupportFragmentManager();
            //getActivity().getFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.nav_host_fragment_content_home,fragment2,"TermsFragment");
            //  fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        else if(view == binding.tvprivacy){
            PrivacyFragment fragment2=new PrivacyFragment();
            FragmentManager fragmentManager= ((AppCompatActivity)getActivity()).getSupportFragmentManager();
            //getActivity().getFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.nav_host_fragment_content_home,fragment2,"PrivacyFragment");
            //  fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }
}