package com.example.myandriodikpmdapplication.services;

import com.example.myandriodikpmdapplication.interfaces.Database;
import com.google.firebase.database.DatabaseReference;

import java.util.Map;

public class FirebaseRealtimeDatabaseService implements Database {

    public void set(DatabaseReference myRef, Object body){
        myRef.setValue(body);

    }


    public void delete(DatabaseReference myRef){
      myRef.removeValue();
    }

}
