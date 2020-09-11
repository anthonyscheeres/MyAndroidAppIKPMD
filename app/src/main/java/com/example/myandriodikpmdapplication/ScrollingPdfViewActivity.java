package com.example.myandriodikpmdapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myandriodikpmdapplication.interfaces.Http;
import com.example.myandriodikpmdapplication.services.HttpService;
import com.github.barteksc.pdfviewer.PDFView;

import java.io.IOException;
import java.io.InputStream;

public class ScrollingPdfViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling_pdf_view);

        Http http = new HttpService();

        PDFView pdfView;

        pdfView = findViewById(R.id.pdfView);

        String url = null;

        InputStream pdf = null;

        try {
            pdf = http.download(url);
        } catch (IOException e) {


        }


        pdfView.fromStream(pdf);

    }
}