package com.example.teamba3_nutrientreporting_2023;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HelpMenuActivity extends AppCompatActivity {
    ArrayList<Integer> pages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_menu);
        LinearLayout layout = findViewById(R.id.helpLayoutMenu);

        this.addHelpPages(pages);

        for(int i = 0; i < pages.size(); i++){
            HelpView listings = new HelpView(this, pages.get(i));
            listings.setTextColor(0xFF3366CC);
            listings.setTextSize(32f);
            BufferedReader reader = new BufferedReader(new InputStreamReader(getResources().openRawResource(pages.get(i))));
            try {
                listings.setText(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            listings.setOnClickListener(view -> {
                Intent itent = new Intent(HelpMenuActivity.this, HelpDisplayActivity.class);
                itent.putExtra("resource", ((HelpView)view).resource);
                HelpMenuActivity.this.startActivity(itent);
            });
            listings.setClickable(true);
            layout.addView(listings);
        }
    }

    private void addHelpPages(ArrayList<Integer> pageList){
        pageList.add(R.raw.help_settings);
        pageList.add(R.raw.help_calculator);
        pageList.add(R.raw.help_inventory);
        pageList.add(R.raw.help_create_regions);
        pageList.add(R.raw.help_help);
    }
}