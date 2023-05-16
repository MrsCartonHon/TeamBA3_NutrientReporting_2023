package com.example.teamba3_nutrientreporting_2023;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Region implements Serializable {
    //mandatory
    public double area = 0;
    public String name;

    //Optional
    public String address;
    public List<LatLng> points;
    public LatLng location;

    public Region(String address, int area, LatLng latLng, String name){
        this.address = address;
        this.area = area;
        this.location = latLng;
        this.name = name;
    }

    public Region(String address, int area, String name) {
        this.address = address;
        this.area = area;
        this.name = name;
    }

    public Region(String toString, List<LatLng> points, double area) {
        this.name = toString;
        this.points = points;
        this.area = area;
    }
}
