package com.axat.clickcentral.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.axat.clickcentral.R;
import com.axat.clickcentral.databinding.ArrivalRecBinding;
import com.axat.clickcentral.databinding.HotcategoryRecBinding;

public class ArrivalAdapter extends RecyclerView.Adapter<ArrivalAdapter.MyViewHolder> {
    private Context mContext;

    public ArrivalAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ArrivalAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(ArrivalRecBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ArrivalAdapter.MyViewHolder holder, int position) {
        try{
            if(position %2 ==0){
                holder.binding.imgfav.setImageResource(R.drawable.blackouterheart);
            }
            else{
                holder.binding.imgfav.setImageResource(R.drawable.likefilled);
            }
        }
        catch (Exception e){

        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ArrivalRecBinding binding;
        public MyViewHolder(@NonNull ArrivalRecBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
