package com.example.myandriodikpmdapplication.ui.home;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myandriodikpmdapplication.R;
import com.example.myandriodikpmdapplication.holders.DataHolder;
import com.example.myandriodikpmdapplication.interfaces.Archive;
import com.example.myandriodikpmdapplication.interfaces.Http;
import com.example.myandriodikpmdapplication.services.ArchiveOrgUrlService;
import com.example.myandriodikpmdapplication.services.HttpService;
import com.github.barteksc.pdfviewer.PDFView;

import java.io.IOException;
import java.io.InputStream;

public class ScrollingPdfViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Thread thread = new Thread() {


            public void run() {


                Archive archive = new ArchiveOrgUrlService();


                Http http = new HttpService();

                try {

                    InputStream pdf = http.download(DataHolder.pdfUrl);
                    DataHolder.pdf = pdf;

                } catch (IOException e) {


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

        System.out.println("idiot " + DataHolder.pdfUrl);

        pdfView.fromStream(DataHolder.pdf)
                .enableSwipe(true)
                .swipeHorizontal(true)
                .enableDoubletap(true)
                .defaultPage(0)
                .enableAnnotationRendering(false)
                .password(null)
                .scrollHandle(null)
                .enableAntialiasing(true)
                .load();


    }
}