package com.example.safespace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FichePatientPro extends AppCompatActivity {
    private TextView fiche_patient;
    private TextView nom_patient;
    private TextView prochain_rdv;
    private TextView date_rdv;
    private TextView analyse;
    private TextView humeur;
    private TextView sommeil;
    private TextView routine;
    private ImageView humeur_graphe;
    private ImageView sommeil_graphe;
    private ImageView routine_graphe;
    private TextView add_exos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiche_patient_pro);

        Intent this_intent = getIntent();
        String nom_patients = this_intent.getStringExtra("nom_patient");

        fiche_patient = findViewById(R.id.fiche_patient_textView);
        nom_patient = findViewById(R.id.nom_patient_textView);
        nom_patient.setText(nom_patients);

        prochain_rdv = findViewById(R.id.prochain_rdv_textView);
        date_rdv = findViewById(R.id.date_rdv_textView);

        humeur = findViewById(R.id.humeur_patient_textView);
        sommeil = findViewById(R.id.sommeil_patient_textView);
        routine = findViewById(R.id.routine_patient_textView);

        humeur_graphe = findViewById(R.id.humeur_imageView);
        sommeil_graphe = findViewById(R.id.sommeil_imageView);
        routine_graphe = findViewById(R.id.routine_imageView);

        add_exos = findViewById(R.id.add_exo_textView);
        add_exos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exo_intent = new Intent(FichePatientPro.this, CreateExercicesPro.class);
                startActivity(exo_intent);
            }
        });
    }
}