package com.example.teamba3_nutrientreporting_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CalcActivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_activty);



    }
    public void equals(View view){
        System.out.println("Doin M A F F");
        EditText test = (EditText)(findViewById(R.id.amountOfFertilizer));
        double amnt = Double.parseDouble(test.getText().toString())/0.18;
        TextView output = (TextView)(findViewById(R.id.output));
        output.setText(amnt +" pounds per acre");
    }
}