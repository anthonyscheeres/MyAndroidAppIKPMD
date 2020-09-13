package com.example.myandriodikpmdapplication.ui.home.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myandriodikpmdapplication.R;
import com.example.myandriodikpmdapplication.interfaces.Archive;
import com.example.myandriodikpmdapplication.models.ArchiveMetadata;
import com.example.myandriodikpmdapplication.models.DataHolder;
import com.example.myandriodikpmdapplication.models.File;
import com.example.myandriodikpmdapplication.services.ArchiveOrgUrlService;
import com.example.myandriodikpmdapplication.ui.home.ScrollingPdfViewActivity;

import java.util.List;


public class MyFilesRecyclerViewAdapter extends RecyclerView.Adapter<MyFilesRecyclerViewAdapter.ViewHolder> {

    private final List<File> mValues;

    public MyFilesRecyclerViewAdapter(List<File> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_list_files_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {


        holder.mItem = mValues.get(position);
        holder.mContentView.setText(mValues.get(position).getName());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArchiveMetadata metadata = DataHolder.metadata;

                Archive archive = new ArchiveOrgUrlService();

                DataHolder.pdfUrl = archive.file(metadata, metadata.getFiles().get(position).getName());

                v.getContext().startActivity(new Intent(v.getContext(), ScrollingPdfViewActivity.class));

            }
        });


    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public File mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = view.findViewById(R.id.item_number);
            mContentView = view.findViewById(R.id.content);

        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}