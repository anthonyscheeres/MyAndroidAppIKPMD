package com.example.myandriodikpmdapplication.interfaces;

import java.io.IOException;
import java.net.URL;

public interface File {

    byte[] download(URL url, byte[] buffer) throws IOException;
}
