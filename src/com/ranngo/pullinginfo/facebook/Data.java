package com.ranngo.pullinginfo.facebook;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by Marija on 4/7/2016.
 */
public class Data {

    @JsonProperty("data")
    private ArrayList<Page> pages;

    public Data() {
    }

    public Data(ArrayList<Page> pages) {
        this.pages = pages;
    }

    public ArrayList<Page> getPages() {
        return pages;
    }

    public void setPages(ArrayList<Page> pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return pages.toString();
    }
}
