package com.example.safespace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class Notifications extends AppCompatActivity {
    private Switch rdv;
    private Switch add_patients;
    private Switch recap;

    private Switch humeur;
    private Switch sommeil;
    private Switch to_do;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

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
        Intent this_intent = getIntent();
        String type = this_intent.getStringExtra("type");
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

    }
}