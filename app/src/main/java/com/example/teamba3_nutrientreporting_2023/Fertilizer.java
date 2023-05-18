package com.example.teamba3_nutrientreporting_2023;

public class Fertilizer {

    public Fertilizer(){
        cropName = null;
        yieldTarget = null;
        date = "Please Enter";
    }

    public static String cropName;
    public static String yieldTarget;
    public static String date;

    public static int NSoilTest;
    public static int PSoilTest;
    public static int KSoilTest;

    public static String getCropName() {
        return cropName;
    }
    /*public static void setCropName(String cropName) {
        Fertilizer.cropName = cropName;
    }*/


    public static String getYieldTarget() {
        return yieldTarget;
    }
    /*public static void setYieldTarget(String yieldTarget) {
        Fertilizer.yieldTarget = yieldTarget;
    }*/



}
