package com.teambahai.coralandpearls;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity {
//public class MainActivity extends AppCompatActivity implements ProfileFragment.OnFragmentInteractionListener {

    private static final String TAG = "MainActivity";
    private String userID;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment active_fragment;
            switch (item.getItemId()) {
                case R.id.navigation_candidates:
                    //TODO: add navigation to candidate fragment
                    return true;
                case R.id.navigation_connections:
                    //TODO: add navigation to connections fragment
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        userID = getIntent().getStringExtra("USER_ID");


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
