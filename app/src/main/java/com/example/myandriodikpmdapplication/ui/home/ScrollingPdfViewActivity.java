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
        setContentView(R.layout.activity_scrolling_pdf_view);


        PDFView pdfView;

        pdfView = findViewById(R.id.pdfView);


        String url = null;

        InputStream pdf = null;


        Thread thread = new Thread() {


            public void run() {


                Archive archive = new ArchiveOrgUrlService();



                Http http = new HttpService();

                try {

                    String url = DataHolder.pdfUrl;
                    InputStream pdf = http.download(url);
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


        pdfView.fromStream(DataHolder.pdf);

    }
}