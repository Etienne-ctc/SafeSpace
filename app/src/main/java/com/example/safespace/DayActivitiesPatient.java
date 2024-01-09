package com.example.safespace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;

import java.util.HashMap;

public class DayActivitiesPatient extends AppCompatActivity {
    private CheckBox a_check;
    private CheckBox b_check;
    private CheckBox c_check;
    private CheckBox d_check;
    private CheckBox e_check;
    private CheckBox f_check;
    private HashMap<Integer, CheckBox> hash_checkBox;

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

        String[] letters = new String[]{"a","b","c","d","e","f"};
        for (int i = 0; i<6; i++){
            hash_checkBox.put(i, String.valueOf(letters[i]+"_checkBox"));
        }
    }
}