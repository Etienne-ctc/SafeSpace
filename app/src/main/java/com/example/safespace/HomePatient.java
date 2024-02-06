package com.example.safespace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomePatient extends AppCompatActivity {
    private Button param;
    private Button dayActivities;
    private Button devoirs;
    private Button humeur;
    private Button sommeil;
    private Button addPro;
    private Button cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_patient);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        Boolean typ = intent.getBooleanExtra("type", false);

        // Notifications Test
        createNotify();

        param = findViewById(R.id.paramètres_button);
        param.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent param_intent = new Intent(HomePatient.this, Parametres.class);
                param_intent.putExtra("type", "patient");
                // add extra with patient id
                //param_intent.putExtra("id_patient", 2);
                param_intent.putExtra("id", id);
                startActivity(param_intent);
            }
        });

        dayActivities = findViewById(R.id.dayActivities_button);
        dayActivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent day_intent = new Intent(HomePatient.this, DayActivitiesPatient.class);
                day_intent.putExtra("id", id);
                startActivity(day_intent);
            }
        });

        devoirs = findViewById(R.id.devoirs_button);
        devoirs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent devoirs_intent = new Intent(HomePatient.this, DevoirsPatient.class);
                devoirs_intent.putExtra("id", id);
                startActivity(devoirs_intent);
            }
        });

        humeur = findViewById(R.id.humeur_button);
        humeur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent humeur_intent = new Intent(HomePatient.this, HumeurPatient.class);
                humeur_intent.putExtra("id", id);
                startActivity(humeur_intent);
            }
        });

        sommeil = findViewById(R.id.sommeil_button);
        sommeil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sommeil_intent = new Intent(HomePatient.this, SommeilPatient.class);
                sommeil_intent.putExtra("id", id);
                startActivity(sommeil_intent);
            }
        });

        addPro = findViewById(R.id.add_pro_button);
        if(typ){
            addPro.setVisibility(View.GONE);
        }
        else {
            addPro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent code_patient = new Intent(HomePatient.this, QRCodePatient.class);
                    code_patient.putExtra("id", id);
                    startActivity(code_patient);
                }
            });
        }

        cal = findViewById(R.id.calendrier_button);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cal_patient = new Intent(HomePatient.this, CalendrierPatient.class);
                cal_patient.putExtra("id", id);
                startActivity(cal_patient);
            }
        });
    }

    public void createNotify() {
        // Intent For onTap notifications
        Intent intent = new Intent(this, HomePatient.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        // Notifications Channel
        NotificationChannel channel = new NotificationChannel("Test Notifications", "SafeSpace Notifications", NotificationManager.IMPORTANCE_DEFAULT);
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);

        // My Notifications
        NotificationCompat.Builder builder = new NotificationCompat.Builder(HomePatient.this, "Test Notifications")
                .setContentTitle("Notications from HomePatient")
                .setContentText("This is a notification from HomePatient page")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        // Notify user
        notificationManager.notify(1, builder.build());
    }
}