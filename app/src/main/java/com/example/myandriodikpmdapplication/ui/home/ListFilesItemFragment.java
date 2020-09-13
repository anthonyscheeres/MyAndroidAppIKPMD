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
import com.example.myandriodikpmdapplication.models.ArchiveMetadata;
import com.example.myandriodikpmdapplication.models.DataHolder;
import com.example.myandriodikpmdapplication.services.ArchiveOrgUrlService;
import com.example.myandriodikpmdapplication.services.HttpService;
import com.example.myandriodikpmdapplication.ui.home.adapters.MyFilesRecyclerViewAdapter;
import com.example.myandriodikpmdapplication.ui.home.adapters.holders.FilesHolder;

/**
 * A fragment representing a list of Items.
 */
public class ListFilesItemFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ListFilesItemFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ListFilesItemFragment newInstance(int columnCount) {
        ListFilesItemFragment fragment = new ListFilesItemFragment();
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
        View view = inflater.inflate(R.layout.fragment_list_files_item_list, container, false);
        final ArchiveMetadata[] metadata = {null};

        Thread thread = new Thread() {


            public void run() {


                try {
                    Http http = new HttpService();

                    Archive archive = new ArchiveOrgUrlService();
                    metadata[0] = archive.metadata(http, DataHolder.detailsComic.getIdentifier());

                    DataHolder.metadata = metadata[0];


                } catch (Exception e) {


                }


            }
        };

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            // System.out.println(" idiot ");


        }


        FilesHolder.ITEMS = metadata[0].getFiles();

        // DataHolder.detailsComic.setMetadata(metadata);


        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyFilesRecyclerViewAdapter(FilesHolder.ITEMS));
        }
        return view;
    }
}