package com.example.myandriodikpmdapplication.interfaces;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

public interface Http {

    public ByteArrayOutputStream download(URL url) throws IOException;
    // HTTP GET request
    String send(String myUrl, String requestType) throws Exception;

    String send(String myUrl, String jsonInputString, String requestType) throws Exception;
}
