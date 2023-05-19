package com.example.teamba3_nutrientreporting_2023;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class RegionManageActivity extends AppCompatActivity implements  RenameDialog.RenameDialogListener, AreaDialog.AreaDialogListener{

    public static Region selectedLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_region_manage);
        LinearLayout layout = findViewById(R.id.management_linear);
        for(int i = 0; i < MainActivity.regions.size(); i++) {
            RegionManagementLayout listings = new RegionManagementLayout(this, MainActivity.regions.get(i));
            listings.setOrientation(LinearLayout.VERTICAL);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setStroke(4, getResources().getColor(R.color.green));
            listings.setBackground(gradientDrawable);
            TextView name = new TextView(this);
            name.setText("Name: " + listings.region.name);
            name.setTextSize(24f);
            TextView area = new TextView(this);
            DecimalFormat defFormatter = new DecimalFormat("0.00");
            area.setText("Area: " + defFormatter.format(listings.region.area));
            area.setTextSize(24f);
            listings.addView(name);
            listings.addView(area);
            listings.setClickable(true);
            listings.setOnClickListener(view -> {
                selectedLayout = ((RegionManagementLayout)view).region;
            });
            layout.addView(listings);
        }
    }

    public void onDelete(View view){
        if(selectedLayout != null) {
            MainActivity.regions.remove(selectedLayout);
            recreate();
        }
    }

    public void onRename(View view){
        if(selectedLayout != null) {
            RenameDialog diag = new RenameDialog();
            diag.show(getSupportFragmentManager(), "rename");
        }
    }
    public void onSetArea(View view){
        if(selectedLayout != null) {
            AreaDialog diag = new AreaDialog();
            diag.show(getSupportFragmentManager(), "Area");
        }
    }

    @Override
    public void onDialogPositiveClickRename(DialogFragment dialog) {
        recreate();
    }

    @Override
    public void onDialogPositiveClickArea(DialogFragment dialog) {
        recreate();
    }
}