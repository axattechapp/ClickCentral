package com.axat.clickcentral.activity.ui.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.axat.clickcentral.R;
import com.axat.clickcentral.activity.HomeActivity;
import com.axat.clickcentral.databinding.ActivitySplashScreenBinding;

public class SplashScreen extends AppCompatActivity {
    ActivitySplashScreenBinding binding;
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_splash_screen2);
        binding= DataBindingUtil.setContentView(SplashScreen.this,R.layout.activity_splash_screen2);
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreen.this, HomeActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
    }
