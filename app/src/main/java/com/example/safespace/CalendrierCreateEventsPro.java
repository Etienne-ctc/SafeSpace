package com.example.safespace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import backend.Appointement;
import backend.DataBaseSelect;
import backend.Patient;
import backend.Professionnal;

public class CalendrierCreateEventsPro extends AppCompatActivity {
    private EditText titre_rdv;
    private TextView date_rdv;
    private String date_passed;
    private Spinner heure_rdv;
    private Spinner spinner_patients;
    private Button valider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendrier_create_events_pro);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        Date date = Date.valueOf(intent.getStringExtra("date"));
        Professionnal pro = new Professionnal(id, true);

        // Récuperer la date depuis l'activité parente
        date_rdv = findViewById(R.id.dateRDV_TextView);
        date_rdv.setText(String.valueOf(date));

        // Spinner pour les heures de rdv
        heure_rdv = findViewById(R.id.heureRDV_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.heure_array,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        heure_rdv.setAdapter(adapter);

        // Spinner pour les patients
        spinner_patients = findViewById(R.id.patients_spinner);
        processAdapter(pro);

        // Boutton pour valider le rdv créé
        valider = findViewById(R.id.validerRDV_button);
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Send RDV to BDD

                /* To Test */
                // Traitement pour l'intitulé
                String name_rdv = titre_rdv.getText().toString();

                // Traitement pour l'heure
                String selected = heure_rdv.getSelectedItem().toString();
                selected = selected.substring(0, selected.length()-1);
                date.setHours(Integer.parseInt(selected));

                // Traitement pour la date
                String[] elem = date_passed.split("-");
                Toast.makeText(CalendrierCreateEventsPro.this, elem[2], Toast.LENGTH_LONG).show();

                //Traitement pour le patient
                String patient_selected = spinner_patients.getSelectedItem().toString();
                String[] patientCute = patient_selected.split(" ");

                //createTestEvent(name_rdv, elem, Integer.valueOf(selected));

                Patient patient = new Patient(getIdPatient(patientCute[0], patientCute[1]));
                Appointement appointement = new Appointement(patient, date, pro, name_rdv);
                pro.createAppointement(appointement);

                Intent back = new Intent(CalendrierCreateEventsPro.this, CalendrierPro.class);
                startActivity(back);
            }
        });
    }

    private void createTestEvent(String name_rdv, String[] elem, Integer heure){
        Event newEvent = new Event(name_rdv, LocalDate.of(Integer.parseInt(elem[2]),Integer.parseInt(elem[1]),Integer.parseInt(elem[0])),
                LocalTime.of(heure,0,0));
        Event.eventsList.add(newEvent);
    }

    private void processAdapter(Professionnal pro){
        ArrayList<Patient> patients = pro.getPatients();
        ArrayList<String> list_nom = new ArrayList<>();

        for(Patient patient : patients){
            list_nom.add(patient.getName() + " " + patient.getSurname());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item, list_nom);
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);

        spinner_patients.setAdapter(adapter);

    }

    private String getIdPatient(String nom, String prenom){
        String ret = null;
        try {
            String query = "SELECT id FROM user WHERE nom='" + nom + "' AND prenom='" + prenom + "'";
            ResultSet result = new DataBaseSelect().execute(query).get();
            if (result != null && result.next()) {
                ret = result.getString(1);
            }

        }catch (Exception e){
            ret = null;
        }
        return ret;
    }

}