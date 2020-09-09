package com.example.myandriodikpmdapplication.services;

import android.content.SharedPreferences;

import com.example.myandriodikpmdapplication.interfaces.Http;
import com.example.myandriodikpmdapplication.interfaces.Identicon;
import com.example.myandriodikpmdapplication.interfaces.Token;
import com.example.myandriodikpmdapplication.models.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.NoSuchElementException;

public class UserIDService implements Token {

    private String USER_ID_NAME = "userID";

    public String get(SharedPreferences settings) throws NoSuchElementException {
        String userID = USER_ID_NAME;
        //Creates user id named after the userID if it didn't exist
        userID = settings.getString(USER_ID_NAME, userID);
        //this triggers if the app is ran first time
        if (userID == USER_ID_NAME) {
            throw new NoSuchElementException();
        }
        return userID;
    }

    public void update(SharedPreferences settings, String userID, Http http, FirebaseDatabase database, Identicon pfp) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(USER_ID_NAME, userID);
        editor.apply();
        User user = new User();
        try {
            String profilePic = pfp.get(http, userID);
            user = new User(profilePic, userID);
        } catch (Exception e) {
            user = new User(userID);
        }
        //Initialize the object that allows modifying the user his account data
        DatabaseReference myRef = database.getReference(userID);
        myRef = database.getReference(userID);
        myRef.setValue(user);
    }
}


