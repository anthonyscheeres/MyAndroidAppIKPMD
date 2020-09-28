package com.example.myandriodikpmdapplication.interfaces;

import java.io.IOException;
import java.net.URL;

public interface Http {

    byte[] download(URL url, byte[] buffer) throws IOException;

    // HTTP GET request
    String send(String myUrl, String requestType) throws Exception;

    String send(String myUrl, String jsonInputString, String requestType) throws Exception;
}
