package com.example.myandriodikpmdapplication.services;

import com.example.myandriodikpmdapplication.interfaces.Http;
import com.example.myandriodikpmdapplication.interfaces.Identicon;
import com.example.myandriodikpmdapplication.models.Protocol;

import java.io.IOException;

public class KweloIdenticon implements Identicon {

    public String get(Http http, String uniqueIdentidentifier) throws Exception {

        String url = "https://api.kwelo.com/v1/media/identicon/"+uniqueIdentidentifier+"?format=base64";

        return http.get(url);
    }
}
