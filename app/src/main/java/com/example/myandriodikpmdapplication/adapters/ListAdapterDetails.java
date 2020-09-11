package com.example.myandriodikpmdapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.myandriodikpmdapplication.R;
import com.example.myandriodikpmdapplication.holders.ListViewHolder;
import com.example.myandriodikpmdapplication.models.File;

import java.util.ArrayList;

public class ListAdapterDetails extends BaseAdapter {

    ArrayList<File> files;

    Context context;

    private LayoutInflater layoutInflater;

    public ListAdapterDetails(Context context, ArrayList<File> files) {
        this.files = files;
        this.context = context;

    }

    @Override
    public int getCount() {
        return files.size();
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

        //System.out.println(" idiot 2");

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ListViewHolder holder;
        if (view == null) {
            view = new View(context);

            holder = new ListViewHolder(view);

            view = layoutInflater.inflate(R.layout.comic_details_fragment, null);


            holder.text = view.findViewById(R.id.textView4);

            view.setTag(holder);
        } else {
            holder = (ListViewHolder) view.getTag();
        }


        holder.text = view.findViewById(R.id.textView4);

        File doc = files.get(i);


        return view;
    }
}
