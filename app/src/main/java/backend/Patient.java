package backend;

import java.util.ArrayList;

public class Patient extends User{
    private ArrayList<Activities> activities;
    private ArrayList<Statistics> statistics;
    private Professionnal professionnal;
    private String QRCode;

    public Patient(Professionnal professionnal){
        this.professionnal=professionnal;
        activities=new ArrayList<Activities>();
        statistics=new ArrayList<Statistics>();
    }
    private void generateQRCode(){
    //to do
    }
    public void addActivities(Activities act){
        activities.add(act);
    }
    public void updateActivities(Activities act){
        //to do
    }
    public void addStatistics(String name, StatisticsValues stats){
        //to do
    }

    public void removeStatistics(String name, StatisticsValues stats){
        //to do
    }
}
