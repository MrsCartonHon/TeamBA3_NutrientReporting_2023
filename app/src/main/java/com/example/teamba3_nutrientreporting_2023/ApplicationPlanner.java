package com.example.teamba3_nutrientreporting_2023;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ApplicationPlanner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_planner);
    }

    public void goToCrop(View view) {
        Intent itent = new Intent(ApplicationPlanner.this, crop.class);
        ApplicationPlanner.this.startActivity(itent);
    }
}