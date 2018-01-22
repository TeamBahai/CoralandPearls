package com.teambahai.coralandpearls;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.app.Fragment;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        userID = getIntent().getStringExtra("USER_ID");

        android.support.v4.app.Fragment initial_fragment = new DiscoverFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container_main, initial_fragment).commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            android.support.v4.app.Fragment active_fragment;
            switch (item.getItemId()) {
                case R.id.navigation_discover:
                    active_fragment = new DiscoverFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container_main, active_fragment).commit();
                    return true;

                case R.id.navigation_connections:
                    active_fragment = new ConnectionsFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container_main, active_fragment).commit();
                    return true;

                case R.id.navigation_profile:
                    active_fragment = new ProfileFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container_main, active_fragment).commit();
                    return true;
            }
            return false;
        }
    };

}
