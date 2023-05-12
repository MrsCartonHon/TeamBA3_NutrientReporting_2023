package com.example.teamba3_nutrientreporting_2023;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class Region {
    //mandatory
    public float area;

    //Optional
    public String address;
    public ArrayList<LatLng> points;
    public LatLng location;

    //Easy way to get hex codes maybe?
    public int color = 0xFF0000;

    public Region(String address, int area, LatLng latLng){
        this.address = address;
        this.area = area;
        this.location = latLng;
    }

    public Region(String address, int area) {
        this.address = address;
        this.area = area;
    }
}
