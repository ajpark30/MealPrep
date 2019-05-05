package edu.matc.yummly.recipes;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Flavors{

    @JsonProperty("meaty")
    private double meaty;

    @JsonProperty("salty")
    private double salty;

    @JsonProperty("sweet")
    private double sweet;

    @JsonProperty("sour")
    private double sour;

    @JsonProperty("bitter")
    private double bitter;

    @JsonProperty("piquant")
    private double piquant;

    public void setMeaty(double meaty){
        this.meaty = meaty;
    }

    public double getMeaty(){
        return meaty;
    }

    public void setSalty(double salty){
        this.salty = salty;
    }

    public double getSalty(){
        return salty;
    }

    public void setSweet(double sweet){
        this.sweet = sweet;
    }

    public double getSweet(){
        return sweet;
    }

    public void setSour(double sour){
        this.sour = sour;
    }

    public double getSour(){
        return sour;
    }

    public void setBitter(double bitter){
        this.bitter = bitter;
    }

    public double getBitter(){
        return bitter;
    }

    public void setPiquant(double piquant){
        this.piquant = piquant;
    }

    public double getPiquant(){
        return piquant;
    }

    @Override
    public String toString(){
        return
                "Flavors{" +
                        "meaty = '" + meaty + '\'' +
                        ",salty = '" + salty + '\'' +
                        ",sweet = '" + sweet + '\'' +
                        ",sour = '" + sour + '\'' +
                        ",bitter = '" + bitter + '\'' +
                        ",piquant = '" + piquant + '\'' +
                        "}";
    }
}
