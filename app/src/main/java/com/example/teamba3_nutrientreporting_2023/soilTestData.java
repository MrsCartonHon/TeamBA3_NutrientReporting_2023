package com.example.teamba3_nutrientreporting_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.teamba3_nutrientreporting_2023.R;

public class soilTestData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soil_test_data);

        TextView title = findViewById(R.id.cropandyieldtitle);
        String message = "Setting Soil Test Data for "+Fertilizer.cropName+" to target "+
                Fertilizer.yieldTarget+" bushels per acre.";
        title.setText(message);
    }


}