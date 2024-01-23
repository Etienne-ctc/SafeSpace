package com.example.safespace;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class DevoirsAdapter extends ArrayAdapter<Devoirs> {

    public DevoirsAdapter(@NonNull Context context, List<Devoirs> devoirs) { super(context, 0, devoirs); }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        Devoirs devoirs = getItem(position);

        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.event_cell, parent, false);

        TextView devoirCellTV = convertView.findViewById(R.id.eventCellTV);

        String devoirTitle = devoirs.getDevoir();
        devoirCellTV.setText(devoirTitle);
        return convertView;
    }
}
