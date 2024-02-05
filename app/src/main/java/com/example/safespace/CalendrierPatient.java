package com.example.safespace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;

import backend.Appointement;
import backend.Patient;
import backend.Professionnal;

public class CalendrierPatient extends AppCompatActivity {
    private TextView date;
    private CalendarView cal;
    private ListView events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendrier_patient);
        events = findViewById(R.id.patients_ListView);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        Patient patient = new Patient(id);
        Calendar calendar = Calendar.getInstance();
        Date aujDate = new Date(calendar.getTimeInMillis());
        setAppointementAdapter(patient, aujDate);

        date = findViewById(R.id.date_TextView);

        cal = findViewById(R.id.calendar_CalendarView);
        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                //String Date = dayOfMonth + "-" + (month + 1) + "-" + year;
                //date.setText(Date);

                Date date = new Date(year-1900, month, dayOfMonth);
                setAppointementAdapter(patient, date);
            }
        });

        /* For Test */
        //createTestEvent();

    }

    /*private void setEventAdpater(LocalDate date)
    {
        ArrayList<Event> dailyEvents = Event.eventsForDate(date);
        EventAdapter eventAdapter = new EventAdapter(getApplicationContext(), dailyEvents);
        events.setAdapter(eventAdapter);
    }*/

    private void createTestEvent(){
        Event newEvent = new Event("Test", LocalDate.of(2024,1,16), LocalTime.of(12,0,0));
        Event.eventsList.add(newEvent);
    }

    private void setAppointementAdapter(Patient patient, Date date){
        ArrayList<Appointement> rdv_lists = patient.getAppointements();
        ArrayList<Appointement> new_lists = new ArrayList<>();

        for(Appointement app : rdv_lists){
            if(app.getDate().equals(date)){
                new_lists.add(app);
            }
        }

        EventAdapter eventAdapter = new EventAdapter(getApplicationContext(), new_lists);
        events.setAdapter(eventAdapter);
    }
}