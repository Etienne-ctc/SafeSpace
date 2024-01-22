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

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

public class CalendrierPro extends AppCompatActivity {
    private Button addEvents;
    private CalendarView cal;
    private ListView events;
    private LocalDate selectedDate;
    private String sendedDate;
    private String internDate;
    private Boolean dateChange = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendrier_pro);

        // Récupération des rdv pour le jour courant
        events = findViewById(R.id.events_ListView);
        Calendar date = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String curDate = sdf.format(date.getTime());
        String[] curCute = curDate.split("-");
        setEventAdpater(LocalDate.of(Integer.parseInt(curCute[2]), Integer.parseInt(curCute[1]), Integer.parseInt(curCute[0])));

        // Boutton pour ajouter des rdv
        addEvents = findViewById(R.id.addEvents_button);
        addEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dateChange.equals(true)){
                    sendedDate = internDate;
                    Toast.makeText(CalendrierPro.this, sendedDate, Toast.LENGTH_LONG).show();
                }
                else {
                    Calendar date = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    sendedDate = sdf.format(date.getTime());
                }

                Intent add_events_intent = new Intent(CalendrierPro.this, CalendrierCreateEventsPro.class);
                add_events_intent.putExtra("date", sendedDate);
                startActivity(add_events_intent);
            }
        });

        cal = findViewById(R.id.calendar_CalendarView);
        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                dateChange = true;
                internDate = dayOfMonth+"-"+(month+1)+"-"+year;
                LocalDate selectedDate = LocalDate.of(year,month + 1,dayOfMonth);
                setEventAdpater(selectedDate);
            }
        });
    }

    private void setEventAdpater(LocalDate date) {
        ArrayList<Event> dailyEvents = Event.eventsForDate(date);
        EventAdapter eventAdapter = new EventAdapter(getApplicationContext(), dailyEvents);
        events.setAdapter(eventAdapter);
    }
}