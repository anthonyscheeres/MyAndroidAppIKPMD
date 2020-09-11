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


    //Getters
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


    //Setters
    public void setFiles(ArrayList<File> files) {
        this.files = files;
    }

    public void setMetadataObject(Metadata metadataObject) {
        MetadataObject = metadataObject;
    }

    public void setD1(String d1) {
        this.d1 = d1;
    }

    public void setD2(String d2) {
        this.d2 = d2;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public void setServer(String server) {
        this.server = server;
    }
}
