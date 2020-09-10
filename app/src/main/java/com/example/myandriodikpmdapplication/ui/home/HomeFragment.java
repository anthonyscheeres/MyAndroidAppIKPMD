package com.example.myandriodikpmdapplication.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myandriodikpmdapplication.GridAdapterHome;
import com.example.myandriodikpmdapplication.R;
import com.example.myandriodikpmdapplication.services.ArchiveOrgUrlService;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.grid_collection, container, false);

        GridView gridview2;

        gridview2 = root.findViewById(R.id.gridView2);


        GridAdapterHome gridAdapterHome = new GridAdapterHome(getActivity(), new ArchiveOrgUrlService(), homeViewModel.getDocs());


        gridview2.setAdapter(gridAdapterHome);


        gridview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
            }
        });


        return root;
    }
}