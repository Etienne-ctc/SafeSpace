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

import java.time.LocalDate;
import java.time.LocalTime;

public class CalendrierCreateEventsPro extends AppCompatActivity {
    private EditText titre_rdv;
    private TextView date_rdv;
    private String date_passed;
    private Spinner heure_rdv;
    private Button valider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendrier_create_events_pro);

        titre_rdv = findViewById(R.id.titreRDV_editTextText);

        // Récuperer la date depuis l'activité parente
        Intent intent = getIntent();
        date_passed = intent.getStringExtra("date");
        date_rdv = findViewById(R.id.dateRDV_TextView);
        date_rdv.setText(date_passed);

        // Spinner pour les heures de rdv
        heure_rdv = findViewById(R.id.heureRDV_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.heure_array,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        heure_rdv.setAdapter(adapter);

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

                // Traitement pour la date
                String[] elem = date_passed.split("-");
                Toast.makeText(CalendrierCreateEventsPro.this, elem[2], Toast.LENGTH_LONG).show();

                createTestEvent(name_rdv, elem, Integer.valueOf(selected));
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
}