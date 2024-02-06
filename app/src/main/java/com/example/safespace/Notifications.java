package com.example.safespace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import backend.*;

public class Notifications extends AppCompatActivity {
    private Switch rdv;
    private Switch add_patients;
    private Switch recap;

    private Switch humeur;
    private Switch sommeil;
    private Switch to_do;

    private Button valider;

    private Professionnal pro;
    private Patient patient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        String id = intent.getStringExtra("id");
        if(type.equals("pro")){
            pro = new Professionnal(id, true);
        }
        else {
            patient = new Patient(id);
        }


        // Pro's switch
        rdv = findViewById(R.id.rdv_switch);
        Boolean rdv_state = rdv.isChecked();
        add_patients = findViewById(R.id.add_patients_switch);
        Boolean patients_state = add_patients.isChecked();
        recap = findViewById(R.id.recap_switch);
        Boolean recap_state = recap.isChecked();

        // Patient's switch
        humeur = findViewById(R.id.humeur_switch);
        Boolean humeur_state = humeur.isChecked();
        sommeil = findViewById(R.id.sommeil_switch);
        Boolean sommeil_state = sommeil.isChecked();
        to_do = findViewById(R.id.to_do_switch);
        Boolean to_do_state = to_do.isChecked();

        // Visibilty depending on the type
        if(type.equals("pro")){
            humeur.setVisibility(View.GONE);
            sommeil.setVisibility(View.GONE);
            to_do.setVisibility(View.GONE);
        }
        else {
            rdv.setVisibility(View.GONE);
            add_patients.setVisibility(View.GONE);
            recap.setVisibility(View.GONE);
        }

        valider = findViewById(R.id.valider_notif_button);
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type.equals("pro")){
                    Log.d("notif","this is a pro");
                    Parameter parameter = pro.getParameter();
                    parameter.updateRdv(!rdv_state);

                    parameter.updateAdd_patients(!patients_state);
                    parameter.updateRecap(!recap_state);

                }
                else {
                    Log.d("notif","this is a patient");
                    Parameter parameter = patient.getParameter();
                    parameter.updateHumeur(!humeur_state);
                    parameter.updateSommeil(!sommeil_state);
                    parameter.updateTodo(!to_do_state);

                }
            }
        });
    }
}