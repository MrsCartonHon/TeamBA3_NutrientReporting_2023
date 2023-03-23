package com.example.teamba3_nutrientreporting_2023;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToSettings(View view) {
        Intent itent = new Intent(MainActivity.this, SettingsActivity.class);
        MainActivity.this.startActivity(itent);
    }

    public void goToMaps(View view) {
        System.out.println("Marker One");
        Intent itent = new Intent(MainActivity.this, MapsActivity.class);
        System.out.println("Marker");
        MainActivity.this.startActivity(itent);
    }

    public void checkSetting(View view){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(view.getContext());
        System.out.println("AEIOU " + preferences.getString("unitsystem", ""));
    }
}