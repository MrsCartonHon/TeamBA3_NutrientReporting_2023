package com.example.teamba3_nutrientreporting_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ApplicationRateResult extends AppCompatActivity {

    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_rate_result);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        } //Hides Action Bars

        t = (TextView)findViewById(R.id.resultOfCalc1);

        Intent recieve = getIntent();
        double x = 0;
        double n = recieve.getDoubleExtra("Final N", x);
        double p = recieve.getDoubleExtra("Final P", x);
        double k = recieve.getDoubleExtra("Final K", x);
        String type = recieve.getStringExtra("Type");

        String s = "lbs";
        if (type.equals("l")){
            s = "Gallons";
        }


        String message = n + " " + s + "/acre of Nitrogen was applied " + p + " " + s + "/acre of Phosporous was applied " +
                k + " " + s +"/acre Potash was applied.";
        t.setText(message);

    }
}