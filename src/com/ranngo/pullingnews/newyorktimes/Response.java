package com.ranngo.pullingnews.newyorktimes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by Marija on 4/5/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

    @JsonProperty("meta")
    private Meta meta;
    @JsonProperty("docs")
    private ArrayList<WebUrl> docs;

    public Response() {

    }

    public Response(Meta meta, ArrayList<WebUrl> docs) {
        this.meta = meta;
        this.docs = docs;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public ArrayList<WebUrl> getDocs() {
        return docs;
    }

    public void setDocs(ArrayList<WebUrl> docs) {
        this.docs = docs;
    }
}
