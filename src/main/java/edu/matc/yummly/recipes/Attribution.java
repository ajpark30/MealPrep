package edu.matc.yummly.recipes;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Attribution{

    @JsonProperty("logo")
    private String logo;

    @JsonProperty("html")
    private String html;

    @JsonProperty("text")
    private String text;

    @JsonProperty("url")
    private String url;

    public void setLogo(String logo){
        this.logo = logo;
    }

    public String getLogo(){
        return logo;
    }

    public void setHtml(String html){
        this.html = html;
    }

    public String getHtml(){
        return html;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public String getUrl(){
        return url;
    }

    @Override
    public String toString(){
        return
                "Attribution{" +
                        "logo = '" + logo + '\'' +
                        ",html = '" + html + '\'' +
                        ",text = '" + text + '\'' +
                        ",url = '" + url + '\'' +
                        "}";
    }
}