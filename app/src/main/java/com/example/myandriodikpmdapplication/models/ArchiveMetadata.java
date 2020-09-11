package com.example.myandriodikpmdapplication.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ArchiveMetadata {

    ArrayList<File> files = new ArrayList<File>();
    Metadata MetadataObject;

    private String d1;
    private String d2;
    private String dir;

    private String server;

    public ArchiveMetadata() {
    }

    public ArrayList<File> getFiles() {
        return files;
    }

    public Metadata getMetadataObject() {
        return MetadataObject;
    }

    public String getD1() {
        return d1;
    }

    public String getD2() {
        return d2;
    }

    public String getDir() {
        return dir;
    }

    public String getServer() {
        return server;
    }
}
