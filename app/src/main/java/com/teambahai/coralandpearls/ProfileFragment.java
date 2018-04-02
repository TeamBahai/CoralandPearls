package com.teambahai.coralandpearls;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class ProfileFragment extends Fragment {

    private static final String TAG = "ProfileFragment";
    private TextView preferencesButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        preferencesButton = view.findViewById(R.id.profile_preferences_button);
        preferencesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment active_fragment;
                active_fragment = new PreferencesFragment();
                getFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_main, active_fragment).commit();
            }
        });

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "DETACHED");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.i(TAG, "DESTROYED");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "DESTROYED VIEW");
    }


}
