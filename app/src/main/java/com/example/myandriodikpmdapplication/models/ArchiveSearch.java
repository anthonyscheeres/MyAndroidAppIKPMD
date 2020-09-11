package com.example.myandriodikpmdapplication.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ArchiveSearch {
    ResponseHeader ResponseHeader;
    Response Response;

    public ArchiveSearch() {
    }
// Getter Methods

    public com.example.myandriodikpmdapplication.models.ResponseHeader getResponseHeader() {
        return ResponseHeader;
    }

    public com.example.myandriodikpmdapplication.models.Response getResponse() {
        return Response;
    }
}
