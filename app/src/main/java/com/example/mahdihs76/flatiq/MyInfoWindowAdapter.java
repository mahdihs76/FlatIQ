package com.example.mahdihs76.flatiq;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/**
 * Created by kosar on 9/14/17.
 */

public class MyInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

    Activity activity;
    Button button;

    public MyInfoWindowAdapter(Activity activity) {
        this.activity = activity;

    }

    @Override
    public View getInfoWindow(Marker marker) {
        View v = activity.getLayoutInflater().inflate(R.layout.map_test, null);
        button = (Button) v.findViewById(R.id.map_button);
        Log.i("debug", "getInfoWindow: " + button);
        button.setText(marker.getTitle());

        return v;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }
}
