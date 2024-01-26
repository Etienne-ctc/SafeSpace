package backend;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class Professionnal extends User{

    private ArrayList<Patient> patients;
    private ArrayList<HomeWork> myHomeWorks;


    public Professionnal(String UID,boolean set){
        super(UID);
        if(set){
            this.patients=new ArrayList<Patient>();
            this.myHomeWorks=new ArrayList<HomeWork>();
            try {
                ResultSet result = new DataBaseSelect().execute("SELECT id FROM user WHERE pro_id=" + UID).get();
                if (result != null){
                    while(result.next()){
                        patients.add(new Patient(result.getString(1)));
                    }
                }
            }catch (Exception e){
                Log.e("pro","Exception init", e.fillInStackTrace());

            }
        }


    }
    public void createActivity(HomeWork hw){
        /**
         * Create the homework object
         * then create it in the database
         *
         */
    }
    public void giveHomework(Patient p, HomeWork h){
        p.addActivities(h);
    }

    public String toString(){
        super.toString();
        Log.d("pro","This is a pro");
        for(Patient p : patients){
            p.toString();
        }

        return "";
    }
}
