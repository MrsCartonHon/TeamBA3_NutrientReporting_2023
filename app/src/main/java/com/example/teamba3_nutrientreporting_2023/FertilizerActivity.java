package com.example.teamba3_nutrientreporting_2023;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FertilizerActivity extends AppCompatActivity {

    TextView crop;
    TextView yield;

    TextView date;
    TextView area;
    TextView rates;

    TextView npk;
    TextView cost;
    TextView bags;
    TextView finalrates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fertilizer);

        crop = (TextView)findViewById(R.id.displayCropType);
        yield = (TextView)findViewById(R.id.displayTargetYield);

        area = (TextView)findViewById(R.id.displayFieldArea);
        date = (TextView)findViewById(R.id.displayApplicationDate);
        rates = (TextView)findViewById(R.id.displayRates);

        npk = (TextView)findViewById(R.id.displayNPK);
        cost = (TextView)findViewById(R.id.displayCost);
        bags = (TextView)findViewById(R.id.displayBags);
        finalrates = (TextView)findViewById(R.id.displayBags3);

        yield.setText(String.valueOf(Fertilizer.yieldTarget));
        crop.setText(Fertilizer.cropName);

        area.setText(String.valueOf(Fertilizer.area));
        date.setText(String.valueOf(Fertilizer.date));
        String msg = "N rate: " + Fertilizer.nTarget + ", P rate: " + Fertilizer.pTarget + ", K rate: "+ Fertilizer.kTarget;
        rates.setText(msg);

        npk.setText("Applied Fertilizer NPK: " + Fertilizer.N + "-" + Fertilizer.P + "_" + Fertilizer.K);
        cost.setText("Fertilizer Cost: " + Fertilizer.cost + "$");
        bags.setText("Units of Fertilizers Used: " + Fertilizer.bagCount);
        String msg2 = "N rate: " + Fertilizer.nApplied + ", P rate: " + Fertilizer.pApplied + ", K rate: "+ Fertilizer.kApplied;
        finalrates.setText(msg2);


    }
}
