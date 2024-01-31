package com.example.safespace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DevoirsPatient extends AppCompatActivity {
    private TextView d_liste;
    private ListView liste_devoirs;
    private Button valider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devoirs_patient);

        d_liste = findViewById(R.id.liste_devoirs_textView);

        liste_devoirs = findViewById(R.id.devoirs_ListView);
        /* For Test */
        createDevoirs("Aller faire des courses");
        createDevoirs("Appeler sa famille");
        /* */
        setDevoirsAdpater();

        valider = findViewById(R.id.valider_devoirs_button);
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Send to BDD with checkbox is checked or not
                Intent back_intent = new Intent(DevoirsPatient.this, HomePatient.class);
                startActivity(back_intent);
            }
        });
    }

    private void setDevoirsAdpater() {
        //Get patients from BDD

        ArrayList<Devoirs> devoirs = Devoirs.devoirsForPatients();
        DevoirsAdapter devoirsAdapter = new DevoirsAdapter(getApplicationContext(), devoirs);
        liste_devoirs.setAdapter(devoirsAdapter);
    }

    private void createDevoirs(String devoir){
        Devoirs devoirs = new Devoirs(devoir);
        Devoirs.devoirsList.add(devoirs);
    }
}