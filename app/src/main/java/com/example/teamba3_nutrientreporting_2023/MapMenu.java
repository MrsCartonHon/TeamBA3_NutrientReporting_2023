package com.example.teamba3_nutrientreporting_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MapMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_menu);
    }

    public void goToNew(View view) {
        Intent itent = new Intent(MapMenu.this, NewRegion.class);
        MapMenu.this.startActivity(itent);
    }

    public void goToViewExisting(View view) {
        Intent itent = new Intent(MapMenu.this, MapsActivity.class);
        MapMenu.this.startActivity(itent);
    }
}