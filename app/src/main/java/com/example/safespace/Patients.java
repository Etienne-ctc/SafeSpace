package com.example.safespace;

import java.util.ArrayList;

public class Patients {

    public static ArrayList<Patients> patientsList = new ArrayList<>();

    public static ArrayList<Patients> patientForPro()
    {
        ArrayList<Patients> return_patients = new ArrayList<>();

        for(Patients patient : patientsList)
        {
            return_patients.add(patient);
        }

        return return_patients;
    }

    private String pro;
    private String patients;

    public Patients(String pro, String patients) {
        this.pro = pro;
        this.patients = patients;
    }

    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }

    public String getPatients() {
        return patients;
    }

    public void setPatients(String patients) {
        this.patients = patients;
    }
}
