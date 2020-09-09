package com.example.myandriodikpmdapplication.interfaces;

import com.example.myandriodikpmdapplication.models.ArchiveManga;
import com.example.myandriodikpmdapplication.models.ArchiveMetadata;
import com.example.myandriodikpmdapplication.models.Protocol;

public interface Archive {

    public ArchiveManga search(String search, Http http) throws Exception;
    public ArchiveMetadata metadata(Http http, String identifier) throws Exception;
    public String file (  ArchiveMetadata   archiveMetadata , String file);
    public String image (String identifier);

}
