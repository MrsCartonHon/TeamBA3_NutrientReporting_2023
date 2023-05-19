package com.example.teamba3_nutrientreporting_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class crop extends AppCompatActivity {

    private EditText crop;
    private EditText yield;
    private Button pickDateBtn;
    private TextView selectedDateTV;
    private String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop);

        //code relating to date picker~
        // on below line we are initializing our variables.
        pickDateBtn = findViewById(R.id.idBtnPickDate);
        selectedDateTV = findViewById(R.id.idTVSelectedDate);
        selectedDateTV.setText(Fertilizer.date);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        } //Hides Action Bars

        // on below line we are adding click listener for our pick date button
        pickDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line we are getting
                // the instance of our calendar.
                final Calendar c = Calendar.getInstance();

                // on below line we are getting
                // our day, month and year.
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                // on below line we are creating a variable for date picker dialog.
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        // on below line we are passing context.
                        crop.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // on below line we are setting date to our text view.
                                date = "Planned Application Date: " + dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                                selectedDateTV.setText("Planned Application Date: " + dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        },
                        // on below line we are passing year,
                        // month and day for selected date in our date picker.
                        year, month, day);
                // at last we are calling show to
                // display our date picker dialog.
                datePickerDialog.show();
            }
        });
        //code relating to date picker^

    }

    public void goToInputSoilTestData(View view) {

        crop = (EditText)findViewById(R.id.cropField);
        yield = (EditText)findViewById(R.id.yieldField);

        Fertilizer.cropName = crop.getText().toString();
        Fertilizer.yieldTarget = yield.getText().toString();
        Fertilizer.date = date;
        Intent itent = new Intent(crop.this, soilTestData.class);
        crop.this.startActivity(itent);

    }
}