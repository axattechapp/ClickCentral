package com.axat.clickcentral.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.axat.clickcentral.R;
import com.axat.clickcentral.databinding.ActivityHomeBinding;
import com.axat.clickcentral.databinding.ActivityProductDetailBinding;

public class ProductDetail extends AppCompatActivity implements View.OnClickListener {
    ActivityProductDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.imgclose.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == binding.imgclose){
            finish();
        }
    }
}