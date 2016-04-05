package com.ranngo.pullingnews.theguardian;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by Marija on 4/5/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

    @JsonProperty("results")
    private ArrayList<WebUrl> urls;

    @JsonProperty("pages")
    private int pages;

    public Response() {

    }

    public Response(int pages, ArrayList<WebUrl> urls) {
        this.pages = pages;
        this.urls = urls;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public ArrayList<WebUrl> getUrls() {
        return urls;
    }

    public void setUrls(ArrayList<WebUrl> urls) {
        this.urls = urls;
    }

}
