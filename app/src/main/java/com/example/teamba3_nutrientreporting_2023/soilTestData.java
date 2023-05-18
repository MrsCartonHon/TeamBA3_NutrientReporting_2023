package com.example.teamba3_nutrientreporting_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class soilTestData extends AppCompatActivity {

    private EditText n;

    private TextView selectedRatio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soil_test_data);

        TextView title = findViewById(R.id.cropandyieldtitle);
        String message = "Setting Soil Test Data for "+Fertilizer.cropName+" to target "+
                Fertilizer.yieldTarget+" bushels per acre.";
        title.setText(message);
    }


    public void Continue(View view) {
        n = (EditText)findViewById(R.id.nSoilTestInput);
        //selectedRatio.setText(n.getText().toString());
        //Fertilizer.NSoilTest = Integer.parseInt(n.getText().toString());

    }
}