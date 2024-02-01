package backend;

import android.util.Log;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Professionnal extends User{

    private ArrayList<Patient> patients;
    private ArrayList<HomeWork> myHomeWorks;
    protected ArrayList<Appointement> appointements;

    public Professionnal(String UID,boolean set){
        super(UID);
        if(set){
            this.patients=new ArrayList<Patient>();
            this.myHomeWorks=new ArrayList<HomeWork>();
            this.appointements=new ArrayList<Appointement>();
            //set patient list
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
            //Set homework
            try {
                ResultSet result = new DataBaseSelect().execute("SELECT id,nom, etat From exercice WHERE pro_id=" + this.getUid()).get();
                while (result != null && result.next()) {
                    myHomeWorks.add(new HomeWork(result.getString(2),result.getBoolean(3),this,result.getString(1)));

                }
            }catch(Exception e){
                Log.e("pro","Exception init", e.fillInStackTrace());
            }
            //set appointements
            try {
                ResultSet result = new DataBaseSelect().execute("SELECT patient_id, daterdv From rdv WHERE pro_id=" + this.getUid()).get();
                while (result != null && result.next()) {
                    try {
                        appointements.add(new Appointement(patients.get(this.getPatientID(result.getString(1))), result.getDate(2), this, null));
                    }catch(PatientDoesntExistException e){
                    }

                }
            }catch(Exception e){
                Log.e("pro","Exception init", e.fillInStackTrace());
            }
        }


    }

    private int getPatientID(String string) throws PatientDoesntExistException {
        for (int i = 0; i < patients.size(); i++) {
            if(patients.get(i).UID==string){
                return i;
            }
        }
        throw new PatientDoesntExistException(string);
    }

    public void createHomework(HomeWork hw){
        /**
         * Create the homework object
         * then create it in the database
         *
         */
    }
    public void updateHomework(HomeWork hw){
        //to do
    }
    public void deleteHomework(HomeWork hw){
        //to do
    }
    public void giveHomework(Patient p, HomeWork h){
        //To do database
        p.addActivities(h);
    }

    public void createAppointement(Appointement app){
        //To do

    }
    public void deleteAppointement(Appointement app){
        //To do
    }
    public void updateAppointement(Appointement app){
//To do
    }

    public String toString(){
        super.toString();
        Log.d("pro","This is a pro");
        for(Patient p : patients){
            p.toString();
        }
        for(Appointement a : appointements){
            Log.d("pro",a.toString());
        }
        return "";
    }
}
