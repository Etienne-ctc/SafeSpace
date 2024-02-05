package com.example.safespace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.sql.ResultSet;

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
                try{
                    String query = "SELECT id,pro_id,typ From user WHERE mail='"+log.getText()+"' AND mdp='"+password.getText()+"'";
                    ResultSet result = new DataBaseSelect().execute(query).get();
                    if (result != null && result.next()) {
                        if(result.getInt(3)==2){
                            Intent home_intent = new Intent(MainActivity.this, HomePatient.class);
                            home_intent.putExtra("id", result.getString(1));
                            startActivity(home_intent);
                        }
                        if(result.getInt(3)==1){
                            Intent home_intent = new Intent(MainActivity.this, HomePro.class);
                            home_intent.putExtra("id", result.getString(1));
                            startActivity(home_intent);
                        }
                        if(result.getInt(3)==0){
                            Intent home_intent = new Intent(MainActivity.this, HomePatient.class);
                            home_intent.putExtra("id", result.getString(1));
                            startActivity(home_intent);
                        }
                    }
                } catch(Exception e){
                    Log.e("patient","Exception init user info", e.fillInStackTrace());
                    Toast.makeText(MainActivity.this, "Identifiant ou mot de passe incorrect", Toast.LENGTH_LONG).show();
                }
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