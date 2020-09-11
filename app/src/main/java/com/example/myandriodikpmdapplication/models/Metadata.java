package com.example.myandriodikpmdapplication.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Metadata {
    ArrayList<Object> collection = new ArrayList<Object>();
    private String identifier;
    private String description;
    private String language;
    private String mediatype;
    private String title;
    private String publicdate;
    private String uploader;
    private String addeddate;


    public Metadata() {
    }


    public ArrayList<Object> getCollection() {
        return collection;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getDescription() {
        return description;
    }

    public String getMediatype() {
        return mediatype;
    }

    public String getTitle() {
        return title;
    }

    public String getUploader() {
        return uploader;
    }
}
