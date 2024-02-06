package com.example.safespace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Date;
import java.util.Calendar;

import backend.Patient;
import backend.Sleep;

public class SommeilPatient extends AppCompatActivity {
    private TextView sommeil;
    private TextView duree;
    private TextView qualite;
    private SeekBar duree_seekbar;
    private SeekBar qualite_seekbar;
    private ImageView S0;
    private ImageView S1;
    private ImageView S2;
    private ImageView S3;
    private ImageView S4;
    private EditText comm;
    private Button valider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sommeil_patient);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        Patient patient = new Patient(id);

        sommeil = findViewById(R.id.humeur_textView);
        duree = findViewById(R.id.temps_textView);
        qualite = findViewById(R.id.qualite_textView);

        duree_seekbar = findViewById(R.id.heure_sommeil_seekBar);
        duree_seekbar.setMax(12);
        duree_seekbar.setProgress(0);

        qualite_seekbar = findViewById(R.id.qualite_sommeil_seekBar);
        qualite_seekbar.setMax(4);
        qualite_seekbar.setProgress(0);

        S0 = findViewById(R.id.S0_imageView);
        S1 = findViewById(R.id.S1_imageView);
        S2 = findViewById(R.id.S2_imageView);
        S3 = findViewById(R.id.S3_imageView);
        S4 = findViewById(R.id.S4_imageView);

        comm = findViewById(R.id.commentaire_sommeil_editTextText);

        valider = findViewById(R.id.valider_sommeil_button);
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Traitement durée du sommeil
                    int duree = duree_seekbar.getProgress();
                    /* Send to BDD */

                    // Traitement qualité du sommeil
                    int qualite = qualite_seekbar.getProgress();
                    /* Send to BDD */

                    // Traitemtent commentaire du sommeil
                    String commentaire = String.valueOf(comm.getText());

                    Calendar calendar = Calendar.getInstance();
                    Date aujDate = new Date(calendar.getTimeInMillis());

                    Sleep sleep = new Sleep(qualite, aujDate, duree, commentaire);
                    patient.addSleep(sleep);

                    Toast.makeText(SommeilPatient.this, "Les informations ont bien été prises en compte", Toast.LENGTH_LONG).show();
                    Intent home_intent = new Intent(SommeilPatient.this, HomePatient.class);
                    startActivity(home_intent);
                }
                catch (Exception e){
                    Toast.makeText(SommeilPatient.this, "Un problème est survenu", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}