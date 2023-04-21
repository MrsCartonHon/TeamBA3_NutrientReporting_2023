package com.example.teamba3_nutrientreporting_2023;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.TextView;

@SuppressLint("AppCompatCustomView")
public class HelpView extends TextView {
    public int resource;
    public HelpView(Context context, int resource) {
        super(context);
        this.resource = resource;
    }
}
