package com.example.teamba3_nutrientreporting_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class soilTestData extends AppCompatActivity {

    private EditText n;
    private EditText p;
    private EditText k;
    private TextView selectedRatio;

    //selectedRatio.setText(" ");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soil_test_data);



        TextView title = findViewById(R.id.cropandyieldtitle);
        selectedRatio = findViewById(R.id.selectedRatio);

        String message = "Setting Soil Test Data for "+Fertilizer.cropName+" to target "+
                Fertilizer.yieldTarget+" bushels per acre.";
        title.setText(message);
    }


    public void Continue(View view) {
        n = (EditText)findViewById(R.id.nSoilTestInput);
        p = (EditText)findViewById(R.id.pSoilTestInput);
        k = (EditText)findViewById(R.id.kSoilTestInput);
        Fertilizer.NSoilTest = Integer.parseInt(n.getText().toString());
        Fertilizer.PSoilTest = Integer.parseInt(p.getText().toString());
        Fertilizer.KSoilTest = Integer.parseInt(k.getText().toString());
        System.out.println(Fertilizer.NSoilTest);
        System.out.println(Fertilizer.PSoilTest);
        System.out.println(Fertilizer.KSoilTest);
        //selectedRatio.setText(Fertilizer.NSoilTest);

    }
}