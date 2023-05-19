package com.example.teamba3_nutrientreporting_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class fertilizerData extends AppCompatActivity {

    private EditText n;
    private EditText p;
    private EditText k;
    private EditText weight;
    private EditText cost;
    private TextView selectedRatio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fertilizer_data);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }


    public void ContinueToPlan(View view) {
        n = (EditText)findViewById(R.id.nGradeInput);
        p = (EditText)findViewById(R.id.pGradeInput);
        k = (EditText)findViewById(R.id.kGradeInput);
        weight = (EditText)findViewById(R.id.weightInputFert);
        cost = (EditText)findViewById(R.id.costInputFert);
        Fertilizer.N = Double.parseDouble(n.getText().toString());
        Fertilizer.P = Double.parseDouble(p.getText().toString());
        Fertilizer.K = Double.parseDouble(k.getText().toString());
        Fertilizer.weight = Double.parseDouble(weight.getText().toString());
        Fertilizer.cost = Double.parseDouble(weight.getText().toString());

        //calculations boutta happen:
        double targetRate;
        double targetGrade;
        String targetType;

        if (Fertilizer.nTarget > Fertilizer.pTarget && Fertilizer.nTarget > Fertilizer.kTarget){
            targetRate = Fertilizer.nTarget;
            targetGrade = Fertilizer.N;
            targetType = "n";
        }
        else if (Fertilizer.pTarget > Fertilizer.nTarget && Fertilizer.pTarget > Fertilizer.kTarget){
            targetRate = Fertilizer.pTarget;
            targetGrade = Fertilizer.P;
            targetType = "p";
        }
        else if (Fertilizer.kTarget > Fertilizer.nTarget && Fertilizer.kTarget > Fertilizer.pTarget){
            targetRate = Fertilizer.kTarget;
            targetGrade = Fertilizer.K;
            targetType = "k";
        }
        else{
            targetRate = Fertilizer.nTarget;
            targetGrade = Fertilizer.N;
            targetType = "n";
        }

        Fertilizer.bagCount = targetRate * (Fertilizer.area/Fertilizer.weight * (targetGrade/100)) ;
        Fertilizer.totalCost = Fertilizer.bagCount * Fertilizer.cost;
        Fertilizer.nApplied = (Fertilizer.weight * (Fertilizer.N/100)) * (Fertilizer.bagCount / Fertilizer.area);
        Fertilizer.pApplied = (Fertilizer.weight * (Fertilizer.P/100)) * (Fertilizer.bagCount / Fertilizer.area);
        Fertilizer.kApplied = (Fertilizer.weight * (Fertilizer.K/100)) * (Fertilizer.bagCount / Fertilizer.area);

        System.out.println(Fertilizer.bagCount);
        System.out.println(Fertilizer.totalCost);
        System.out.println( Fertilizer.nApplied);

    }
}