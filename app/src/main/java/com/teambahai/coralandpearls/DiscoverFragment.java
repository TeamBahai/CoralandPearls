package com.teambahai.coralandpearls;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class DiscoverFragment extends android.support.v4.app.Fragment {

    private static final String TAG = "DiscoverFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_discover, container, false);
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
