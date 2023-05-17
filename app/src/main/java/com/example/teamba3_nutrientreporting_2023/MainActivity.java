package com.example.teamba3_nutrientreporting_2023;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Region> regions = new ArrayList<Region>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToSettings(View view) {
        Intent itent = new Intent(MainActivity.this, SettingsActivity.class);
        MainActivity.this.startActivity(itent);
    }

    public void openInventory(View view) {
        Intent itent = new Intent(this, Inventory.class);
        MainActivity.this.startActivity(itent);
    }

    public void goToMaps(View view) {
        Intent itent = new Intent(MainActivity.this, MapMenu.class);
        MainActivity.this.startActivity(itent);
    }

    public void goToCalc(View view) {
        Intent itent = new Intent(MainActivity.this, ApplicationPlanner.class);
        MainActivity.this.startActivity(itent);
    }

    public void goToHelp(View view) {
        Intent itent = new Intent(MainActivity.this, HelpMenuActivity.class);
        MainActivity.this.startActivity(itent);
    }
}