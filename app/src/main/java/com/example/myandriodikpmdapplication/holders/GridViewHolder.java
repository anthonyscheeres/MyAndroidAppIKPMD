package com.example.myandriodikpmdapplication.holders;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myandriodikpmdapplication.models.Comic;
import com.example.myandriodikpmdapplication.ui.home.DetailsActivity;

import java.util.ArrayList;

public class GridViewHolder extends RecyclerView.ViewHolder  {

    public ImageView image;

    public TextView text;

    public GridViewHolder(@NonNull View itemView) {
        super(itemView);
    }




}
