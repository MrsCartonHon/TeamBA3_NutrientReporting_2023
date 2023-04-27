package com.example.teamba3_nutrientreporting_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.LinearLayout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import io.noties.markwon.Markwon;

public class HelpDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_display);

        LinearLayout layout = findViewById(R.id.helpDisplay);
        HelpView page = new HelpView(this, getIntent().getIntExtra("resource", -1));
        Markwon markwon = Markwon.create(page.getContext());
        BufferedReader reader = new BufferedReader(new InputStreamReader(getResources().openRawResource(page.resource)));

        try {
            reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        markwon.setMarkdown(page, reader.lines().collect(Collectors.joining(System.lineSeparator())));
        page.setMovementMethod(new ScrollingMovementMethod());

        layout.addView(page);
    }
}