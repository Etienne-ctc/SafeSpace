package com.example.safespace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomePatient extends AppCompatActivity {
    private Button param;
    private Button dayActivities;
    private Button devoirs;
    private Button humeur;
    private Button sommeil;
    private TextView addPro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_patient);

        param = findViewById(R.id.paramètres_button);
        param.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent param_intent = new Intent(HomePatient.this, Parametres.class);
                startActivity(param_intent);
            }
        });

        dayActivities = findViewById(R.id.dayActivities_button);
        dayActivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day_intent = new Intent(HomePatient.this, DayActivitiesPatient.class);
                startActivity(day_intent);
            }
        });

        devoirs = findViewById(R.id.devoirs_button);
        devoirs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent devoirs_intent = new Intent(HomePatient.this, DevoirsPatient.class);
                startActivity(devoirs_intent);
            }
        });

        humeur = findViewById(R.id.humeur_button);
        humeur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent humeur_intent = new Intent(HomePatient.this, HumeurPatient.class);
                startActivity(humeur_intent);
            }
        });

        sommeil = findViewById(R.id.sommeil_button);
        sommeil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sommeil_intent = new Intent(HomePatient.this, SommeilPatient.class);
                startActivity(sommeil_intent);
            }
        });

        addPro = findViewById(R.id.addPro_textView);
        addPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent code_patient = new Intent(HomePatient.this, QRCodePro.class);
                startActivity(code_patient);
            }
        });
    }
}