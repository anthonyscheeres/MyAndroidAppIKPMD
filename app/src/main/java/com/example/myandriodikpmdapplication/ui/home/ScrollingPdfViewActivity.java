package com.example.myandriodikpmdapplication.ui.home;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myandriodikpmdapplication.R;
import com.example.myandriodikpmdapplication.interfaces.Http;
import com.example.myandriodikpmdapplication.services.HttpService;
import com.github.barteksc.pdfviewer.PDFView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ScrollingPdfViewActivity extends AppCompatActivity {


    private Http file = new HttpService();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_scrolling_pdf_view);

        final PDFView pdfView = findViewById(R.id.pdfView);


        final ProgressBar load = findViewById(R.id.progressBar);

        load.setVisibility(View.VISIBLE);

        final String url = getIntent().getStringExtra("1");

        Thread thread = new Thread() {


            @RequiresApi(api = Build.VERSION_CODES.O)
            public void run() {

                try {
                    URL urlz = new URL(url);
                    InputStream is = null;
                    byte[] bytes = null;
                    try {
                        is = urlz.openStream ();
                        bytes = IOUtils.toByteArray(is);
                    } catch (IOException e) {
                        //handle errors
                    }
                    finally {
                        if (is != null) is.close();
                    }


                    if (bytes==null){ load.setVisibility(View.INVISIBLE); return;}


                    pdfView.fromBytes(bytes)
                            .enableSwipe(true)
                            .swipeHorizontal(true)
                            .enableDoubletap(true)
                            .defaultPage(0)
                            .enableAnnotationRendering(false)
                            .scrollHandle(null)
                            .enableAntialiasing(true)
                            .load();


                    load.setVisibility(View.INVISIBLE);



                } catch (Error | IOException ex) {

                }




            }
        };

        thread.start();

    }
}