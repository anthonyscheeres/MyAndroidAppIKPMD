package com.example.myandriodikpmdapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class GridAdapterHome extends BaseAdapter {

    Context context;
    private LayoutInflater layoutInflater;
    private String[] values;
    private String[] images;


    public GridAdapterHome(Context context, String[] values, String[] images) {
        this.context = context;
        this.values = values;
        this.images = images;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view ==null){
            view = new View(context);

            view  = layoutInflater.inflate(R.layout.fragment_home, null);

        }


        return null;
    }
}
