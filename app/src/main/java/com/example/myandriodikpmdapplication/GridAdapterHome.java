package com.example.myandriodikpmdapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myandriodikpmdapplication.services.DownloadImageService;

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

        if (view == null) {
            view = new View(context);

            view = layoutInflater.inflate(R.layout.single_item, null);

            ImageView imageView2 = view.findViewById(R.id.imageView2);

            TextView textView2 = view.findViewById(R.id.textView2);

            new DownloadImageService((ImageView) imageView2)
                    .execute(images[i]);


            textView2.setText(values[i]);


        }


        return view;
    }
}
