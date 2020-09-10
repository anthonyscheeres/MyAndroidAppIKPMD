package com.example.myandriodikpmdapplication.ui.home;

import androidx.lifecycle.ViewModel;

import com.example.myandriodikpmdapplication.interfaces.Archive;
import com.example.myandriodikpmdapplication.interfaces.Http;
import com.example.myandriodikpmdapplication.models.ArchiveManga;
import com.example.myandriodikpmdapplication.models.Data;
import com.example.myandriodikpmdapplication.services.ArchiveOrgUrlService;
import com.example.myandriodikpmdapplication.services.HttpService;
import com.example.myandriodikpmdapplication.services.JoinExample;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class HomeViewModel extends ViewModel {


    AtomicReference<ArrayList<Object>> docsz;

    ArrayList<Object> docs = null;




    public HomeViewModel() {

        docsz.set(getData());

    }

    private ArrayList<Object> getData() {

        Http http = new HttpService();

        Archive archive = new ArchiveOrgUrlService();


        try {

            Thread thread = new Thread(){


                public void run(){


                    ArchiveManga collectionOfComics = null;
                    try {
                        collectionOfComics = archive.search("webcomicuniverse", http);
                        System.out.println("idiot zzzzzzzzzzzzzzz");
                    } catch (Exception e) {

                    }


                    Data.docs = collectionOfComics.getResponse().getDocs();


                }
            };

            thread.start();

            thread.join();

            docs = Data.docs;

        } catch (Exception e) {
            System.out.println("idiot zz");
        }

        if (docs == null) {

            docs = new ArrayList<Object>();

        }

        return docs;

    }


    public AtomicReference<ArrayList<Object>> getDocs() {
        return docsz;
    }
}