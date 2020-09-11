package com.example.myandriodikpmdapplication.interfaces;

import com.example.myandriodikpmdapplication.models.ArchiveSearch;
import com.example.myandriodikpmdapplication.models.ArchiveMetadata;

public interface Archive {

    ArchiveSearch search(String search, Http http) throws Exception;

    ArchiveMetadata metadata(Http http, String identifier) throws Exception;

    String file(ArchiveMetadata archiveMetadata, String file);

    String image(String identifier);

}
