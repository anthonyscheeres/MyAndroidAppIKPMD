package com.example.myandriodikpmdapplication.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ArchiveSearch {
    ResponseHeader ResponseHeaderObject;
    Response ResponseObject;

    public ArchiveSearch() {
    }
// Getter Methods

    public ResponseHeader getResponseHeader() {
        return ResponseHeaderObject;
    }

    public void setResponseHeader(ResponseHeader responseHeaderObject) {
        this.ResponseHeaderObject = responseHeaderObject;
    }

    // Setter Methods

    public Response getResponse() {
        return ResponseObject;
    }

    public void setResponse(Response responseObject) {
        this.ResponseObject = responseObject;
    }
}
