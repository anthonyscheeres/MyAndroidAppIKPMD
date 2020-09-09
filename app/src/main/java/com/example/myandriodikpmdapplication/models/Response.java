package com.example.myandriodikpmdapplication.models;

import java.util.ArrayList;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {
    private float numFound;
    private float start;
    ArrayList< Object > docs = new ArrayList < Object > ();

    public Response() {
    }


    // Getter Methods

    public float getNumFound() {
        return numFound;
    }

    public float getStart() {
        return start;
    }

    // Setter Methods

    public void setNumFound(float numFound) {
        this.numFound = numFound;
    }

    public void setStart(float start) {
        this.start = start;
    }
}
