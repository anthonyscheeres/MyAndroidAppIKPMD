package com.example.myandriodikpmdapplication.adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;


import com.example.myandriodikpmdapplication.models.Comic;

import java.io.InputStream;

public class DownloadImageForHolder extends AsyncTask<String, Void, Bitmap>{

        private MyComicRecyclerViewAdapter.ViewHolder holder;
        private String text;
        private Comic comic;

    public DownloadImageForHolder(MyComicRecyclerViewAdapter.ViewHolder holder, String text, Comic comic) {
        this.holder = holder;
        this.text = text;
        this.comic = comic;
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


            holder.mItem = comic;

            holder.mIdView.setImageBitmap(result);

            holder.mContentView.setText(text);



        }

    }



