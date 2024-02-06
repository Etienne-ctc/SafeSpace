package com.example.safespace;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import backend.Activities;

public class DevoirsAdapter extends ArrayAdapter<Activities> {

    public DevoirsAdapter(@NonNull Context context, List<Activities> devoirs) { super(context, 0, devoirs); }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        Activities activities = getItem(position);

        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activities_cell, parent, false);

        CheckBox devoirCellTV = convertView.findViewById(R.id.activities_cell_checkBox);

        String devoirTitle = activities.getName();
        devoirCellTV.setText(devoirTitle);
        return convertView;
    }
}
