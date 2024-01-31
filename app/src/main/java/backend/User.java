package backend;

import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class User{
    protected String name;
    protected String surname;
    protected String mail;
    protected Parameter parameter;
    protected String UID;

    protected ArrayList<Activities> activities;
    protected ArrayList<Statistics> statistics;
    /*
    Type 0 = patient
    Type 1 = pro
    Type 2 = normal user
     */
    public User(String name,String surname,String mail,String mdp,boolean pro){
        this.name=name;
        this.surname=surname;
        this.mail=mail;
        activities=new ArrayList<Activities>();
        statistics=new ArrayList<Statistics>();
        addUser(mdp,pro);
    }

    public User(String UID){
        activities=new ArrayList<Activities>();
        statistics=new ArrayList<Statistics>();
        System.out.println("trying connection");
        parameter=new Parameter(UID);
        try{
            ResultSet result = new DataBaseSelect().execute("SELECT * From user WHERE id="+UID).get();
            if (result != null && result.next()) {
                this.UID=result.getString(1);
                this.surname=result.getString(2);
                this.mail=result.getString(4);
                this.name=result.getString(3);
            }

        }catch(Exception e){
            Log.e("patient","Exception init user info", e.fillInStackTrace());
        }

        try {
            ResultSet result = new DataBaseSelect().execute("SELECT nom, etat From acti WHERE user_id=" + this.getUid()).get();
            while (result != null && result.next()) {
                activities.add(new Activities(result.getString(1),result.getBoolean(2)));

            }
        }catch(Exception e){
            Log.e("patient","Exception init acti", e.fillInStackTrace());
        }
        try{
            statistics.add(new Statistics("mood",UID));
            statistics.add(new Statistics("sleep",UID));
        }catch (Exception e){
            Log.e("patient","Exception init stats", e.fillInStackTrace());
        }
        //set parameters
        try{
            ResultSet result = new DataBaseSelect().execute("SELECT * From param WHERE user_id="+UID).get();
            if (result != null && result.next()) {
                parameter.setRdv(result.getBoolean(2));
                parameter.setAdd_patients(result.getBoolean(3));
                parameter.setRecap(result.getBoolean(4));
                parameter.setHumeur(result.getBoolean(5));
                parameter.setSommeil(result.getBoolean(6));
                parameter.setTodo(result.getBoolean(7));
            }

        }catch(Exception e){
            Log.e("patient","Exception init user param", e.fillInStackTrace());
        }
    }



    public void updateInfo(){
        //this link the values of the user to the database in case it was changed
    }

    public void addUser(String mdp,boolean pro){
        int type=0;
        if(pro){
            type =1;
        }
        String query = "INSERT INTO user (nom,prenom,mail,mdp,typ) VALUES ('"+this.name+"','"+this.surname+"','"+this.mail+"','"+mdp+"','"+type+"')";
        Log.d("user", query);
        try{
            new DataBaseInsert().execute(query);
        }catch (Exception e){
            Log.d("user","adding a person in database"+e.fillInStackTrace());
        }
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
        String str = "This are the info " + UID + " name " + name + " surname " + surname + " mail " + mail;
        Log.d("User", str);
        for (int i = 0; i < activities.size(); i++) {
            Log.d("User",activities.get(i).toString());
        }

        for (int j = 0; j < statistics.size(); j++) {
            Log.d("User",statistics.get(j).toString());
        }
        Log.d("User",parameter.toString());
        return str;
    }

    public String getUid() {
        return UID;
    }
}
