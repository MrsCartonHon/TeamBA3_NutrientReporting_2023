package com.example.teamba3_nutrientreporting_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class crop extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop);
    }

    public void goToInputSoilTestData(View view) {

        EditText crop = (EditText)findViewById(R.id.cropField);
        EditText yield = (EditText)findViewById(R.id.yieldField);

        Fertilizer.cropName = crop.getText().toString();
        Fertilizer.yieldTarget = yield.getText().toString();

        Intent itent = new Intent(crop.this, soilTestData.class);
        crop.this.startActivity(itent);

    }
}