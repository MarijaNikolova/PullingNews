package com.ranngo.pullingnews.newyorktimes;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Marija on 4/5/2016.
 */
public class Result {

    @JsonProperty("response")
    private Response response;

    public Result(){

    }
    public Result(Response response){
        this.response=response;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
