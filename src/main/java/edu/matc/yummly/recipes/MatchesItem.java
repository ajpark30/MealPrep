package edu.matc.yummly.recipes;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class MatchesItem{

    @JsonProperty("recipeName")
    private String recipeName;

    @JsonProperty("flavors")
    private Flavors flavors;

    @JsonProperty("sourceDisplayName")
    private String sourceDisplayName;

    @JsonProperty("smallImageUrls")
    private List<String> smallImageUrls;

    @JsonProperty("totalTimeInSeconds")
    private int totalTimeInSeconds;

    @JsonProperty("rating")
    private int rating;

    @JsonProperty("imageUrlsBySize")
    private ImageUrlsBySize imageUrlsBySize;

    @JsonProperty("ingredients")
    private List<String> ingredients;

    @JsonProperty("attributes")
    private Attributes attributes;

    @JsonProperty("id")
    private String id;

    public void setRecipeName(String recipeName){
        this.recipeName = recipeName;
    }

    public String getRecipeName(){
        return recipeName;
    }

    public void setFlavors(Flavors flavors){
        this.flavors = flavors;
    }

    public Flavors getFlavors(){
        return flavors;
    }

    public void setSourceDisplayName(String sourceDisplayName){
        this.sourceDisplayName = sourceDisplayName;
    }

    public String getSourceDisplayName(){
        return sourceDisplayName;
    }

    public void setSmallImageUrls(List<String> smallImageUrls){
        this.smallImageUrls = smallImageUrls;
    }

    public List<String> getSmallImageUrls(){
        return smallImageUrls;
    }

    public void setTotalTimeInSeconds(int totalTimeInSeconds){
        this.totalTimeInSeconds = totalTimeInSeconds;
    }

    public int getTotalTimeInSeconds(){
        return totalTimeInSeconds;
    }

    public void setRating(int rating){
        this.rating = rating;
    }

    public int getRating(){
        return rating;
    }

    public void setImageUrlsBySize(ImageUrlsBySize imageUrlsBySize){
        this.imageUrlsBySize = imageUrlsBySize;
    }

    public ImageUrlsBySize getImageUrlsBySize(){
        return imageUrlsBySize;
    }

    public void setIngredients(List<String> ingredients){
        this.ingredients = ingredients;
    }

    public List<String> getIngredients(){
        return ingredients;
    }

    public void setAttributes(Attributes attributes){
        this.attributes = attributes;
    }

    public Attributes getAttributes(){
        return attributes;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    @Override
    public String toString(){
        return
                "MatchesItem{" +
                        "recipeName = '" + recipeName + '\'' +
                        ",flavors = '" + flavors + '\'' +
                        ",sourceDisplayName = '" + sourceDisplayName + '\'' +
                        ",smallImageUrls = '" + smallImageUrls + '\'' +
                        ",totalTimeInSeconds = '" + totalTimeInSeconds + '\'' +
                        ",rating = '" + rating + '\'' +
                        ",imageUrlsBySize = '" + imageUrlsBySize + '\'' +
                        ",ingredients = '" + ingredients + '\'' +
                        ",attributes = '" + attributes + '\'' +
                        ",id = '" + id + '\'' +
                        "}";
    }
}
