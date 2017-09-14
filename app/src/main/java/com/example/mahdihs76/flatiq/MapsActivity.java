package com.example.mahdihs76.flatiq;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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


        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        LatLng latlng1 = new LatLng(-30, 150);
        LatLng latlng2 = new LatLng(-35, 148);
        LatLng latlng3 = new LatLng(-30, 140);
        LatLng latlng4 = new LatLng(-32, 145);
        LatLng latlng5 = new LatLng(-31, 152);

//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.addMarker(new MarkerOptions()
                .position(sydney)
                .title("Melbourne")
                .snippet("Population: 4,137,400"));

        mMap.addMarker(new MarkerOptions()
                .position(latlng1)
                .title("latlng1")
                .snippet("1"));

        mMap.addMarker(new MarkerOptions()
                .position(latlng2)
                .title("latlng2")
                .snippet("2"));

        mMap.addMarker(new MarkerOptions()
                .position(latlng3)
                .title("latlng3")
                .snippet("3"));

        mMap.addMarker(new MarkerOptions()
                .position(latlng4)
                .title("latlng4")
                .snippet("4"));

        mMap.addMarker(new MarkerOptions()
                .position(latlng5)
                .title("latlng5")
                .snippet("5"));

        mMap.setInfoWindowAdapter(new MyInfoWindowAdapter(this));
        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Log.i("debug", "onInfoWindowClick: title " + marker.getTitle());
            }
        });
    }
}
