package com.example.myandriodikpmdapplication.services;


import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myandriodikpmdapplication.interfaces.Http;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @author Anthony Scheeres
 */
public class HttpService implements Http {

    private final String USER_AGENT = "Mozilla/5.0";

    @Override
    @RequiresApi(api = Build.VERSION_CODES.O)
    public byte[] download(URL url, byte[] buffer) throws IOException {

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try (InputStream inputStream = url.openStream()) {
            int n = 0;

            while (-1 != (n = inputStream.read(buffer))) {
                output.write(buffer, 0, n);
            }
        }

        return output.toByteArray();

    }


    /**
     * This code needs to be used asynchronous
     *
     * @author Anthony Scheeres
     */
    // HTTP GET request
    public String send(String myUrl, String requestType) throws Exception {
        URL obj = new URL(myUrl);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");
        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream())
        );
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();

    }

    /**
     * This code needs to be used asynchronous
     *
     * @author Anthony Scheeres
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public String send(String myUrl, String jsonInputString, String requestType) throws Exception {
        URL url = new URL(myUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod(requestType);
        con.setRequestProperty("Content-Type", "application/json; charset=utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);
        try (OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            return response.toString();
        }
    }
}
