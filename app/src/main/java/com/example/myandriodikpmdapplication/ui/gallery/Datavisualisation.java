package com.example.myandriodikpmdapplication.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myandriodikpmdapplication.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

public class Datavisualisation extends Fragment {



    public static Datavisualisation newInstance() {
        return new Datavisualisation();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


       View view =  inflater.inflate(R.layout.datavisualisation_fragment, container, false);


        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View view = getView();

            makeTheBarChart(view);

    }


    public void makeTheBarChart(View view) {


            BarChart chart = (BarChart) view.findViewById(R.id.barchart);


        List<BarEntry> entries = new ArrayList<>();

        entries.add(new BarEntry(0f, 30f));
        entries.add(new BarEntry(1f, 80f));
        entries.add(new BarEntry(2f, 60f));
        entries.add(new BarEntry(3f, 50f));   // gap of 2f
        entries.add(new BarEntry(5f, 70f));
        entries.add(new BarEntry(6f, 60f));
        BarDataSet set = new BarDataSet(entries, "BarDataSet");
        BarData data = new BarData(set);
        chart.setData(data);
        chart.setDescription(new Description( ));
        chart.animateXY(2000, 2000);
        chart.invalidate();
    }


/*    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
      //  mViewModel = ViewModelProviders.of(this).get(DatavisualisationViewModel.class);
        // TODO: Use the ViewModel
    }*/

}