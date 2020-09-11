package com.example.myandriodikpmdapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myandriodikpmdapplication.models.Comic;
import com.example.myandriodikpmdapplication.models.Data;

public class ComicDetailsFragment extends Fragment {

    private ComicDetailsViewModel mViewModel;

    public static ComicDetailsFragment newInstance() {
        return new ComicDetailsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        Comic comic = Data.detailsComic;

        return inflater.inflate(R.layout.comic_details_fragment, container, false);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ComicDetailsViewModel.class);
        // TODO: Use the ViewModel


    }

}