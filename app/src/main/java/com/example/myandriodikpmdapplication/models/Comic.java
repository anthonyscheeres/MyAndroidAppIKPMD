package com.example.myandriodikpmdapplication.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Comic {

    //we need this for the display so the user can choose/search from a title
    private String title;

    private String description;

    //we need this for an image
    private String identifier;

    private ArchiveMetadata metadata;


    public Comic() {
    }


    public ArchiveMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(ArchiveMetadata metadata) {
        this.metadata = metadata;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getIdentifier() {
        return identifier;
    }
}
