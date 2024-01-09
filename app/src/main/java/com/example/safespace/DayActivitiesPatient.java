package com.example.safespace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class DayActivitiesPatient extends AppCompatActivity {
    private CheckBox a_check;
    private CheckBox b_check;
    private CheckBox c_check;
    private CheckBox d_check;
    private CheckBox e_check;
    private CheckBox f_check;
    private Button retour;
    private Integer stats = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_activities);

        a_check = findViewById(R.id.a_checkBox);
        b_check = findViewById(R.id.b_checkBox);
        c_check = findViewById(R.id.c_checkBox);
        d_check = findViewById(R.id.d_checkBox);
        e_check = findViewById(R.id.e_checkBox);
        f_check = findViewById(R.id.f_checkBox);

        retour = findViewById(R.id.retour_button);
    }

    @Override
    protected void onStart() {
        super.onStart();
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a_check.isChecked()){
                    stats++;
                }if(b_check.isChecked()){
                    stats++;
                }if(c_check.isChecked()){
                    stats++;
                }if(d_check.isChecked()){
                    stats++;
                }if(e_check.isChecked()){
                    stats++;
                }if(f_check.isChecked()){
                    stats++;
                }
                Toast.makeText(DayActivitiesPatient.this, String.valueOf(stats), Toast.LENGTH_LONG).show();

                // Envoyer stats to BDD
                stats = 0;

                Intent home_intent = new Intent(DayActivitiesPatient.this, HomePatient.class);
                startActivity(home_intent);
            }
        });
    }
}