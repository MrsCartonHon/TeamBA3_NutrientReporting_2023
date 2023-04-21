package com.example.teamba3_nutrientreporting_2023;

public class FertilizerActivity {

    private double nitroRatio;
    private double phospRatio;
    private double potasRatio;
    private double sulfrRatio;

    //defautl constructor
    public FertilizerActivity(){
        nitroRatio = 0.0;
        phospRatio = 0.0;
        potasRatio = 0.0;
        sulfrRatio = 0.0;
    }

    //loaded constructor
    public FertilizerActivity(double nitrogen, double phosphorus, double potassium, double sulfur) {
        nitroRatio = nitrogen;
        phospRatio = phosphorus;
        potasRatio = potassium;
        sulfrRatio = sulfur;
    }

    // Getters
    public double getNitroRatio(){
        return this.nitroRatio;
    }

    public double getPhospRatio(){
        return this.phospRatio;
    }

    public double getPotasRatio(){
        return this.potasRatio;
    }

    public double getSulfrRatio() {
        return sulfrRatio;
    }

    //setters
    public void setNitroRatio(double nitrogen){
        this.nitroRatio = nitrogen;
    }

    public void setPhospRatio(double phosphorus){
        this.phospRatio = phosphorus;
    }

    public void setPotasRatio(double potasRatio) {
        this.potasRatio = potasRatio;
    }

    public void setSulfrRatio(double sulfrRatio) {
        this.sulfrRatio = sulfrRatio;
    }




}
