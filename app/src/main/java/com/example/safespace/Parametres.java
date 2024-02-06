package com.example.safespace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import backend.User;

public class Parametres extends AppCompatActivity {
    private TextView nom;
    private TextView prenom;
    private TextView mail;
    private Switch theme;
    private TextView notif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);

        Intent this_intent = getIntent();
        String type = this_intent.getStringExtra("type");
        //Integer id = this_intent.getIntExtra("id_patient", 0);
        String id = this_intent.getStringExtra("id");

        nom = findViewById(R.id.nom_textView);
        prenom = findViewById(R.id.prenom_textView);
        mail = findViewById(R.id.mail_textView);
        // When bdd online
        initTextView(id);

        theme = findViewById(R.id.themes_switch);
        //Boolean theme_state = theme.isChecked();

        notif = findViewById(R.id.notif_textView);
        notif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent notif_param = new Intent(Parametres.this, Notifications.class);
                notif_param.putExtra("type", type);
                notif_param.putExtra("id", id);
                startActivity(notif_param);
            }
        });
    }

    private void initTextView(String id){
        User user = new User(id);
        nom.setText(nom.getText() + user.getName());
        prenom.setText(prenom.getText() + user.getSurname());
        mail.setText(mail.getText() + user.getMail());
    }
}