package com.example.teamba3_nutrientreporting_2023;

public class Fertilizer {

    public Fertilizer(){
        cropName = null;
        yieldTarget = null;
        date = "Please Enter";
    }

    //Only for Display:
    public static String cropName;
    public static String yieldTarget;
    public static String date;

    //Input Values:
    public static double nTarget;
    public static double pTarget;
    public static double kTarget;

    public static double area;

    public static double N;
    public static double P;
    public static double K;

    public static double weight;
    public static double cost;

    //calculated Values:
    public static double bagCount;
    public static double totalCost;

    public static double nApplied;
    public static double pApplied;
    public static double kApplied;

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
