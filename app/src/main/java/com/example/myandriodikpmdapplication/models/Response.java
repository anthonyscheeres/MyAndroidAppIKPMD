package com.example.myandriodikpmdapplication.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {
    ArrayList<Object> docs = new ArrayList<Object>();
    private float numFound;
    private float start;

    public Response() {
    }


    // Getter Methods

    public float getNumFound() {
        return numFound;
    }

    public void setNumFound(float numFound) {
        this.numFound = numFound;
    }

    // Setter Methods

    public float getStart() {
        return start;
    }

    public void setStart(float start) {
        this.start = start;
    }
}
