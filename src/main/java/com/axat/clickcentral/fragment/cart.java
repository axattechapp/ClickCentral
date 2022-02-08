package com.axat.clickcentral.fragment;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.axat.clickcentral.R;
import com.axat.clickcentral.adapter.OrderAdapter;
import com.axat.clickcentral.databinding.CartFragmentBinding;
import com.axat.clickcentral.databinding.OrdersFragmentBinding;

public class cart extends Fragment implements View.OnClickListener {

    private CartFragmentBinding binding;
    private CartViewModel mViewModel;

    public static cart newInstance() {
        return new cart();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = CartFragmentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.sellrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        OrderAdapter adapter=new OrderAdapter(getActivity());
        binding.sellrecyclerview.setAdapter(adapter);
        binding.btnproceed.setOnClickListener(this);
        binding.imginfo.setOnClickListener(this);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CartViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onClick(View view) {
        if(view == binding.btnproceed) {
            CheckOutFragment fragment2=new CheckOutFragment();
            FragmentManager fragmentManager= ((AppCompatActivity)getActivity()).getSupportFragmentManager();
            //getActivity().getFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.nav_host_fragment_content_home,fragment2,"CheckOutFragment");
            //  fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        else if(view == binding.imginfo){
            LayoutInflater inflater2 = (LayoutInflater)getActivity().getSystemService(LAYOUT_INFLATER_SERVICE);
            View view3 = inflater2.inflate(R.layout.afterpay_popup, null);
            ImageView imgclose=view3.findViewById(R.id.imgclose);

            android.app.AlertDialog.Builder builder2 = new android.app.AlertDialog.Builder( getActivity());
            builder2.setView(view3);
            final android.app.AlertDialog alertDialog3 = builder2.create();


            imgclose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog3.dismiss();
                }
            });

            alertDialog3.show();
            alertDialog3.setCancelable(true);
            alertDialog3.getWindow().setGravity(Gravity.CENTER);
        }

    }
}