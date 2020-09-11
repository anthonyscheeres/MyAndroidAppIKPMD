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
import com.example.myandriodikpmdapplication.models.Comic;
import com.example.myandriodikpmdapplication.services.DownloadImageService;

import java.util.ArrayList;

public class GridAdapterHome extends BaseAdapter {

    Context context;
    Archive archive;
    ArrayList<Comic> docs;
    private LayoutInflater layoutInflater;

    public GridAdapterHome(Context context, Archive archive, ArrayList<Comic> docs) {
        this.context = context;
        this.archive = archive;
        this.docs = docs;
    }

    @Override
    public int getCount() {


        if (docs == null) {
            return 0;
        }

        return docs.size();
    }

    @Override
    public Object getItem(int i) {

        if (docs ==null){
            return 0;
        }

        return docs.get(i);
    }

    @Override
    public long getItemId(int i) {
        return docs.get(i).getIdentifier().hashCode();
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        //System.out.println(" idiot 2");

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null) {
            view = new View(context);

            view = layoutInflater.inflate(R.layout.grid_layout, null);

        }


        ImageView imageView2 = view.findViewById(R.id.imageView2);

        TextView textView2 = view.findViewById(R.id.textView);

        Comic doc = docs.get(i);


        String url = archive.image(doc.getIdentifier());


        new DownloadImageService(imageView2)
                .execute(url);

        textView2.setText(doc.getTitle());


        return view;
    }
}
