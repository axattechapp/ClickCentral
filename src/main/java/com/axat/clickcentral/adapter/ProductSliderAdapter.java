package com.axat.clickcentral.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager.widget.PagerAdapter;

import com.axat.clickcentral.R;

public class ProductSliderAdapter extends PagerAdapter {
    private LayoutInflater layoutInflater;
    Activity activity;

    public ProductSliderAdapter( Activity activity) {

        this.activity = activity;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.product_slider, container, false);


        container.addView(view);

        return view;
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}
