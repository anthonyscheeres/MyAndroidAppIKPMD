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


    ArrayList<Object> docs;





    public HomeViewModel() {

        System.out.println("idiot " +Data.docs);

        getData();

        docs = Data.docs;



        System.out.println("idiot " +Data.docs);

    }

    private void getData() {

        Http http = new HttpService();

        Archive archive = new ArchiveOrgUrlService();


            Thread thread = new Thread(){


                public void run(){


                    ArchiveManga collectionOfComics = null;
                    try {
                        collectionOfComics = archive.search("webcomicuniverse", http);

                    } catch (Exception e) {

                    }


                    Data.docs = collectionOfComics.getResponse().getDocs();


                }
            };

            thread.start();

            try {
                thread.join();
            } catch (InterruptedException e) {

            }



    }

    public ArrayList<Object> getDocs() {
        return docs;
    }
}