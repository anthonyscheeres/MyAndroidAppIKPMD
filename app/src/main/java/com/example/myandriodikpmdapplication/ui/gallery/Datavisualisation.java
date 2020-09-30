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

    private DatavisualisationViewModel mViewModel;

    public static Datavisualisation newInstance() {
        return new Datavisualisation();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {










        return inflater.inflate(R.layout.datavisualisation_fragment, container, false);





    }




/*    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
      //  mViewModel = ViewModelProviders.of(this).get(DatavisualisationViewModel.class);
        // TODO: Use the ViewModel
    }*/

}