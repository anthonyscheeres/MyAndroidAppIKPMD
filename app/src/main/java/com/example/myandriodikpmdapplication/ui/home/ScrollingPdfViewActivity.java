package com.example.myandriodikpmdapplication.ui.home;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myandriodikpmdapplication.R;
import com.example.myandriodikpmdapplication.interfaces.Archive;
import com.example.myandriodikpmdapplication.interfaces.Http;
import com.example.myandriodikpmdapplication.models.DataHolder;
import com.example.myandriodikpmdapplication.services.ArchiveOrgUrlService;
import com.example.myandriodikpmdapplication.services.HttpService;
import com.github.barteksc.pdfviewer.PDFView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

public class ScrollingPdfViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ByteArrayOutputStream[] pdf = new ByteArrayOutputStream[1];

        Thread thread = new Thread() {


            public void run() {


                Archive archive = new ArchiveOrgUrlService();


                Http http = new HttpService();

                try {

                    pdf[0] = http.download(new URL(DataHolder.pdfUrl));
                    DataHolder.pdf = pdf[0];


                } catch (IOException e) {

                    e.printStackTrace();

                }


            }
        };

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            // System.out.println(" idiot ");


        }

        setContentView(R.layout.activity_scrolling_pdf_view);

        PDFView pdfView = findViewById(R.id.pdfView);

        pdfView.fromBytes(pdf[0].toByteArray())
                .enableSwipe(true)
                .swipeHorizontal(true)
                .enableDoubletap(true)
                .defaultPage(0)
                .enableAnnotationRendering(false)
                .scrollHandle(null)
                .enableAntialiasing(true)
                .load();


    }
}