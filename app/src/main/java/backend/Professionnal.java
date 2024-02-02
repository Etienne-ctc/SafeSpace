package backend;

import android.util.Log;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
                String query = "SELECT patient_id, daterdv From rdv WHERE pro_id="+getUid();
                ResultSet result = new DataBaseSelect().execute(query).get();
                while (result != null && result.next()) {
                    try {

                        appointements.add(new Appointement(patients.get(this.getPatientID(result.getString(1))), result.getDate(2), this, null));
                    }catch(PatientDoesntExistException e){
                        Log.e("pro","Exception init", e.fillInStackTrace());
                    }

                }
            }catch(Exception e){
                Log.e("pro","Exception init", e.fillInStackTrace());
            }
        }


    }

    private int getPatientID(String string) throws PatientDoesntExistException {
        for (int i = 0; i < patients.size(); i++) {
            if(patients.get(i).UID.equals(string)){
                return i;
            }
        }
        throw new PatientDoesntExistException(string);
    }

    /**
     *
     * @param hw
     */
    public void createHomework(HomeWork hw){
        String query;
        query= "INSERT INTO exercice (patient_id,pro_id,nom,etat) VALUES(NULL ,"
                +getUid()+",'"
                +hw.name+"', false)";
        Log.d("user", query);
        try{
            new DataBaseInsert().execute(query);
        }catch (Exception e){
            Log.d("Pro","adding a homework in database"+e.fillInStackTrace());
        }
        myHomeWorks.add(hw);
    }

    /**
     *
     * @param hw
     */
    public void updateHomework(HomeWork hw){
        if (myHomeWorks.contains(hw)) {
            String query;

            query = "UPDATE exercice SET nom='"+hw.name+"' WHERE id=" + hw.id;

            Log.d("Pro", query);
            try {
                new DataBaseUpdate().execute(query);

                } catch (Exception e) {
                Log.d("Pro", "changing homewok" + e.fillInStackTrace());
            }
        }
    }

    public void deleteHomework(HomeWork hw){
        String query;
        query= "DELETE FROM exercice WHERE id="+hw.id;
        Log.d("Pro", query);
        try{
            new DataBaseDelete().execute(query);
        }catch (Exception e){
            Log.d("Pro","remove a homework in database"+e.fillInStackTrace());
        }
        myHomeWorks.remove(hw);
    }
    public void giveHomework(Patient p, HomeWork h){
        if (myHomeWorks.contains(h)) {
            String query;

            query = "UPDATE exercice SET patient_id='"+p.getUid()+"' WHERE id=" + h.id;

            Log.d("Pro", query);
            try {
                new DataBaseUpdate().execute(query);

            } catch (Exception e) {
                Log.d("Pro", "changing association homewok" + e.fillInStackTrace());
            }
        }
        p.addActivities(h);
    }

    public void createAppointement(Appointement app){
        String query;
        query= "INSERT INTO rdv (pro_id,patient_id,daterdv) VALUES("
                +getUid()+","
                +app.getPatient().getUid()+",'"
                +app.getDate()+"')";
        Log.d("pro", query);
        try{
            new DataBaseInsert().execute(query);
        }catch (Exception e){
            Log.d("Pro","adding an appointement in database"+e.fillInStackTrace());
        }
        appointements.add(app);

    }
    public void deleteAppointement(Appointement app){
        if(appointements.contains(app)){
            String query;
            query= "DELETE FROM rdv WHERE pro_id="+this.getUid()+" AND patient_id="+app.getPatient().getUid()+ " AND daterdv='"+ app.getDate()+"'";
            Log.d("Pro", query);
            try{
                new DataBaseDelete().execute(query);
            }catch (Exception e){
                Log.d("Pro","remove an appoitenemtent in database"+e.fillInStackTrace());
            }
            appointements.remove(app);
        }

    }
    public void updateAppointement(Appointement app, Date date){
        if (appointements.contains(app)) {
            String query;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String formattedDate = dateFormat.format(date);
            String formattedAppDate = dateFormat.format(app.getDate());
            query = "UPDATE rdv SET daterdv='"+formattedDate
                    +"' WHERE pro_id=" + this.getUid()
                    + " AND patient_id="+app.getPatient().getUid()
                    + " AND daterdv='"+formattedAppDate+"'";

            Log.d("Pro", query);
            try {
                new DataBaseUpdate().execute(query);

            } catch (Exception e) {
                Log.d("Pro", "changing date of appointement" + e.fillInStackTrace());
            }
        }
    }

    public String toString(){
        super.toString();
        Log.d("pro","This is a pro");
        for(Patient p : patients){
            p.toString();
        }
        for(int i=0;i<appointements.size();i++){
            Log.d("pro",appointements.get(i).toString());
        }
        return "";
    }

    public ArrayList<HomeWork> getMyHomeWorks(){
        return myHomeWorks;
    }
    public ArrayList<Patient> getPatients(){
        return patients;
    }
    public ArrayList<Appointement> getAppointements(){
        return  appointements;
    }
}
