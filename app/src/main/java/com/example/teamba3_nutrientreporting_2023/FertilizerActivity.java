package com.example.teamba3_nutrientreporting_2023;

public class FertilizerActivity {

  /*  private String[][] nutrientList = {{"NRatio", "0.0"},
                                       {"Pratio", "0.0"},
                                       {"Kratio", "0.0"},
                                       {"Sratio", "0.0"},
                                       {"CaRatio", "0.0"},
                                       {"MgRatio", "0.0"},
                                       {"FeRatio", "0.0"},
                                       {"Mnratio", "0.0"},
            {}
    };*/

    private double nitroRatio;
    private double phospRatio;
    private double potasRatio;

    public FertilizerActivity(){
        nitroRatio = 0.0;
        phospRatio = 0.0;
        potasRatio = 0.0;
    }

    public FertilizerActivity(double nitrogen, double phosphorus, double potassium) {
        nitroRatio = nitrogen;
        phospRatio = phosphorus;
        potasRatio = potassium;
    }

    public double getNitroRatio(){
        return nitroRatio;
    }

    public double getPhospRatio(){
        return phospRatio;
    }

    public double getPotasRatio(){
        return potasRatio;
    }

    public void setNitroRatio(double nitrogen){
        nitroRatio = nitrogen;
    }

    public void setPhospRatio(double phosphorus){
        phospRatio = phosphorus;
    }

    public void setPotasRatio(double potassium){
        potasRatio = potassium;
    }


}
