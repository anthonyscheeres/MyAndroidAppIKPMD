package com.example.myandriodikpmdapplication.interfaces;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public interface Http {
    // HTTP GET request
    public String send(String myUrl , String requestType) throws Exception;
    public String send(String myUrl, String jsonInputString, String requestType) throws Exception ;
}
