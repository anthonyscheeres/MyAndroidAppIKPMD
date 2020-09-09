package com.example.myandriodikpmdapplication.services;

import com.example.myandriodikpmdapplication.interfaces.Archive;
import com.example.myandriodikpmdapplication.interfaces.Http;
import com.example.myandriodikpmdapplication.models.ArchiveManga;
import com.example.myandriodikpmdapplication.models.ArchiveMetadata;
import com.example.myandriodikpmdapplication.models.Protocol;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ArchiveOrgUrlService implements Archive {

    private ObjectMapper objectMapper = new ObjectMapper();

    public ArchiveManga search(String search, Http http) throws Exception {


//got this url from https://archive.org/advancedsearch.php#raw
        String url = "https://archive.org/advancedsearch.php?q=" + search + "&fl[]=avg_rating&fl[]=description&fl[]=identifier&fl[]=title&sort[]=downloads+desc&sort[]=&sort[]=&rows=100&page=1&output=json";

        String json = http.send(url, Protocol.GET.toString());

        ArchiveManga MangaCollection = objectMapper.readValue(json, ArchiveManga.class);

        return MangaCollection;

    }

    public ArchiveMetadata metadata(Http http, String identifier) throws Exception {

        String url = "https://archive.org/metadata/" + identifier;

        String json = http.send(url, Protocol.GET.toString());

        ArchiveMetadata Metadata = objectMapper.readValue(json, ArchiveMetadata.class);

        return Metadata;


    }


    public String file(ArchiveMetadata archiveMetadata, String file) {

        //url like: https://ia800104.us.archive.org/20/items/manga_Fairy_Tail_Blue_Mistral/Fairy%20Tail%20-%20Blue%20Mistral%20-%20c3%20%28mag%29%20%5BLoveNaluFan%5D.pdf
        String url = "https://" + archiveMetadata.getD1() + archiveMetadata.getDir() + "/" + file;

        return url;

    }

    public String image(String identifier) {
        String url = "https://archive.org/services/img/" + identifier ;

        return url;
    }


}



