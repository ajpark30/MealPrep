package edu.matc.yummly.recipes;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Attributes{

    @JsonProperty("course")
    private List<String> course;

    @JsonProperty("holiday")
    private List<String> holiday;

    @JsonProperty("cuisine")
    private List<String> cuisine;

    public void setCourse(List<String> course){
        this.course = course;
    }

    public List<String> getCourse(){
        return course;
    }

    public void setHoliday(List<String> holiday){
        this.holiday = holiday;
    }

    public List<String> getHoliday(){
        return holiday;
    }

    public void setCuisine(List<String> cuisine){
        this.cuisine = cuisine;
    }

    public List<String> getCuisine(){
        return cuisine;
    }

    @Override
    public String toString(){
        return
                "Attributes{" +
                        "course = '" + course + '\'' +
                        ",holiday = '" + holiday + '\'' +
                        ",cuisine = '" + cuisine + '\'' +
                        "}";
    }
}