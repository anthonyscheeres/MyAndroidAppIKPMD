package com.example.myandriodikpmdapplication.holders;

import com.example.myandriodikpmdapplication.models.ArchiveMetadata;
import com.example.myandriodikpmdapplication.models.Comic;
import com.example.myandriodikpmdapplication.models.User;

import java.io.InputStream;
import java.util.ArrayList;

public class DataHolder {
    public static ArrayList<Comic> docs;

    public static User user;

    public static Comic detailsComic;

    public static ArchiveMetadata metadata;

    public static String pdfUrl;


    public static InputStream pdf;
}
