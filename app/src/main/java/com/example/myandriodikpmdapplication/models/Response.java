package com.example.myandriodikpmdapplication.models;

import java.util.ArrayList;

public class Response {
    private float numFound;
    private float start;
    ArrayList< Object > docs = new ArrayList < Object > ();


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
