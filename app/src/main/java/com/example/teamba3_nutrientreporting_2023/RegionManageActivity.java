package com.example.teamba3_nutrientreporting_2023;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RegionManageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_region_manage);
        LinearLayout layout = findViewById(R.id.management_linear);

        for(int i = 0; i < MainActivity.regions.size(); i++) {
            ConstraintLayout listings = new ConstraintLayout(this);
            ConstraintSet constSet = new ConstraintSet();
            constSet.clone(listings);
            TextView area = new TextView(this);
            area.setText(Double.toString(MainActivity.regions.get(i).area));
            area.setId(View.generateViewId());
            TextView name = new TextView(this);
            name.setText(MainActivity.regions.get(i).name);
            name.setId(View.generateViewId());
            constSet.connect(area.getId(), ConstraintSet.LEFT, name.getId(), ConstraintSet.RIGHT);
            listings.addView(area);
            listings.addView(name);
            constSet.applyTo(listings);
            layout.addView(listings);
        }
    }
}