package com.axat.clickcentral.fragment;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.axat.clickcentral.R;
import com.axat.clickcentral.activity.ProductDetail;
import com.axat.clickcentral.adapter.ProductSliderAdapter;
import com.axat.clickcentral.databinding.HelpFragBinding;
import com.axat.clickcentral.databinding.ProductBinding;

import java.util.Timer;
import java.util.TimerTask;

public class ProductFragment extends Fragment implements View.OnClickListener  {
    private ProductBinding binding;
    ProductSliderAdapter sliderAdapter;
    Handler handler;
    Runnable update;
    private TextView[] dots;
    int page_position = 0;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = ProductBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.tvdetail.setOnClickListener(this);
        binding.btnbuy.setOnClickListener(this);
        binding.btnaddcart.setOnClickListener(this);
       // binding.tvprice.setText("This is strike-thru");
        binding.tvprice.setPaintFlags(binding.tvprice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        setSlider();

    }

    public void setSlider(){
        sliderAdapter = new ProductSliderAdapter( getActivity());
        binding.tutSlider.setAdapter(sliderAdapter);
//        binding.tutSlider.setPadding(40, 0, 40, 0);
//        binding.tutSlider.setClipToPadding(false);
//        binding.tutSlider.setPageMargin(30);

        binding.tutSlider.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // page_position=position;
                addBottomDots(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // method for adding indicators
        addBottomDots(0);

        handler = new Handler();

        update = new Runnable() {
            public void run() {
                if (page_position == 4) {
                    page_position = 0;
                } else {
                    page_position = page_position + 1;
                }
                // Log.d("called","calleedd-------"+page_position);
                binding.tutSlider.setCurrentItem(page_position, true);

            }
        };



        //  handler.post(update);


        Timer timer = new Timer(); // This will create a new Thread
        timer.scheduleAtFixedRate(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                // Log.d("called","calleedd-------");
                //handler.post(update);
            }
        }, 500, 2000);
    }

    @Override
    public void onClick(View view) {
        if(view == binding.tvdetail){
            startActivity(new Intent(getActivity(), ProductDetail.class));
        }
    }

    private void addBottomDots(int currentPage) {
        dots = new TextView[4];

        binding.dots.removeAllViews();
        if(getActivity()!=null){
            for (int i = 0; i < dots.length; i++) {

                dots[i] = new TextView(getActivity());
                dots[i].setText(Html.fromHtml(" &#9675&nbsp;"));
               dots[i].setTextSize(17);

                dots[i].setTextColor(getResources().getColor(R.color.create_new_bg));
                binding.dots.addView(dots[i]);
            }

            if (dots.length > 0)
                dots[currentPage].setTextSize(17);
                dots[currentPage].setText(Html.fromHtml(" &#9679&nbsp;"));
               dots[currentPage].setTextColor(getResources().getColor(R.color.create_new_bg));
            //dots[currentPage].setBackground(getResources().getDrawable(R.drawable.filled_circle_indicator));
        }




    }

    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacks(update);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(update);
    }
}
