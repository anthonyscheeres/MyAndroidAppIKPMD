package com.example.myandriodikpmdapplication.ui.details;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myandriodikpmdapplication.R;
import com.example.myandriodikpmdapplication.ScrollingPdfViewActivity;
import com.example.myandriodikpmdapplication.adapters.ListAdapterDetails;
import com.example.myandriodikpmdapplication.holders.DataHolder;
import com.example.myandriodikpmdapplication.models.Comic;
import com.example.myandriodikpmdapplication.models.File;

import java.util.ArrayList;

public class ComicDetailsFragment extends Fragment {

    private ComicDetailsViewModel mViewModel;

    public static ComicDetailsFragment newInstance() {
        return new ComicDetailsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        Comic comic = DataHolder.detailsComic;

        View root = inflater.inflate(R.layout.comic_details_fragment, container, false);

        ListView gridview2;

        gridview2 = root.findViewById(R.id.listView);

        ArrayList<File> comics = null;

        if (DataHolder.detailsComic!=null){


            comics = DataHolder.detailsComic.getMetadata().getFiles();

        }


        ListAdapterDetails gridAdapterHome = new ListAdapterDetails(getActivity(), comics);


        gridview2.setAdapter(gridAdapterHome);


        gridview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                //switch view here to go to chapter explorer


                ArrayList<File> comics = DataHolder.detailsComic.getMetadata().getFiles();


                if (comics == null) {
                    return;
                }

                DataHolder.pdfUrl = comics.get(position).getName();

                startActivity(new Intent(getContext(), ScrollingPdfViewActivity.class));

            }
        });


        return root;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ComicDetailsViewModel.class);
        // TODO: Use the ViewModel


    }

}