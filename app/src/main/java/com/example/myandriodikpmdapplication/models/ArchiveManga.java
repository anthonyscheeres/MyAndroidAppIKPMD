package com.example.myandriodikpmdapplication.models;

import java.util.ArrayList;

public class ArchiveManga {
        ResponseHeader ResponseHeaderObject;
        Response ResponseObject;

    public ArchiveManga() {
    }

// Getter Methods

        public ResponseHeader getResponseHeader() {
            return ResponseHeaderObject;
        }

        public Response getResponse() {
            return ResponseObject;
        }

        // Setter Methods

        public void setResponseHeader(ResponseHeader responseHeaderObject) {
            this.ResponseHeaderObject = responseHeaderObject;
        }

        public void setResponse(Response responseObject) {
            this.ResponseObject = responseObject;
        }
    }

