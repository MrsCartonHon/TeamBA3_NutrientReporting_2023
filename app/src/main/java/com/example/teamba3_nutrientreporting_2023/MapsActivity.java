package com.example.teamba3_nutrientreporting_2023;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    List<Polygon> polygonList = new ArrayList<Polygon>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     *
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng developer = new LatLng(41.5565035, -90.4969586);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(developer));

        for(int i = 0; i < MainActivity.regions.size(); i++){
            Region tempRegion = MainActivity.regions.get(i);
            if(tempRegion.points != null ){
                PolygonOptions tempOptions = new PolygonOptions();
                for(int ix = 0; ix < tempRegion.points.size(); ix++){
                    tempOptions.add(tempRegion.points.get(ix));
                }
                polygonList.add(googleMap.addPolygon(tempOptions));
            } else if(tempRegion.location != null){
                googleMap.addMarker(new MarkerOptions().position(tempRegion.location).title(tempRegion.name));
            }
        }
    }
}