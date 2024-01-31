package backend;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Patient extends User{

    private Professionnal professionnal;
    protected ArrayList<Appointement> appointements;
    public Patient(String UID,Professionnal professionnal){
        super(UID);

    }
    public Patient(String UID){
        super(UID);
        this.professionnal=null;
        this.appointements=new ArrayList<Appointement>();

        //Set user's pro
        try {
            ResultSet result = new DataBaseSelect().execute("SELECT * FROM user WHERE id=" + UID).get();
            if (result != null && result.next()) {
                this.professionnal= new Professionnal(result.getString(7),false);
            }
        }catch (Exception e){
            Log.e("patient","Exception init", e.fillInStackTrace());
        }
        //set activities Homework
        try {
            ResultSet result = new DataBaseSelect().execute("SELECT nom, etat From exercice WHERE patient_id=" + this.getUid()).get();
            while (result != null && result.next()) {
                activities.add(new HomeWork(result.getString(1),result.getBoolean(2),professionnal));

            }
        }catch(Exception e){
            Log.e("patient","Exception init", e.fillInStackTrace());
        }
        //set appointements
        try {
            ResultSet result = new DataBaseSelect().execute("SELECT pro_id, daterdv From rdv WHERE patient_id=" + this.getUid()).get();
            while (result != null && result.next()) {
                    appointements.add(new Appointement(this, result.getDate(2), this.professionnal, null));
            }
        }catch(Exception e){
            Log.e("pro","Exception init", e.fillInStackTrace());
        }
    }


    public String toString(){
        super.toString();
        Log.d("patient","This is a patient");
        for(Appointement a : appointements){
            Log.d("patient",a.toString());
        }

        return "";
    }
    public ArrayList<Statistics> getStatistics(){
        return statistics;
    }
    public ArrayList<Activities> getActivity(){
        return activities;
    }
    public Professionnal getProfessionnal() {
        return professionnal;
    }
}
