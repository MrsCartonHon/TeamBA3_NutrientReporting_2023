package com.example.teamba3_nutrientreporting_2023;

import android.content.Context;
import android.widget.LinearLayout;

public class RegionManagementLayout extends LinearLayout {

    public Region region;

    public RegionManagementLayout(Context context, Region region) {
        super(context);
        this.region = region;
    }
}
