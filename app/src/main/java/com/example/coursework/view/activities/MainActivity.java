package com.example.coursework.view.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.coursework.R;
import com.example.coursework.view.fragments.CurrentWeatherFragment;
import com.example.coursework.view.fragments.ForecastWeatherFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements CurrentWeatherFragment.OnFragmentInteractionListener {

    private ActionBar toolbar;

    public static final String apiKey = "f58e30f345a853399f0b521eba4a4747";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        toolbar = getSupportActionBar();

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navView.setSelectedItemId(R.id.navigation_home); // change to whichever id should be default
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    toolbar.setTitle("Weather Forecast Chisinau");
                    fragment = new ForecastWeatherFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_dashboard:
                    toolbar.setTitle("Current Weather");
                    fragment = new CurrentWeatherFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_notifications:
                    Intent myStationsIntent = new Intent(getApplicationContext(), MyStationsActivity.class);
                    startActivity(myStationsIntent);
//                    fragment = new StationsWeatherFragment();
//                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
