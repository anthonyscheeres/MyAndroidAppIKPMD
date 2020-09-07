package com.example.myandriodikpmdapplication.interfaces;

import java.io.IOException;

public interface Http {

    public String get(String url ) throws Exception;

    public String send(String myUrl, String jsonInputString, String requestType) throws IOException, IOException;
}
