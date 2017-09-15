package com.example.mahdihs76.flatiq;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.example.mahdihs76.flatiq.view.page.findgroup.GroupFragment;
import com.example.mahdihs76.flatiq.view.page.main.MainActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private ArrayList<Double> longitudes = new ArrayList<>();
    private ArrayList<Double> latitudes = new ArrayList<>();
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> activities = new ArrayList<>();
    private ArrayList<String> ids = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            longitudes = (ArrayList<Double>) getIntent().getExtras().get(MainActivity.LONGITUDES);
            latitudes = (ArrayList<Double>) getIntent().getExtras().get(MainActivity.LATITUDES);
            names = (ArrayList<String>) getIntent().getExtras().get(MainActivity.NAMES);
            activities = (ArrayList<String>) getIntent().getExtras().get(MainActivity.ACTIVITIES);
            ids = (ArrayList<String>) getIntent().getExtras().get(MainActivity.IDS);
        }
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                String id = (String) marker.getTag();
                Intent intent = new Intent(MapsActivity.this,MainActivity.class );
                intent.putExtra("groupId",id);
                startActivity(intent);


            }
        });

        LatLng latLng = new LatLng(0, 0);

        for (int i = 0; i < longitudes.size(); i++) {
            latLng = new LatLng(longitudes.get(i), latitudes.get(i));
            mMap.addMarker(new MarkerOptions()
                    .position(latLng)
                    .snippet(activities.get(i))
                    .title(names.get(i)))
                    .setTag(ids.get(i));
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10.0f));
    }
}
