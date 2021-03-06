package com.example.myandriodikpmdapplication.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myandriodikpmdapplication.R;
import com.example.myandriodikpmdapplication.interfaces.Archive;
import com.example.myandriodikpmdapplication.interfaces.Http;
import com.example.myandriodikpmdapplication.models.ArchiveSearch;
import com.example.myandriodikpmdapplication.models.DataHolder;
import com.example.myandriodikpmdapplication.services.ArchiveOrgUrlService;
import com.example.myandriodikpmdapplication.services.HttpService;
import com.example.myandriodikpmdapplication.ui.home.adapters.MyComicRecyclerViewAdapter;
import com.example.myandriodikpmdapplication.ui.home.adapters.holders.ComicHolder;

/**
 * A fragment representing a list of Items.
 */
public class ComicFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ComicFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ComicFragment newInstance(int columnCount) {
        ComicFragment fragment = new ComicFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);


        Http http = new HttpService();

        Archive archive = new ArchiveOrgUrlService();

        final ArchiveSearch[] collectionOfComics = {null};

        Thread thread = new Thread() {


            public void run() {

                try {
                    //webcomicuniverse || manga_library
                    collectionOfComics[0] = archive.search("webcomicuniverse", http);
                } catch (Exception e) {
                }

                if (collectionOfComics[0] != null) {
                    DataHolder.docs = collectionOfComics[0].getResponse().getDocs();
                }
            }
        };

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {

        }

        if (collectionOfComics[0] != null) {

            ComicHolder.ITEMS = collectionOfComics[0].getResponse().getDocs();

            // Set the adapter
            if (view instanceof RecyclerView) {
                Context context = view.getContext();
                RecyclerView recyclerView = (RecyclerView) view;
                if (mColumnCount <= 1) {
                    recyclerView.setLayoutManager(new LinearLayoutManager(context));
                } else {
                    recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
                }
                recyclerView.setAdapter(new MyComicRecyclerViewAdapter(ComicHolder.ITEMS));


            }
        }

        return view;
    }
}