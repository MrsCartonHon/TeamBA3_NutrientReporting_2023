package com.example.teamba3_nutrientreporting_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NewRegion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_region);
    }

    public void createFromMap(View view) {
        Intent itent = new Intent(NewRegion.this, CreateRegionViaMap.class);
        NewRegion.this.startActivity(itent);
    }

    public void createFromMath(View view) {
        Intent itent = new Intent(NewRegion.this, CreateRegionViaMath.class);
        NewRegion.this.startActivity(itent);
    }
}