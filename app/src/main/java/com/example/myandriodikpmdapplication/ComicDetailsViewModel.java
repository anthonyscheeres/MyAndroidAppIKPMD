package com.example.myandriodikpmdapplication;

import androidx.lifecycle.ViewModel;

import com.example.myandriodikpmdapplication.controllers.ComicController;
import com.example.myandriodikpmdapplication.interfaces.Archive;
import com.example.myandriodikpmdapplication.interfaces.Http;
import com.example.myandriodikpmdapplication.models.Comic;
import com.example.myandriodikpmdapplication.models.Data;
import com.example.myandriodikpmdapplication.services.ArchiveOrgUrlService;
import com.example.myandriodikpmdapplication.services.HttpService;

public class ComicDetailsViewModel extends ViewModel {
    // TODO: Implement the ViewModel


    public ComicDetailsViewModel() {

        ComicController controller = new ComicController();

        Http http = new HttpService();

        Archive archive = new ArchiveOrgUrlService();

        Comic comic = Data.detailsComic;

        try {
            controller.addMetadata(comic, archive, http);
        } catch (Exception e) {

        }


    }
}