package com.example.myandriodikpmdapplication.ui.details;

import androidx.lifecycle.ViewModel;

import com.example.myandriodikpmdapplication.controllers.ComicController;
import com.example.myandriodikpmdapplication.holders.DataHolder;
import com.example.myandriodikpmdapplication.interfaces.Archive;
import com.example.myandriodikpmdapplication.interfaces.Http;
import com.example.myandriodikpmdapplication.models.Comic;
import com.example.myandriodikpmdapplication.services.ArchiveOrgUrlService;
import com.example.myandriodikpmdapplication.services.HttpService;

public class ComicDetailsViewModel extends ViewModel {
    // TODO: Implement the ViewModel


    public ComicDetailsViewModel() {


        if (DataHolder.detailsComic == null) {
            return;
        }


        ComicController controller = new ComicController();

        Http http = new HttpService();

        Archive archive = new ArchiveOrgUrlService();


        Comic comic = DataHolder.detailsComic;

        try {
            controller.addMetadata(comic, archive, http);
        } catch (Exception e) {

        }


    }
}