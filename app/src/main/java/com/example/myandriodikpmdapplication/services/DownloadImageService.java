package com.example.myandriodikpmdapplication.services;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;

public class DownloadImageService extends AsyncTask<String, Void, Bitmap> {
    ImageView bmImage;
    String text;
    TextView textView;


    public DownloadImageService(ImageView bmImage, String text, TextView textView) {
        this.bmImage = bmImage;
        this.text = text;
        this.textView = textView;
    }

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap mIcon11 = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
        } catch (Exception e) {

        }
        return mIcon11;
    }

    protected void onPostExecute(Bitmap result) {

        textView.setText(text);
        bmImage.setImageBitmap(result);

    }

}
