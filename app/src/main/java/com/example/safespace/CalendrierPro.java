package com.example.safespace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import backend.*;

public class CalendrierPro extends AppCompatActivity {
    private Button addEvents;
    private CalendarView cal;
    private ListView events;
    private LocalDate selectedDate;
    private Date sendedDate;
    private String internDate;
    private Boolean dateChange = false;
    private Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendrier_pro);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        Professionnal pro = new Professionnal(id, true);

        Calendar calendar = Calendar.getInstance();
        Date aujDate = new Date(calendar.getTimeInMillis());
        SetAppointementAdapter(pro, aujDate);

        // Récupération des rdv pour le jour courant
        /*events = findViewById(R.id.events_ListView);
        Calendar date = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String curDate = sdf.format(date.getTime());
        String[] curCute = curDate.split("-");
        setEventAdpater(LocalDate.of(Integer.parseInt(curCute[2]), Integer.parseInt(curCute[1]), Integer.parseInt(curCute[0])));*/

        cal = findViewById(R.id.calendar_CalendarView);
        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                dateChange = true;
                //internDate = dayOfMonth+"-"+(month+1)+"-"+year;
                //LocalDate selectedDate = LocalDate.of(year,month + 1,dayOfMonth);
                //setEventAdpater(selectedDate);

                date = new Date(year, month, dayOfMonth);
                SetAppointementAdapter(pro, date);
            }
        });

        // Boutton pour ajouter des rdv
        addEvents = findViewById(R.id.addEvents_button);
        addEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dateChange.equals(true)){
                    sendedDate = date;
                    Toast.makeText(CalendrierPro.this, sendedDate.toString(), Toast.LENGTH_LONG).show();
                }
                else {
                    Calendar date = Calendar.getInstance();
                    Date aujDate = new Date(calendar.getTimeInMillis());
                    //SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    sendedDate = aujDate;
                }

                Intent add_events_intent = new Intent(CalendrierPro.this, CalendrierCreateEventsPro.class);
                add_events_intent.putExtra("id", id);
                add_events_intent.putExtra("date", String.valueOf(sendedDate));
                startActivity(add_events_intent);
            }
        });
    }

    /*private void setEventAdpater(LocalDate date) {
        ArrayList<Event> dailyEvents = Event.eventsForDate(date);
        EventAdapter eventAdapter = new EventAdapter(getApplicationContext(), dailyEvents);
        events.setAdapter(eventAdapter);
    }*/

    private void SetAppointementAdapter(Professionnal pro, Date date){
        ArrayList<Appointement> rdv_lists = pro.getAppointements();
        ArrayList<Appointement> new_lists = new ArrayList<>();

        for(Appointement app : rdv_lists){
            if(app.getDate().getDay() == date.getDay()){
                new_lists.add(app);
            }
        }

        EventAdapter eventAdapter = new EventAdapter(getApplicationContext(), new_lists);
        events.setAdapter(eventAdapter);
    }
}