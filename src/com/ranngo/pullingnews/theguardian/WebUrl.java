package com.ranngo.pullingnews.theguardian;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Marija on 4/5/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebUrl {

    @JsonProperty("webUrl")
    private String webUrl;

    public WebUrl(){

    }
    public  WebUrl(String webUrl){
        this.webUrl=webUrl;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    @Override
    public String toString() {
        return webUrl;
    }
}