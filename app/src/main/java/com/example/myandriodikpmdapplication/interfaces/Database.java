package com.example.myandriodikpmdapplication.interfaces;

import com.google.firebase.database.DatabaseReference;

public interface Database {
    public void set(DatabaseReference myRef, Object body);


    public void delete(DatabaseReference myRef);
}
