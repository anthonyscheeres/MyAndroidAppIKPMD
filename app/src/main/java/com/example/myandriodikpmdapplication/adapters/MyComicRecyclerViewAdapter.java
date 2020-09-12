package com.example.myandriodikpmdapplication.adapters;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myandriodikpmdapplication.R;
import com.example.myandriodikpmdapplication.interfaces.Archive;
import com.example.myandriodikpmdapplication.models.Comic;
import com.example.myandriodikpmdapplication.services.ArchiveOrgUrlService;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Comic}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyComicRecyclerViewAdapter extends RecyclerView.Adapter<MyComicRecyclerViewAdapter.ViewHolder> {

    private final List<Comic> mValues;

    public MyComicRecyclerViewAdapter(List<Comic> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        Archive archive = new ArchiveOrgUrlService();

        String url = archive.image(mValues.get(position).getIdentifier());


        new DownloadImageForHolder(holder, mValues.get(position).getTitle(), mValues.get(position)
        )
                .execute(url);

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView mIdView;
        public final TextView mContentView;
        public Comic mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (ImageView) view.findViewById(R.id.item_number);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}