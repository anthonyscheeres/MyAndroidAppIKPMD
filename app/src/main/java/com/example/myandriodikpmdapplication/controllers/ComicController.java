package com.example.myandriodikpmdapplication.controllers;

import com.example.myandriodikpmdapplication.interfaces.Archive;
import com.example.myandriodikpmdapplication.interfaces.Http;
import com.example.myandriodikpmdapplication.models.ArchiveMetadata;
import com.example.myandriodikpmdapplication.models.Comic;

public class ComicController {

    public Comic addMetadata(Comic comic, Archive archive, Http http) throws Exception {

        ArchiveMetadata metadata = archive.metadata(http, comic.getIdentifier());

        comic.setMetadata(metadata);

        return comic;

    }


}
