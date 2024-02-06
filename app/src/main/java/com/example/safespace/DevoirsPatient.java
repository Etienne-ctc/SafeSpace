package com.example.safespace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import backend.*;

public class DevoirsPatient extends AppCompatActivity {
    private TextView d_liste;
    private ListView liste_devoirs;
    private Button valider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devoirs_patient);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        Patient patient = new Patient(id);

        d_liste = findViewById(R.id.liste_devoirs_textView);

        liste_devoirs = findViewById(R.id.devoirs_ListView);

        setActivitiesAdapter(patient);

        valider = findViewById(R.id.valider_devoirs_button);
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Send to BDD with checkbox is checked or not
                Intent back_intent = new Intent(DevoirsPatient.this, HomePatient.class);
                back_intent.putExtra("id",id);
                startActivity(back_intent);
            }
        });

        /* For Test */
        //createDevoirs("Aller faire des courses");
        //createDevoirs("Appeler sa famille");
        /* */
    }

    /*private void setDevoirsAdpater() {
        //Get patients from BDD

        ArrayList<Devoirs> devoirs = Devoirs.devoirsForPatients();
        DevoirsAdapter devoirsAdapter = new DevoirsAdapter(getApplicationContext(), devoirs);
        liste_devoirs.setAdapter(devoirsAdapter);
    }*/

    /*private void createDevoirs(String devoir){
        Devoirs devoirs = new Devoirs(devoir);
        Devoirs.devoirsList.add(devoirs);
    }*/

    private void setActivitiesAdapter(Patient patient){
        ArrayList<Activities> acti = patient.getActivity();
        DevoirsAdapter devoirsAdapter = new DevoirsAdapter(getApplicationContext(), acti);
        liste_devoirs.setAdapter(devoirsAdapter);
    }
}