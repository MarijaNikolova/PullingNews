package com.ranngo.pullinginfo.facebook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Marija on 4/7/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Page {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;

    public Page(){

    }

    public Page(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id+" "+name;
    }
}
