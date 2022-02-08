package com.axat.clickcentral.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.axat.clickcentral.R;
import com.axat.clickcentral.databinding.BestSellerRecBinding;
import com.axat.clickcentral.databinding.HotcategoryRecBinding;

public class HotCategoryAdapter extends RecyclerView.Adapter<HotCategoryAdapter.MyViewHolder> {
    private Context mContext;

    public HotCategoryAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public HotCategoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(HotcategoryRecBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));


    }

    @Override
    public void onBindViewHolder(@NonNull HotCategoryAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private HotcategoryRecBinding binding;
        public MyViewHolder(@NonNull HotcategoryRecBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
