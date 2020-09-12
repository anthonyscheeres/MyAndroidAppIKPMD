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
import com.example.myandriodikpmdapplication.adapters.MyComicRecyclerViewAdapter;
import com.example.myandriodikpmdapplication.holders.ComicHolder;
import com.example.myandriodikpmdapplication.holders.DataHolder;
import com.example.myandriodikpmdapplication.interfaces.Archive;
import com.example.myandriodikpmdapplication.interfaces.Http;
import com.example.myandriodikpmdapplication.models.ArchiveSearch;
import com.example.myandriodikpmdapplication.services.ArchiveOrgUrlService;
import com.example.myandriodikpmdapplication.services.HttpService;

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

        Thread thread = new Thread() {


            public void run() {
                ArchiveSearch collectionOfComics = null;
                try {
                    //webcomicuniverse || manga_library
                    collectionOfComics = archive.search("webcomicuniverse", http);
                } catch (Exception e) {
                }

                if (collectionOfComics != null) {
                    DataHolder.docs = collectionOfComics.getResponse().getDocs();
                }
            }
        };

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            // System.out.println(" idiot ");


        }


        ComicHolder.ITEMS = DataHolder.docs;

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



/*

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                //switch view here to go to chapter explorer


                ArrayList<Comic> comics = DataHolder.docs;


                if (comics == null) {
                    return;
                }

                DataHolder.detailsComic = comics.get(position);
                startActivity(new Intent(getContext(), DetailsActivity.class));

            }
        });
*/


        return view;
    }
}