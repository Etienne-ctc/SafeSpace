package backend;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Patient extends User{
    private ArrayList<Activities> activities;
    private ArrayList<Statistics> statistics;
    private Professionnal professionnal;
    private String QRCode;

    public Patient(String UID,Professionnal professionnal){
        super(UID);

    }
    public Patient(String UID){
        super(UID);
        this.professionnal=null;
        activities=new ArrayList<Activities>();
        statistics=new ArrayList<Statistics>();
        try {
            ResultSet result = new DataBaseSelect().execute("SELECT * FROM patients WHERE idPatient=" + UID).get();
            if (result != null && result.next()) {
                this.professionnal= new Professionnal(result.getString(2),false);
            }
        }catch (Exception e){
            Log.e("patient","Exception init", e.fillInStackTrace());
        }
    }
    private void generateQRCode(){
    //to do
    }
    public void addActivities(Activities act){
        //add to database for completion 0
        activities.add(act);
    }
    public void updateActivities(Activities act){
        //to do
        /**
         * 1st add to data base
         * if it works
         * change the value in the arraylist
         */
    }
    public void addStatistics(String name, StatisticsValues stats){
        //to do
        /**
         * get the values and add them to the data base
         * then to the array list
         */
    }

    public void removeStatistics(String name, StatisticsValues stats){
        //to do
        /**
         * Get the value to be removed
         * delete from the array
         * then from the data base
         */
    }
    public String toString(){
        super.toString();
        return "";
    }


}
