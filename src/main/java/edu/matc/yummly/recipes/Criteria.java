package edu.matc.yummly.recipes;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Criteria{

    @JsonProperty("facetCounts")
    private FacetCounts facetCounts;

    @JsonProperty("criteria")
    private Criteria criteria;

    @JsonProperty("attribution")
    private Attribution attribution;

    @JsonProperty("matches")
    private List<MatchesItem> matches;

    @JsonProperty("totalMatchCount")
    private int totalMatchCount;

    @JsonProperty("q")
    private Object Q;

    @JsonProperty("allowedIngredient")
    private Object allowedIngredient;

    @JsonProperty("excludedIngredient")
    private Object excludedIngredient;

    public void setFacetCounts(FacetCounts facetCounts){
        this.facetCounts = facetCounts;
    }

    public FacetCounts getFacetCounts(){
        return facetCounts;
    }

    public void setCriteria(Criteria criteria){
        this.criteria = criteria;
    }

    public Criteria getCriteria(){
        return criteria;
    }

    public void setAttribution(Attribution attribution){
        this.attribution = attribution;
    }

    public Attribution getAttribution(){
        return attribution;
    }

    public void setMatches(List<MatchesItem> matches){
        this.matches = matches;
    }

    public List<MatchesItem> getMatches(){
        return matches;
    }

    public void setTotalMatchCount(int totalMatchCount){
        this.totalMatchCount = totalMatchCount;
    }

    public int getTotalMatchCount(){
        return totalMatchCount;
    }

    public void setQ(Object Q){
        this.Q = Q;
    }

    public Object getQ(){
        return Q;
    }

    public void setAllowedIngredient(Object allowedIngredient){
        this.allowedIngredient = allowedIngredient;
    }

    public Object getAllowedIngredient(){
        return allowedIngredient;
    }

    public void setExcludedIngredient(Object excludedIngredient){
        this.excludedIngredient = excludedIngredient;
    }

    public Object getExcludedIngredient(){
        return excludedIngredient;
    }

    @Override
    public String toString(){
        return
                "Criteria{" +
                        "facetCounts = '" + facetCounts + '\'' +
                        ",criteria = '" + criteria + '\'' +
                        ",attribution = '" + attribution + '\'' +
                        ",matches = '" + matches + '\'' +
                        ",totalMatchCount = '" + totalMatchCount + '\'' +
                        ",q = '" + Q + '\'' +
                        ",allowedIngredient = '" + allowedIngredient + '\'' +
                        ",excludedIngredient = '" + excludedIngredient + '\'' +
                        "}";
    }
}
