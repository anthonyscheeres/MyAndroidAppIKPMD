package com.example.myandriodikpmdapplication.interfaces;

import java.io.BufferedInputStream;
import java.io.IOException;

public interface Http {

    BufferedInputStream download(String url) throws IOException;

    // HTTP GET request
    String send(String myUrl, String requestType) throws Exception;

    String send(String myUrl, String jsonInputString, String requestType) throws Exception;
}
