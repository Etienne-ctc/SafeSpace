package com.example.safespace;

import java.time.LocalDate;
import java.util.ArrayList;

public class Devoirs {

    public static ArrayList<Devoirs> devoirsList = new ArrayList<>();

    public static ArrayList<Devoirs> devoirsForPatients()
    {
        ArrayList<Devoirs> devoirs_return = new ArrayList<>();

        for(Devoirs devoir : devoirsList)
        {
            devoirs_return.add(devoir);
        }

        return devoirs_return;
    }

    private String devoir;

    public Devoirs (String devoir) {
        this.devoir = devoir;
    }

    public String getDevoir() {
        return devoir;
    }

    public void setDevoir(String devoir) {
        this.devoir = devoir;
    }
}
