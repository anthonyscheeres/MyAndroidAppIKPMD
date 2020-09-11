package com.example.myandriodikpmdapplication.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class File {

    String name	;
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
}
