package com.example.teamba3_nutrientreporting_2023;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.teamba3_nutrientreporting_2023.databinding.ActivityCreateRegionViaMapBinding;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class CreateRegionViaMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Polyline theLineArray;
    private ActivityCreateRegionViaMapBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCreateRegionViaMapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        View view = mapFragment.getView();
        view.setClickable(false);
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
        theLineArray = mMap.addPolyline(new PolylineOptions());
        LatLng developer = new LatLng(41.5565035, -90.4969586);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(developer));
        googleMap.setOnMapClickListener(this::onMapClick);
    }

    public void onMapClick (LatLng point){
        List points = theLineArray.getPoints();
        points.add(point);
        theLineArray.setPoints(points);
    }
    public void reset(View view){
        theLineArray.setPoints(new ArrayList<LatLng>());
    }
    public void createRegion(View view){
        EditText name = (EditText) (findViewById(R.id.editTextTextPersonName2));
        MainActivity.regions.add(new Region(name.getText().toString(), theLineArray.getPoints()));
        Intent itent = new Intent(CreateRegionViaMap.this, MainActivity.class);
        CreateRegionViaMap.this.startActivity(itent);
    }
}