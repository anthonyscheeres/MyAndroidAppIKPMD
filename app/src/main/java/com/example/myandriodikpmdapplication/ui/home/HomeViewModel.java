package com.example.myandriodikpmdapplication.ui.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myandriodikpmdapplication.interfaces.Archive;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Object>> mText;
    private Archive r;

    public HomeViewModel(MutableLiveData<ArrayList<Object>> mText, Archive r) {
        this.mText = mText;
        this.r = r;
    }

    public MutableLiveData<ArrayList<Object>> getmText() {
        return mText;
    }

    public Archive getR() {
        return r;
    }
}