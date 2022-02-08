package com.axat.clickcentral.adapter;

import android.app.Activity;
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
import com.axat.clickcentral.databinding.ArrivalRecBinding;
import com.axat.clickcentral.databinding.CategoryRecBinding;
import com.axat.clickcentral.fragment.SubCategoryFragment;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {
    private Context mContext;

    public CategoryAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public CategoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(CategoryRecBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.MyViewHolder holder, int position) {
        holder.binding.mainlin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SubCategoryFragment fragment2=new SubCategoryFragment();
                FragmentManager fragmentManager= ((AppCompatActivity)mContext).getSupportFragmentManager();
                        //getActivity().getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_content_home,fragment2,"SubCategoryFragment");
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
        private CategoryRecBinding binding;
        public MyViewHolder(@NonNull CategoryRecBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
