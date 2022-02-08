package com.axat.clickcentral.fragment;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.axat.clickcentral.R;
import com.axat.clickcentral.adapter.OrderAdapter;
import com.axat.clickcentral.databinding.CartFragmentBinding;
import com.axat.clickcentral.databinding.CheckoutFragmentBinding;

public class CheckOutFragment extends Fragment implements View.OnClickListener {
    private CheckoutFragmentBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = CheckoutFragmentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.sellrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        OrderAdapter adapter=new OrderAdapter(getActivity());
        binding.sellrecyclerview.setAdapter(adapter);
        binding.btncheckout.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        if(view == binding.btncheckout){
            LayoutInflater inflater2 = (LayoutInflater)getActivity().getSystemService(LAYOUT_INFLATER_SERVICE);
            View view3 = inflater2.inflate(R.layout.checkout_popup, null);
           // ImageView imgclose=view3.findViewById(R.id.imgclose);

            android.app.AlertDialog.Builder builder2 = new android.app.AlertDialog.Builder( getActivity());
            builder2.setView(view3);
            final android.app.AlertDialog alertDialog3 = builder2.create();


//            imgclose.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    alertDialog3.dismiss();
//                }
//            });

            alertDialog3.show();
            alertDialog3.setCancelable(true);
            alertDialog3.getWindow().setLayout(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
            alertDialog3.getWindow().setGravity(Gravity.CENTER);
        }
    }
}
