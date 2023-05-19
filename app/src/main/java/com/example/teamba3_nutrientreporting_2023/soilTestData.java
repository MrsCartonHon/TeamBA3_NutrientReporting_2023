package com.example.teamba3_nutrientreporting_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class soilTestData extends AppCompatActivity {

    private EditText n;
    private EditText p;
    private EditText k;
    private EditText area;
    private TextView selectedRatio;

    //selectedRatio.setText(" ");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soil_test_data);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        TextView title = findViewById(R.id.cropandyieldtitle);
        selectedRatio = findViewById(R.id.selectedRatio);
        area = findViewById(R.id.areaInput);

        String message = "Nutrient plan for "+Fertilizer.cropName+" to target "+
                Fertilizer.yieldTarget+" bushels per acre.";
        title.setText(message);
    }


    public void Continue(View view) {
        n = (EditText)findViewById(R.id.nSoilTestInput);
        p = (EditText)findViewById(R.id.pSoilTestInput);
        k = (EditText)findViewById(R.id.kSoilTestInput);

        Fertilizer.nTarget = Double.parseDouble(n.getText().toString());
        Fertilizer.pTarget = Double.parseDouble(p.getText().toString());
        Fertilizer.kTarget = Double.parseDouble(k.getText().toString());
        Fertilizer.area = Double.parseDouble(area.getText().toString());
        System.out.println(Fertilizer.nTarget);
        System.out.println(Fertilizer.pTarget);
        System.out.println(Fertilizer.kTarget);

        Intent itent = new Intent(soilTestData.this, fertilizerData.class);
        soilTestData.this.startActivity(itent);
        //selectedRatio.setText(Fertilizer.NSoilTest);

    }
}