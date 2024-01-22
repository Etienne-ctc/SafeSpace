package com.example.safespace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListePatientPro extends AppCompatActivity {
    private TextView p_liste;
    private ListView liste_patients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_patientpro);

        p_liste = findViewById(R.id.liste_patients_textView);

        liste_patients = findViewById(R.id.patients_ListView);
        liste_patients.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent fiche_patients_intent = new Intent(ListePatientPro.this, FichePatientPro.class);
                fiche_patients_intent.putExtra("nom_patient", String.valueOf(Patients.patientsList.get(position).getPatients()));
                startActivity(fiche_patients_intent);
            }
        });

        /* For Test */
        createPatients("M. Pro", "M. Patient");
        /* */

        setPatientsAdpater();
    }

    private void setPatientsAdpater() {
        //Get patients from BDD

        ArrayList<Patients> patients = Patients.patientForPro();
        PatientsAdapter patientsAdapter = new PatientsAdapter(getApplicationContext(), patients);
        liste_patients.setAdapter(patientsAdapter);
    }

    private void createPatients(String pro, String patient){
        Patients patients = new Patients(pro, patient);
        Patients.patientsList.add(patients);
    }

}