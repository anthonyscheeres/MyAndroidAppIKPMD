package com.example.myandriodikpmdapplication.services;

import com.example.myandriodikpmdapplication.interfaces.Http;
import com.example.myandriodikpmdapplication.models.ArchiveManga;
import com.example.myandriodikpmdapplication.models.ArchiveMetadata;
import com.example.myandriodikpmdapplication.models.Protocol;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONObject;

public class ArchiveOrgService {


    public ArchiveManga data(String search, Http http) throws Exception {
        String url = "https://archive.org/advancedsearch.php?q=" + search + "&fl[]=avg_rating&fl[]=backup_location&fl[]=btih&fl[]=call_number&fl[]=collection&fl[]=contributor&fl[]=coverage&fl[]=creator&fl[]=date&fl[]=description&fl[]=downloads&fl[]=external-identifier&fl[]=foldoutcount&fl[]=format&fl[]=genre&fl[]=headerImage&fl[]=identifier&fl[]=imagecount&fl[]=indexflag&fl[]=item_size&fl[]=language&fl[]=licenseurl&fl[]=mediatype&fl[]=members&fl[]=month&fl[]=name&fl[]=noindex&fl[]=num_reviews&fl[]=oai_updatedate&fl[]=publicdate&fl[]=publisher&fl[]=related-external-id&fl[]=reviewdate&fl[]=rights&fl[]=scanningcentre&fl[]=source&fl[]=stripped_tags&fl[]=subject&fl[]=title&fl[]=type&fl[]=volume&fl[]=week&fl[]=year&sort[]=downloads+desc&sort[]=&sort[]=&rows=100&page=1&output=json";
        String json = http.send(url, Protocol.GET.toString());

        ObjectMapper objectMapper = new ObjectMapper();

        ArchiveManga MangaCollection = objectMapper.readValue(json, ArchiveManga.class);

        return MangaCollection;

    }

    public ArchiveMetadata metadata(Http http){

    }



}



