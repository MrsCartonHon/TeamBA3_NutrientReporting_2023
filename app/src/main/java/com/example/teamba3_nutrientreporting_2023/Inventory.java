package com.example.teamba3_nutrientreporting_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

//import com.google.firebase.firestore.FirebaseFirestore;

public class Inventory extends AppCompatActivity {

    private String type = "d";
    private TextView selectedtype;

    private EditText n;
    private EditText p;
    private EditText k;
    private EditText amount;
    private EditText area;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_inventory);
        selectedtype = findViewById(R.id.lorlbs);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        } //Hides Action Bars

        RadioGroup typeRadioGroup = (RadioGroup) findViewById(R.id.typeRadioGroup);
        typeRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.dryRadio: {
                        type = "d";
                        System.out.println("d");
                        selectedtype.setText("lbs");
                        break;
                    }
                    case R.id.liquidRadio: {
                        type = "l";
                        System.out.println("l");
                        selectedtype.setText("Gallons");
                        break;
                    }
                }
            }
        });

        //FirebaseFirestore db = FirebaseFirestore.getInstance();
    }

    public void calcApplicationRate(View view) {
        n = (EditText)findViewById(R.id.nGradeInput);
        p = (EditText)findViewById(R.id.pGradeInput);
        k = (EditText)findViewById(R.id.kGradeInput);
        amount = (EditText)findViewById(R.id.amountInputInv);
        area = (EditText)findViewById(R.id.areaInputInv);

        double nint = 0;
        double pint = 0;
        double kint = 0;
        double amountint = 0;
        double areaint = 0;

        nint = Integer.parseInt(n.getText().toString());
        pint = Integer.parseInt(p.getText().toString());
        kint = Integer.parseInt(k.getText().toString());
        amountint = Integer.parseInt(amount.getText().toString());
        areaint = Integer.parseInt(area.getText().toString());

        double finalN = (amountint * (nint/100.0)) / areaint;
        double finalP = (amountint * (pint/100.0)) / areaint;
        double finalK = (amountint * (kint/100.0)) / areaint;

        System.out.println(finalN);


        Intent itent = new Intent(Inventory.this, ApplicationRateResult.class);
        itent.putExtra("Final N", finalN);
        itent.putExtra("Final P", finalP);
        itent.putExtra("Final K", finalK);
        itent.putExtra("Type", type);
        Inventory.this.startActivity(itent);
    }
}