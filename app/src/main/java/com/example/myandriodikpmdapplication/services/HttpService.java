package com.example.myandriodikpmdapplication.services;


import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myandriodikpmdapplication.interfaces.Http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Anthony Scheeres
 *
 *
 */
public class HttpService implements Http {

    private final String USER_AGENT = "Mozilla/5.0";





    /**
     * This code needs to be used asynchronous
     * @author Anthony Scheeres
     *
     *
     */
    // HTTP GET request
    public String get(String url ) throws Exception {


        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());
        return response.toString();

    }

    /**
     *This code needs to be used asynchronous
     * @author Anthony Scheeres
     *
     *
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public String send(String myUrl, String jsonInputString, String requestType) throws IOException, IOException {
        URL url = new URL (myUrl);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod(requestType);

        con.setRequestProperty("Content-Type", "application/json; charset=utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);
        try(OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("UTF-8");
            os.write(input, 0, input.length);
        }
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            return response.toString();
        }
    }
}
