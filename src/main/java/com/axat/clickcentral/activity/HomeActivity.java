package com.axat.clickcentral.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.view.animation.AnticipateInterpolator;
import android.widget.TextView;
import android.widget.Toast;

import com.axat.clickcentral.R;
import com.axat.clickcentral.activity.ui.home.HomeFragment;
import com.axat.clickcentral.databinding.ActivityHomeBinding;
import com.axat.clickcentral.fragment.CheckOutFragment;
import com.axat.clickcentral.fragment.SubCategoryFragment;
import com.axat.clickcentral.fragment.cart;
import com.axat.clickcentral.fragment.categories;
import com.axat.clickcentral.fragment.home;
import com.axat.clickcentral.fragment.orders.orders;
import com.axat.clickcentral.fragment.profile;
import com.axat.clickcentral.fragment.settings.settings;
import com.axat.clickcentral.fragment.wishlist;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.core.splashscreen.SplashScreen;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;


public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityHomeBinding binding;
    SplashScreen splashScreen;
    FragmentManager fm;
//    final Fragment fragment1 = new home();
//    final Fragment fragment2 = new categories();
//    final Fragment fragment3 = new cart();
//    final Fragment fragment4 = new orders();
//    final Fragment fragment5 = new profile();
   // Fragment active = fragment1;
    FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        splashScreen = SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);


        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Intent intent=getIntent();
        int value=intent.getIntExtra("value",0);
        if (value==1)
        {

            binding.textLogin.setVisibility(View.GONE);


        }else
        {
            binding.textLogin.setVisibility(View.VISIBLE);
            showSplash();
        }

       // setSupportActionBar(binding.appBarHome.toolbar);
        fm = getSupportFragmentManager();
        fragmentTransaction = fm.beginTransaction();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav_view);
        showBadge(this, bottomNavigationView, R.id.cart, "1");


        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);

        binding.textLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.drawerLayout.closeDrawer(GravityCompat.START);
                startActivity(new Intent(HomeActivity.this,LogINActivity.class));
            }
        });

        binding.appBarHome.tvlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.drawerLayout.closeDrawer(GravityCompat.START);
                startActivity(new Intent(HomeActivity.this,LogINActivity.class));
            }
        });


        binding.appBarHome.imgnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    binding.drawerLayout.closeDrawer(GravityCompat.START);
                }
                else{
                    binding.drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });





        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.categories, R.id.cart,R.id.orders,R.id.profile,R.id.wishlist,R.id.settings)
                .setOpenableLayout(drawer)
                .build();

        changeFragment(new home(), home.class.getSimpleName());
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);



    }

    public void showSplash(){
        splashScreen.setOnExitAnimationListener(splashScreenView -> {
            final ObjectAnimator slideUp = ObjectAnimator.ofFloat(
                    splashScreenView,
                    String.valueOf(View.TRANSLATION_Y),
                    0f,
                    -splashScreenView.getIconView().getHeight()
            );
            slideUp.setInterpolator(new AnticipateInterpolator());
            slideUp.setDuration(800L);

            // Call SplashScreenView.remove at the end of your custom animation.
            slideUp.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    splashScreenView.remove();
                }
            });

            // Run your animation.
            slideUp.start();

        });
    }


    public static void showBadge(Context context, BottomNavigationView
            bottomNavigationView, @IdRes int itemId, String value) {
        removeBadge(bottomNavigationView, itemId);
        BottomNavigationItemView itemView = bottomNavigationView.findViewById(itemId);
        View badge = LayoutInflater.from(context).inflate(R.layout.cart_badge, bottomNavigationView, false);

        TextView text = badge.findViewById(R.id.notifybadge);
        text.setText(value);
        itemView.addView(badge);
    }

    public static void removeBadge(BottomNavigationView bottomNavigationView, @IdRes int itemId) {
        BottomNavigationItemView itemView = bottomNavigationView.findViewById(itemId);
        if (itemView.getChildCount() == 3) {
            itemView.removeViewAt(2);
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_home:
                    for (Fragment fragment : getSupportFragmentManager().getFragments()) {

                        if(fragment instanceof home){

                        }
                        else{

                            if(fragment instanceof categories || fragment instanceof  cart || fragment instanceof orders || fragment instanceof profile){

                            }
                            else{
                                getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                            }
                        }

                    }

                    binding.appBarHome.imgsearch.setVisibility(View.VISIBLE);
                    binding.appBarHome.tvlogin.setVisibility(View.GONE);
                    binding.appBarHome.imgprofile.setVisibility(View.GONE);

                    changeFragment(new home(), home.class.getSimpleName());
                    return true;
//                    Fragment subcatfrag = fm.findFragmentByTag("SubCategoryFragment");
//                    if (subcatfrag == null) {
//                        // not exist
//                    } else {
//                        // fragment exist
//
//                        fragmentTransaction.remove(subcatfrag);
//                      // fragmentTransaction.commit();
//                    }
//                    fragmentTransaction.hide(active).show(fragment1).commit();
//                    active = fragment1;
//                    return true;

                case R.id.categories:
                    for (Fragment fragment : getSupportFragmentManager().getFragments()) {

                        if(fragment instanceof categories){

                        }
                        else{

                            if(fragment instanceof home || fragment instanceof  cart || fragment instanceof orders || fragment instanceof profile){

                            }
                            else{
                                getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                            }
                        }

                    }
                    binding.appBarHome.imgsearch.setVisibility(View.VISIBLE);
                    binding.appBarHome.tvlogin.setVisibility(View.GONE);
                    binding.appBarHome.imgprofile.setVisibility(View.GONE);
                    changeFragment(new categories(), categories.class.getSimpleName());
                    return true;
//                    Fragment subcatfrag1 = fm.findFragmentByTag("SubCategoryFragment");
//                    if (subcatfrag1 == null) {
//                        // not exist
//                    } else {
//                        // fragment exist
//
//
//
//                        fragmentTransaction.remove(subcatfrag1);
//                       // fragmentTransaction.commit();
//                    }
//                    fragmentTransaction.hide(active).show(fragment2).commit();
//                    active = fragment2;
//                    return true;

                case R.id.cart:
                    for (Fragment fragment : getSupportFragmentManager().getFragments()) {

                        if(fragment instanceof cart){

                        }
                        else{

                            if(fragment instanceof categories || fragment instanceof  cart || fragment instanceof orders || fragment instanceof profile){

                            }
                            else{
                                getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                            }
                        }

                    }
                    binding.appBarHome.imgsearch.setVisibility(View.GONE);
                    binding.appBarHome.tvlogin.setVisibility(View.VISIBLE);
                    binding.appBarHome.imgprofile.setVisibility(View.GONE);
                    changeFragment(new cart(), cart.class.getSimpleName());
                    return true;
//                    Fragment subcatfrag2 = fm.findFragmentByTag("SubCategoryFragment");
//                    if (subcatfrag2 == null) {
//                        // not exist
//                    } else {
//                        // fragment exist
//
//
//
//                        fragmentTransaction.remove(subcatfrag2);
//                       // fragmentTransaction.commit();
//                    }
//                    fragmentTransaction.hide(active).show(fragment3).commit();
//                    active = fragment3;
//                    return true;

                case R.id.orders:
                    for (Fragment fragment : getSupportFragmentManager().getFragments()) {

                        if(fragment instanceof orders){

                        }
                        else{

                            if(fragment instanceof categories || fragment instanceof  cart || fragment instanceof orders || fragment instanceof profile){

                            }
                            else{
                                getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                            }
                        }

                    }
                    binding.appBarHome.imgsearch.setVisibility(View.VISIBLE);
                    binding.appBarHome.tvlogin.setVisibility(View.GONE);
                    binding.appBarHome.imgprofile.setVisibility(View.GONE);
                    changeFragment(new orders(), orders.class.getSimpleName());
                    return true;
//                    Fragment subcatfrag3 = fm.findFragmentByTag("SubCategoryFragment");
//                    if (subcatfrag3 == null) {
//                        // not exist
//                    } else {
//                        // fragment exist
//
//
//
//                        fragmentTransaction.remove(subcatfrag3);
//                       // fragmentTransaction.commit();
//                    }
//                    fragmentTransaction.hide(active).show(fragment4).commit();
//                    active = fragment4;
//                    return true;

                case R.id.profile:
                    for (Fragment fragment : getSupportFragmentManager().getFragments()) {

                        if(fragment instanceof profile){

                        }
                        else{

                            if(fragment instanceof categories || fragment instanceof  cart || fragment instanceof orders || fragment instanceof profile){

                            }
                            else{
                                getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                            }
                        }

                    }
                    binding.appBarHome.imgsearch.setVisibility(View.GONE);
                    binding.appBarHome.tvlogin.setVisibility(View.GONE);
                    binding.appBarHome.imgprofile.setVisibility(View.VISIBLE);
                    changeFragment(new profile(), profile.class.getSimpleName());
                    return true;
//                    Fragment subcatfrag4 = fm.findFragmentByTag("SubCategoryFragment");
//                    if (subcatfrag4 == null) {
//                        // not exist
//                    } else {
//                        // fragment exist
//
//
//
//                        fragmentTransaction.remove(subcatfrag4);
//                      //  fragmentTransaction.commit();
//                    }
//                    fragmentTransaction.hide(active).show(fragment5).commit();
//                    active = fragment5;
//                    return true;
            }
            return false;
        }
    };

    public void changeFragment(Fragment fragment, String tagFragmentName) {

        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();

        Fragment currentFragment = mFragmentManager.getPrimaryNavigationFragment();
        if (currentFragment != null) {
            fragmentTransaction.hide(currentFragment);
        }

        Fragment fragmentTemp = mFragmentManager.findFragmentByTag(tagFragmentName);
        if (fragmentTemp == null) {
            fragmentTemp = fragment;
            fragmentTransaction.add(R.id.nav_host_fragment_content_home, fragmentTemp, tagFragmentName);
        } else {
            fragmentTransaction.show(fragmentTemp);
        }

        fragmentTransaction.setPrimaryNavigationFragment(fragmentTemp);
        fragmentTransaction.setReorderingAllowed(true);
        fragmentTransaction.commitNowAllowingStateLoss();
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.nav_home: {
                //Toast.makeText(getApplicationContext(),"clicked",Toast.LENGTH_LONG).show();
                for (Fragment fragment : getSupportFragmentManager().getFragments()) {

                    if(fragment instanceof home){

                    }
                    else{

                        if(fragment instanceof categories || fragment instanceof  cart || fragment instanceof orders || fragment instanceof profile){

                        }
                        else{
                            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                        }
                    }

                }
                changeFragment(new home(), home.class.getSimpleName());
                break;
            }
            case R.id.categories: {
                for (Fragment fragment : getSupportFragmentManager().getFragments()) {

                    if(fragment instanceof categories){

                    }
                    else{

                        if(fragment instanceof home || fragment instanceof  cart || fragment instanceof orders || fragment instanceof profile){

                        }
                        else{
                            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                        }
                    }

                }
                changeFragment(new categories(), categories.class.getSimpleName());
                break;
            }
            case R.id.cart: {
                for (Fragment fragment : getSupportFragmentManager().getFragments()) {

                    if(fragment instanceof cart){

                    }
                    else{

                        if(fragment instanceof categories || fragment instanceof  cart || fragment instanceof orders || fragment instanceof profile){

                        }
                        else{
                            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                        }
                    }

                }
                changeFragment(new cart(), cart.class.getSimpleName());
                break;
            }
            case R.id.orders: {
                for (Fragment fragment : getSupportFragmentManager().getFragments()) {

                    if(fragment instanceof orders){

                    }
                    else{

                        if(fragment instanceof categories || fragment instanceof  cart || fragment instanceof orders || fragment instanceof profile){

                        }
                        else{
                            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                        }
                    }

                }
                changeFragment(new orders(), orders.class.getSimpleName());
                break;
            }
            case R.id.profile: {
                for (Fragment fragment : getSupportFragmentManager().getFragments()) {

                    if(fragment instanceof profile){

                    }
                    else{

                        if(fragment instanceof categories || fragment instanceof  cart || fragment instanceof orders || fragment instanceof profile){

                        }
                        else{
                            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                        }
                    }

                }
                changeFragment(new profile(), profile.class.getSimpleName());
                break;
            }
            case R.id.wishlist: {
                wishlist fragment2=new wishlist();
                FragmentManager fragmentManager= getSupportFragmentManager();
                //getActivity().getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_content_home,fragment2,"wishlist");
                //  fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
            case R.id.settings: {
                settings fragment2=new settings();
                FragmentManager fragmentManager= getSupportFragmentManager();
                //getActivity().getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_content_home,fragment2,"settings");
                //  fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            }
          
        }
        //close navigation drawer
        binding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}