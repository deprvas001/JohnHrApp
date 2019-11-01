package com.development.johnhrapp.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.development.johnhrapp.R;
import com.development.johnhrapp.databinding.ActivityHomeScreenBinding;
import com.development.johnhrapp.view.fragment.Calendar;
import com.development.johnhrapp.view.fragment.HomeFragment;
import com.development.johnhrapp.view.fragment.Jobs;
import com.development.johnhrapp.view.fragment.MyJobs;
import com.development.johnhrapp.view.fragment.Search;
import com.development.johnhrapp.view.fragment.SearchJob;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class HomeScreen extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener , View.OnClickListener {
public ActivityHomeScreenBinding activityHomeScreenBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_home_screen);
        activityHomeScreenBinding = DataBindingUtil.setContentView(this,R.layout.activity_home_screen);
        setClickListener();
        loadFragment(new HomeFragment());
    }


    private void setClickListener(){
        activityHomeScreenBinding.bottomNavigation.setOnNavigationItemSelectedListener(this);
        activityHomeScreenBinding.menu.setOnClickListener(this);
        activityHomeScreenBinding.back.setOnClickListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment;
        switch (menuItem.getItemId()){
            case R.id.action_home:
                fragment = new HomeFragment();
                loadFragment(fragment);
                return true;

            case R.id.action_search:
                fragment = new Search();
                loadFragment(fragment);
                return true;

            case R.id.action_job:
                fragment = new Jobs();
                loadFragment(fragment);
                return true;

            case R.id.action_calendar:
                fragment = new Calendar();
                loadFragment(fragment);
                return true;
        }
        return false;
    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
       // transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.menu:
                startActivity(new Intent(this,NotificationScreen.class));
                break;

            case R.id.back:
                startActivity(new Intent(this,MyProfile.class));
                break;
        }
    }
}
