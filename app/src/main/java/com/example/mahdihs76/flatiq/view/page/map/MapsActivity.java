package com.example.mahdihs76.flatiq.view.page.map;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.mahdihs76.flatiq.R;
import com.example.mahdihs76.flatiq.constant.Constant;
import com.example.mahdihs76.flatiq.view.page.main.MainActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private ArrayList<Double> longitudes = new ArrayList<>();
    private ArrayList<Double> latitudes = new ArrayList<>();
    private ArrayList<String> ids = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/YEKAN.TTF")
                .setFontAttrId(R.attr.fontPath)
                .build());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            longitudes = (ArrayList<Double>) getIntent().getExtras().get(Constant.LONGITUDES);
            latitudes = (ArrayList<Double>) getIntent().getExtras().get(Constant.LATITUDES);
            ids = (ArrayList<String>) getIntent().getExtras().get(Constant.IDS);
        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                String id = marker.getTitle();
                Intent intent = new Intent(MapsActivity.this, MainActivity.class);
                intent.putExtra("groupId", id);
                startActivity(intent);
            }
        });

        LatLng latLng = new LatLng(0, 0);

        for (int i = 0; i < longitudes.size(); i++) {
            latLng = new LatLng(longitudes.get(i), latitudes.get(i));
            mMap.addMarker(new MarkerOptions()
                    .position(latLng)
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_pin))
                    .title(ids.get(i)));
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10.0f));
        mMap.setInfoWindowAdapter(new MyInfoWindowAdapter(this));
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}
