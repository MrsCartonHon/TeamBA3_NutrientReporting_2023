package com.example.teamba3_nutrientreporting_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.List;

public class CreateRegionViaMath extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_region_via_math);
    }
    public void createRegion(View view) {
        EditText address = (EditText)(findViewById(R.id.editTextTextPostalAddress));
        EditText area = (EditText)(findViewById(R.id.editTextNumber));
        EditText name = (EditText)(findViewById(R.id.editTextTextPersonName));
        Geocoder geocoder = new Geocoder(this);
        List<Address> addressList;

        try{
            addressList = geocoder.getFromLocationName(address.getText().toString(), 5);
            if (addressList != null) {
                Address location = addressList.get(0);
                location.getLatitude();
                location.getLongitude();
                MainActivity.regions.add(new Region(address.toString(), Integer.parseInt(area.getText().toString()), new LatLng(location.getLatitude(), location.getLongitude()), name.getText().toString()));
            } else{
                MainActivity.regions.add(new Region(address.toString(), Integer.parseInt(area.getText().toString()), name.getText().toString()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Intent itent = new Intent(CreateRegionViaMath.this, MainActivity.class);
        CreateRegionViaMath.this.startActivity(itent);
    }
}