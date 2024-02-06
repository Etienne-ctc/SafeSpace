package com.example.safespace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import backend.HomeWork;
import backend.Parameter;
import backend.Patient;
import backend.Professionnal;

public class CreateExercicesPro extends AppCompatActivity {

    private EditText intitule;
    private TextView nom;
    private Button valider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_exercices_pro);

        Intent intent = getIntent();
        String id_pro = intent.getStringExtra("id");
        String UID = intent.getStringExtra("UID");
        Professionnal professionnal = new Professionnal(id_pro, true);
        Patient patient = new Patient(UID);

        intitule = findViewById(R.id.intitulé_homework_editTextText2);

        nom = findViewById(R.id.nom_patient_homework_editTextText3);
        nom.setText(String.valueOf(patient.getName() + " " + patient.getSurname()));

        valider = findViewById(R.id.valider_homework_Button);
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String intitule_homework = String.valueOf(intitule.getText());

                HomeWork homeWork = new HomeWork(intitule_homework, false, professionnal);
                String id = professionnal.createHomework(homeWork);
                homeWork.setId(id);
                Log.d("createhw",id + homeWork.toString());
                professionnal.giveHomework(patient, homeWork);

                Intent back_intent = new Intent(CreateExercicesPro.this, FichePatientPro.class);
                back_intent.putExtra("id", id_pro);
                back_intent.putExtra("UID", UID);
                startActivity(back_intent);
            }
        });
    }
}