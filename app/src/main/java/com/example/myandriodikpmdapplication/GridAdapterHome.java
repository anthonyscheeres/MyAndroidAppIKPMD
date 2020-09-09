package com.example.myandriodikpmdapplication;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.example.myandriodikpmdapplication.interfaces.Archive;
import com.example.myandriodikpmdapplication.services.DownloadImageService;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class GridAdapterHome extends BaseAdapter {

    Context context;
    Archive archive;
    ArrayList<Object> docs;
    private LayoutInflater layoutInflater;

    public GridAdapterHome(Context context, Archive archive, ArrayList<Object> docs) {
        this.context = context;
        this.archive = archive;
        this.docs = docs;
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

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null) {
            view = new View(context);

            view = layoutInflater.inflate(R.layout.grid_layout, null);

            ImageView imageView2 = view.findViewById(R.id.textView2);

            TextView textView2 = view.findViewById(R.id.textView2);

            Object doc = docs.get(i);


            Class<?> clazz = doc.getClass();
            Field field = null; //Note, this can throw an exception if the field doesn't exist.

            try {


                field = clazz.getField("title");

                Object title = field.getChar(doc);

                field = clazz.getField("identifier");

                Object identifier = field.getChar(doc);

                String url = archive.image(identifier.toString());

                new DownloadImageService(imageView2)
                        .execute(url);


                textView2.setText(title.toString());


            } catch (NoSuchFieldException | IllegalAccessException e) {

            }


        }


        return view;
    }
}
