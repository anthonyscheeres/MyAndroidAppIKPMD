package com.example.myandriodikpmdapplication.ui.home;

import androidx.lifecycle.ViewModel;

import com.example.myandriodikpmdapplication.holders.DataHolder;
import com.example.myandriodikpmdapplication.interfaces.Archive;
import com.example.myandriodikpmdapplication.interfaces.Http;
import com.example.myandriodikpmdapplication.models.ArchiveSearch;
import com.example.myandriodikpmdapplication.models.Comic;
import com.example.myandriodikpmdapplication.services.ArchiveOrgUrlService;
import com.example.myandriodikpmdapplication.services.HttpService;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel {


    ArrayList<Comic> docs;


    public HomeViewModel() {


        getData();

        docs = DataHolder.docs;


    }

    private void getData() {

        Http http = new HttpService();

        Archive archive = new ArchiveOrgUrlService();

        if (DataHolder.docs != null) {
            return;
        }


        Thread thread = new Thread() {


            public void run() {
                ArchiveSearch collectionOfComics = null;
                try {
                    //webcomicuniverse || manga_library
                    collectionOfComics = archive.search("webcomicuniverse", http);
                } catch (Exception e) {
                }

                if (collectionOfComics != null) {
                    DataHolder.docs = collectionOfComics.getResponse().getDocs();
                }
            }
        };

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            // System.out.println(" idiot ");


        }


    }

    public ArrayList<Comic> getDocs() {
        return docs;
    }
}