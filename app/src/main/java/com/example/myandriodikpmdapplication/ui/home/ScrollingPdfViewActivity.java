package com.example.myandriodikpmdapplication.ui.home;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myandriodikpmdapplication.R;
import com.example.myandriodikpmdapplication.interfaces.File;
import com.example.myandriodikpmdapplication.models.DataHolder;
import com.example.myandriodikpmdapplication.services.HttpDownloader;
import com.github.barteksc.pdfviewer.PDFView;

import java.io.IOException;
import java.net.URL;

public class ScrollingPdfViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_scrolling_pdf_view);

        final PDFView pdfView = findViewById(R.id.pdfView);

        final String url = getIntent().getStringExtra("1");

        Thread thread = new Thread() {


            @RequiresApi(api = Build.VERSION_CODES.O)
            public void run() {


                byte[] buffer = new byte[1024];

                File file = new HttpDownloader();


                try {

                    buffer = file.download(new URL(url), buffer);


                    pdfView.fromBytes(buffer)
                            .enableSwipe(true)
                            .swipeHorizontal(true)
                            .enableDoubletap(true)
                            .defaultPage(0)
                            .enableAnnotationRendering(false)
                            .scrollHandle(null)
                            .enableAntialiasing(true)
                            .load();

                } catch (IOException e) {


                }


            }
        };

        thread.start();

    }
}