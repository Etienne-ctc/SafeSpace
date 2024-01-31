package com.example.safespace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import backend.*;


public class MainActivity extends AppCompatActivity {
    private EditText log;
    private EditText password;
    private Button connection;
    private Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        log = findViewById(R.id.login_editTextText);
        password = findViewById(R.id.mdp_editText);
        /*User u = new Professionnal("4",true);*/

        connection = findViewById(R.id.valider_button);
        connection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check user in BDD


                // Retour patient ou pro
                Toast.makeText(MainActivity.this, "BDD not check", Toast.LENGTH_LONG).show();
                Intent home_intent = new Intent(MainActivity.this, HomePatient.class);
                startActivity(home_intent);
            }
        });

        register = findViewById(R.id.register_button);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register_intent = new Intent(MainActivity.this, Register.class);
                startActivity(register_intent);
            }
        });

    }

}