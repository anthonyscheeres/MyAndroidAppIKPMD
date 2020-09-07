package com.example.myandriodikpmdapplication.interfaces;

import android.content.SharedPreferences;

import com.google.firebase.database.FirebaseDatabase;

import java.util.NoSuchElementException;

public interface Token {


    public String get(SharedPreferences settings) throws NoSuchElementException;

    public void update(SharedPreferences settings, String userID, Http http, FirebaseDatabase database, Identicon pfp);


}
