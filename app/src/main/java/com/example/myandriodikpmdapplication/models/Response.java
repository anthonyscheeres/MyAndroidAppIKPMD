package com.example.myandriodikpmdapplication.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {
    ArrayList<Comic> docs = new ArrayList<Comic>();
    private float numFound;
    private float start;

    public Response() {
    }

    public ArrayList<Comic> getDocs() {
        return docs;
    }

    public float getNumFound() {
        return numFound;
    }

    public float getStart() {
        return start;
    }
}
