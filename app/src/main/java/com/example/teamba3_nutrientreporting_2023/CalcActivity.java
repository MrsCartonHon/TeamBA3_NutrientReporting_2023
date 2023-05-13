package com.example.teamba3_nutrientreporting_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class CalcActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
public int mode = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_activty);
        Spinner spinner = (Spinner)findViewById(R.id.dummy_fertilizers);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.dummy_fertilizers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


    }
    public void equals(View view){
        System.out.println("Doin M A F F");
        EditText test = (EditText)(findViewById(R.id.amountOfFertilizer));
        double amnt = Double.parseDouble(test.getText().toString());
        TextView output = (TextView)(findViewById(R.id.output));
        TextView output2 = (TextView)(findViewById(R.id.output2));
        TextView output3 = (TextView)(findViewById(R.id.output3));
        switch(mode){
            case 0:
                break;
            case 1:
                output.setText((amnt/.18 + "pounds of nitrogen per acre"));
                output2.setText((amnt/.46 + "pounds of phosphor per acre"));
            case 2:
                output.setText((amnt/.11 + "pounds of nitrogen per acre"));
                output2.setText((amnt/.55 + "pounds of phosphor per acre"));
            case 3:
                output.setText((amnt/.34 + "pounds of nitrogen per acre"));
            case 4:
                output.setText((amnt/.60 + "pounds of potassium per acre"));

        }
//peanus
    }
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        TextView output = (TextView)(findViewById(R.id.output));
        TextView output2 = (TextView)(findViewById(R.id.output2));
        TextView output3 = (TextView)(findViewById(R.id.output3));
        switch(pos){
            case 0:
                output.setAlpha(1);
                output2.setAlpha(1);
                output3.setAlpha(0);
                mode = 1;
                break;
            case 1:
                output.setAlpha(1);
                output2.setAlpha(1);
                output3.setAlpha(0);
                mode = 2;
                break;
            case 2:
                output.setAlpha(1);
                output2.setAlpha(0);
                output3.setAlpha(0);
                mode = 3;
            case 3:
                output.setAlpha(1);
                output2.setAlpha(0);
                output3.setAlpha(0);
                mode = 4;

        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}