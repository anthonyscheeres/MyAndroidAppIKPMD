package com.example.myandriodikpmdapplication.ui.home;

import androidx.lifecycle.ViewModel;

import com.example.myandriodikpmdapplication.interfaces.Archive;
import com.example.myandriodikpmdapplication.interfaces.Http;
import com.example.myandriodikpmdapplication.models.ArchiveManga;
import com.example.myandriodikpmdapplication.services.ArchiveOrgUrlService;
import com.example.myandriodikpmdapplication.services.HttpService;
import com.example.myandriodikpmdapplication.services.JoinExample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class HomeViewModel extends ViewModel {


    AtomicReference<ArrayList<Object>> docsz;

    public HomeViewModel() {

        docsz.set(getData());

    }

    private ArrayList<Object> getData() {

        Http http = new HttpService();

        Archive archive= new ArchiveOrgUrlService();


        ArrayList<Object> docs = null;
try{



    JoinExample runnable=new JoinExample();



    Thread t1 = new Thread(runnable);

    t1.start();
    
        //change to manga_library to turn it into manga app


              ArchiveManga collectionOfComics = archive.search("webcomicuniverse", http);



  docs = collectionOfComics.getResponse().getDocs();
                t1.join();

            } catch (Exception e) {
    System.out.println("idiot zz");
            }

if (docs==null){

    docs = new ArrayList<Object>();

}

return docs;

    }


    public AtomicReference<ArrayList<Object>> getDocs() {
        return docsz;
    }
}