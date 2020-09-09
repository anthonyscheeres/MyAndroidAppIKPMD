package com.example.myandriodikpmdapplication.interfaces;

public interface Http {
    // HTTP GET request
    String send(String myUrl, String requestType) throws Exception;

    String send(String myUrl, String jsonInputString, String requestType) throws Exception;
}
