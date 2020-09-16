package com.example.myandriodikpmdapplication.services;


import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myandriodikpmdapplication.interfaces.File;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author Anthony Scheeres
 */
public class HttpDownloader implements File {

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

}
