package com.teambahai.coralandpearls;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        userID = getIntent().getStringExtra("USER_ID");

        Fragment initial_fragment = new ConnectionsFragment();
        getFragmentManager().beginTransaction().add(R.id.fragment_container_main, initial_fragment).commit();

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment active_fragment;
            switch (item.getItemId()) {
                case R.id.navigation_discover:
                    active_fragment = new DiscoverFragment();
                    getFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container_main, active_fragment).commit();
                    return true;

                case R.id.navigation_connections:
                    active_fragment = new ConnectionsFragment();
                    getFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container_main, active_fragment).commit();
                    return true;

                case R.id.navigation_profile:
                    active_fragment = new ProfileFragment();
                    getFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container_main, active_fragment).commit();
                    return true;
            }
            return false;
        }
    };

}
