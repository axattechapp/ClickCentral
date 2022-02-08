package com.axat.clickcentral.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.axat.clickcentral.databinding.CategoryRecBinding;
import com.axat.clickcentral.databinding.HelpListRecBinding;

public class HelpAdapter extends RecyclerView.Adapter<HelpAdapter.MyViewHolder>{
    private Context mContext;

    public HelpAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public HelpAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(HelpListRecBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HelpAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private HelpListRecBinding binding;
        public MyViewHolder(@NonNull HelpListRecBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
