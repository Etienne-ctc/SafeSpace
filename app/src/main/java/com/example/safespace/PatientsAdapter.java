package com.example.safespace;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PatientsAdapter extends ArrayAdapter<Patients> {

    public PatientsAdapter(@NonNull Context context, List<Patients> patients) { super(context, 0, patients); }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        Patients patients = getItem(position);

        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.event_cell, parent, false);

        TextView patientCellTV = convertView.findViewById(R.id.eventCellTV);

        String patientsTitle = patients.getPatients();
        patientCellTV.setText(patientsTitle);
        return convertView;
    }
}
