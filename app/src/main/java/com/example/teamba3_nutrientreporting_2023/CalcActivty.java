package com.example.teamba3_nutrientreporting_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class CalcActivty extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_activty);
        Spinner spinner = (Spinner)findViewById(R.id.dummy_fertilizers);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.dummy_fertilizers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


    }
    public void equals(View view){
        System.out.println("Doin M A F F");
        EditText test = (EditText)(findViewById(R.id.amountOfFertilizer));
        double amnt = Double.parseDouble(test.getText().toString())/0.18;
        TextView output = (TextView)(findViewById(R.id.output));
        output.setText(amnt +" pounds per acre");
    }
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}