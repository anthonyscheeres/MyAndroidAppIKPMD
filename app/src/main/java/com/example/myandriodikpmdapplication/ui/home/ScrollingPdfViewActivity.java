package com.example.myandriodikpmdapplication.ui.home;

import android.content.Intent;
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


        setContentView(R.layout.activity_scrolling_pdf_view);

        final PDFView pdfView = findViewById(R.id.pdfView);

        Intent intent = getIntent();


        final String url = DataHolder.pdfUrl;




        Thread thread = new Thread() {


            public void run() {


                final Archive archive = new ArchiveOrgUrlService();


                final Http http = new HttpService();

                ByteArrayOutputStream pdf = null;

                try {

                    pdf= http.download(new URL(url));
                    DataHolder.pdf = pdf;


                } catch (IOException e) {


                }


                if (pdf == null){return;}

                pdfView.fromBytes(pdf.toByteArray())
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .defaultPage(0)
                        .enableAnnotationRendering(false)
                        .scrollHandle(null)
                        .enableAntialiasing(true)
                        .load();

            }
        };

        thread.start();

    }
}