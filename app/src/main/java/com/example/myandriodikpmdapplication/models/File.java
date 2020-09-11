package com.example.myandriodikpmdapplication.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class File {

    String name;
    String source;
    String size;

    String format;


    public File() {
    }

    public String getName() {
        return name;
    }

    public String getSource() {
        return source;
    }

    public String getSize() {
        return size;
    }

    public String getFormat() {
        return format;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
