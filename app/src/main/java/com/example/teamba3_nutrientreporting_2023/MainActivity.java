package com.example.teamba3_nutrientreporting_2023;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Button inventoryButton = (Button) findViewById(R.id.inventoryButton);
        inventoryButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, Inventory.class));
            }
        });*/
    }

    public void goToSettings(View view) {
        Intent itent = new Intent(MainActivity.this, SettingsActivity.class);
        MainActivity.this.startActivity(itent);
    }

    public void openInventory(View view) {
        Intent itent = new Intent(this, Inventory.class);
        MainActivity.this.startActivity(itent);
    }

    public void goToMaps(View view) {
        Intent itent = new Intent(MainActivity.this, MapsActivity.class);
        MainActivity.this.startActivity(itent);
    }

    public void goToDead(View view) {
        Intent itent = new Intent(MainActivity.this, CalcActivty.class);
        MainActivity.this.startActivity(itent);
    }

    public void checkSetting(View view){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(view.getContext());
        System.out.println("AEIOU " + preferences.getString("unitsystem", ""));
    }

    public void goToHelp(View view) {
        Intent itent = new Intent(MainActivity.this, HelpMenuActivity.class);
        MainActivity.this.startActivity(itent);
    }
}