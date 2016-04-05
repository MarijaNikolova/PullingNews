package com.ranngo.com.pullingnews.newyorktimes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Marija on 4/5/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebUrl {

    @JsonProperty("web_url")
    private String web_url;

    public WebUrl(){

    }
    public WebUrl(String web_url) {

        this.web_url = web_url;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    @Override
    public String toString() {
        return web_url;
    }
}
