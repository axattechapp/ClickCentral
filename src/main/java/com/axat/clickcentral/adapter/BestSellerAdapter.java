package com.axat.clickcentral.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.axat.clickcentral.R;
import com.axat.clickcentral.databinding.BestSellerRecBinding;
import com.axat.clickcentral.fragment.HelpListFragment;
import com.axat.clickcentral.fragment.ProductFragment;

public class BestSellerAdapter  extends RecyclerView.Adapter<BestSellerAdapter.MyViewHolder> {
    private Context mContext;

    public BestSellerAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public BestSellerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(BestSellerRecBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull BestSellerAdapter.MyViewHolder holder, int position) {

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


        holder.binding.mainrel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProductFragment fragment2=new ProductFragment();
                FragmentManager fragmentManager= ((AppCompatActivity)mContext).getSupportFragmentManager();
                //getActivity().getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_content_home,fragment2,"ProductFragment");
                //  fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private BestSellerRecBinding binding;
        public MyViewHolder(@NonNull BestSellerRecBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
