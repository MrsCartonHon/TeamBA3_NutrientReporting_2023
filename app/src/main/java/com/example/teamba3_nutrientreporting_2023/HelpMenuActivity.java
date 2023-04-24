package com.example.teamba3_nutrientreporting_2023;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class HelpMenuActivity extends AppCompatActivity {
    ArrayList<Integer> pages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_menu);
        LinearLayout layout = findViewById(R.id.helpLayoutMenu);
        pages.add(R.raw.help_example_md);


        for(int i = 0; i < pages.size(); i++){
            HelpView listings = new HelpView(this, pages.get(i));
            BufferedReader reader = new BufferedReader(new InputStreamReader(getResources().openRawResource(pages.get(i))));
            try {
                listings.setText(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            listings.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view){
                    Intent itent = new Intent(HelpMenuActivity.this, HelpDisplayActivity.class);
                    itent.putExtra("resource", ((HelpView)view).resource);
                    HelpMenuActivity.this.startActivity(itent);
                }
            });
            listings.setClickable(true);
            layout.addView(listings);
        }
    }
}