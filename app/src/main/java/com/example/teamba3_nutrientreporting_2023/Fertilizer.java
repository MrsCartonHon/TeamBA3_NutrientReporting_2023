package com.example.teamba3_nutrientreporting_2023;

public class Fertilizer {

    public Fertilizer(){
        cropName = null;
        yieldTarget = null;
        date = "Please Enter";
    }

    //Only for Display:
    public static String cropName = "_";
    public static String yieldTarget = "_";
    public static String date = "_";

    //Input Values:
    public static double nTarget = 0;
    public static double pTarget = 0;
    public static double kTarget = 0;

    public static double area = 0;

    public static double N = 0;
    public static double P = 0;
    public static double K = 0;

    public static double weight = 0;
    public static double cost = 0;

    //calculated Values:
    public static double bagCount = 0;
    public static double totalCost = 0;

    public static double nApplied = 0;
    public static double pApplied = 0;
    public static double kApplied = 0;

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
