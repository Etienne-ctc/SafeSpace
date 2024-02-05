package com.example.safespace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePro extends AppCompatActivity {
    private Button param;
    private Button calendrier;
    private Button patients;
    private Button qrcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_pro);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        param = findViewById(R.id.param_button);
        param.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent param_intent = new Intent(HomePro.this, Parametres.class);
                param_intent.putExtra("type", "pro");
                startActivity(param_intent);
            }
        });

        calendrier = findViewById(R.id.cal_pro_button);
        calendrier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cal_pro_intent = new Intent(HomePro.this, CalendrierPro.class);
                cal_pro_intent.putExtra("id", id);
                startActivity(cal_pro_intent);
            }
        });

        patients = findViewById(R.id.liste_patients_button);
        patients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent patients_intent = new Intent(HomePro.this, ListePatientPro.class);
                patients_intent.putExtra("id", id);
                startActivity(patients_intent);
            }
        });

        qrcode = findViewById(R.id.qr_button);
        qrcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent qrcode_intent = new Intent(HomePro.this, QRCodePro.class);
                startActivity(qrcode_intent);
            }
        });
    }
}