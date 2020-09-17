package com.example.myandriodikpmdapplication.ui.home;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myandriodikpmdapplication.R;
import com.example.myandriodikpmdapplication.interfaces.Http;
import com.example.myandriodikpmdapplication.services.HttpService;
import com.github.barteksc.pdfviewer.PDFView;

import java.io.IOException;
import java.net.URL;

public class ScrollingPdfViewActivity extends AppCompatActivity {


    private Http file = new HttpService();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_scrolling_pdf_view);

        final PDFView pdfView = findViewById(R.id.pdfView);

        final String url = getIntent().getStringExtra("1");

        Thread thread = new Thread() {


            @RequiresApi(api = Build.VERSION_CODES.O)
            public void run() {

                byte[] buffer = new byte[2048];

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