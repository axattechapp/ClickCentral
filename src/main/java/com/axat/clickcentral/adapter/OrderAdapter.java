package com.axat.clickcentral.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.axat.clickcentral.databinding.CategoryRecBinding;
import com.axat.clickcentral.databinding.OrderRecBinding;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder>{
    private Context mContext;

    public OrderAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public OrderAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(OrderRecBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private OrderRecBinding binding;
        public MyViewHolder(@NonNull OrderRecBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
