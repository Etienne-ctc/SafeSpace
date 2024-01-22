package com.example.safespace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class CalendrierPatient extends AppCompatActivity {
    private TextView date;
    private CalendarView cal;
    private ListView events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendrier_patient);

        date = findViewById(R.id.date_TextView);
        events = findViewById(R.id.patients_ListView);

        cal = findViewById(R.id.calendar_CalendarView);
        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                //String Date = dayOfMonth + "-" + (month + 1) + "-" + year;
                //date.setText(Date);

                LocalDate selectedDate = LocalDate.of(year,month + 1,dayOfMonth);
                setEventAdpater(selectedDate);
            }
        });

        /* For Test */
        createTestEvent();

    }

    private void setEventAdpater(LocalDate date)
    {
        ArrayList<Event> dailyEvents = Event.eventsForDate(date);
        EventAdapter eventAdapter = new EventAdapter(getApplicationContext(), dailyEvents);
        events.setAdapter(eventAdapter);
    }

    private void createTestEvent(){
        Event newEvent = new Event("Test", LocalDate.of(2024,1,16), LocalTime.of(12,0,0));
        Event.eventsList.add(newEvent);
    }
}