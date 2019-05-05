package edu.matc.yummly.recipes;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class ImageUrlsBySize{

    @JsonProperty("90")
    private String jsonMember90;

    public void setJsonMember90(String jsonMember90){
        this.jsonMember90 = jsonMember90;
    }

    public String getJsonMember90(){
        return jsonMember90;
    }

    @Override
    public String toString(){
        return
                "ImageUrlsBySize{" +
                        "90 = '" + jsonMember90 + '\'' +
                        "}";
    }
}
