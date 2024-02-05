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
import backend.*;

public class PatientsAdapter extends ArrayAdapter<Patient> {

    public PatientsAdapter(@NonNull Context context, List<Patient> patients) { super(context, 0, patients); }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        Patient patients = getItem(position);

        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.event_cell, parent, false);

        TextView patientCellTV = convertView.findViewById(R.id.eventCellTV);

        String patientsTitle = patients.getName() + " " + patients.getSurname();
        patientCellTV.setText(patientsTitle);
        return convertView;
    }
}
