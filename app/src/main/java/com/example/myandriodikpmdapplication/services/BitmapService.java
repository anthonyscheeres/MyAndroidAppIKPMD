package com.example.myandriodikpmdapplication.services;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import com.example.myandriodikpmdapplication.interfaces.BitmapI;

public class BitmapService implements BitmapI {

    public Bitmap encode(String base64String){

        String jpg = "data:image/jpg;base64";
        String png ="data:image/png;base64";
        String emptyString ="";

        byte[] byteArrayOfAnImage = Base64.decode(base64String.replace(png,emptyString).replace(jpg,emptyString), Base64.DEFAULT);
        Bitmap decodedImage = BitmapFactory.decodeByteArray(byteArrayOfAnImage, 0, byteArrayOfAnImage.length);

        return decodedImage;



    }
}
