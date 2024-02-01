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
    public Parameter parameter;
    protected String UID;

    protected ArrayList<Activities> activities;
    protected ArrayList<Statistics> statistics;
    /*
    Type 0 = patient
    Type 1 = pro
    Type 2 = normal user
     */

    /**
     *
     * @param name
     * @param surname
     * @param mail
     * @param mdp
     * @param pro
     */
    public User(String name,String surname,String mail,String mdp,boolean pro){
        this.name=name;
        this.surname=surname;
        this.mail=mail;
        activities=new ArrayList<Activities>();
        statistics=new ArrayList<Statistics>();
        addUser(mdp,pro);
    }

    /**
     *
     * @param UID
     */
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
            ResultSet result = new DataBaseSelect().execute("SELECT id,nom, etat From acti WHERE user_id=" + this.getUid()).get();
            while (result != null && result.next()) {
                activities.add(new Activities(result.getString(2),result.getBoolean(3),result.getString(1)));

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


    /**
     *
     */
    public void updateInfo(){
        //this link the values of the user to the database in case it was changed
    }

    /**
     *
     * @param mdp
     * @param pro
     */
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

    /**
     *
     * @param act
     */
    public void addActivities(Activities act){
        String query;
        query= "INSERT INTO acti (user_id,nom,etat) VALUES ("+getUid()+",'"+act.name+"',false)";
        Log.d("user", query);
        try{
            new DataBaseInsert().execute(query);
        }catch (Exception e){
            Log.d("user","adding an activity in database"+e.fillInStackTrace());
        }
        activities.add(act);
    }

    /**
     *
     * @param act
     */
    public void updateActivities(Activities act) {
        if (activities.contains(act) && !HomeWork.class.isInstance(act)) {
            String query;
            if (act.completion) {
                query = "UPDATE acti SET etat=false WHERE id=" + act.id;
            } else {
                query = "UPDATE acti SET etat=true WHERE id=" + act.id;
            }
            Log.d("Param", query);
            try {
                new DataBaseUpdate().execute(query);
                for(int j=0;j<activities.size();j++){
                    if(activities.get(j).equals(act)){
                        activities.get(j).completion=!activities.get(j).completion;
                    }
                }
            } catch (Exception e) {
                Log.d("Param", "setting add_patients" + e.fillInStackTrace());
            }

        }
        if(activities.contains(act) && HomeWork.class.isInstance(act)){
            String query;
            if (act.completion) {
                query = "UPDATE exercice SET etat=false WHERE id=" + act.id;
            } else {
                query = "UPDATE exercice SET etat=true WHERE id=" + act.id;
            }
            Log.d("Param", query);
            try {
                new DataBaseUpdate().execute(query);
                for(int j=0;j<activities.size();j++){
                    if(activities.get(j).equals(act)){
                        activities.get(j).completion=!activities.get(j).completion;
                    }
                }
            } catch (Exception e) {
                Log.d("Param", "setting add_patients" + e.fillInStackTrace());
            }
        }
    }

    /**
     *
     * @param stats
     */
    public void addMood(Mood stats){

        String query;
        query= "INSERT INTO mood(user_id,valeur,date,context,activity) VALUES("
                +getUid()+","
                +stats.quality+",'"
                +stats.date+"','"
                +stats.getContext()+"','"
                +stats.getActivity()+"')";
        Log.d("user", query);
        try{
            new DataBaseInsert().execute(query);
        }catch (Exception e){
            Log.d("user","adding an mood in database"+e.fillInStackTrace());
        }
        statistics.get(0).addStatisticsValue(stats);
    }

    /**
     *
     * @param stats
     */
    public void addSleep(Sleep stats){

        String query;
        query= "INSERT INTO sleep(user_id,valeur,date,duration) VALUES("
                +getUid()+","
                +stats.quality+",'"
                +stats.date+"',"
                +stats.getDuration()+")";
        Log.d("user", query);
        try{
            new DataBaseInsert().execute(query);
        }catch (Exception e){
            Log.d("user","adding an mood in database"+e.fillInStackTrace());
        }
        statistics.get(1).addStatisticsValue(stats);
    }

    /**
     *
     * @param stats
     */
    public void removeSleep(StatisticsValues stats){
        //to do
        String query;
        query= "DELETE FROM sleep WHERE user_id="+getUid()+" AND date='"+stats.date+"'";
        Log.d("user", query);
        try{
            new DataBaseDelete().execute(query);
        }catch (Exception e){
            Log.d("user","remove a sleep in database"+e.fillInStackTrace());
        }
        statistics.get(1).removeStatisticsValue(stats);

    }

    /**
     *
     * @param stats
     */
    public void removeMood(StatisticsValues stats){
        //to do
        String query;
        query= "DELETE FROM mood WHERE user_id="+getUid()+" AND date='"+stats.date+"'";
        Log.d("user", query);
        try{
            new DataBaseDelete().execute(query);
        }catch (Exception e){
            Log.d("user","remove a mood in database"+e.fillInStackTrace());
        }
        statistics.get(0).removeStatisticsValue(stats);

    }

    /**
     *
     * @return
     */
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

    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
        String query;
        query = "UPDATE user SET mail='"+name+"' WHERE id="+getUid();

        Log.d("user", query);
        try{
            new DataBaseUpdate().execute(query);
        }catch (Exception e){
            Log.d("user","setting name"+e.fillInStackTrace());
        }
    }

    public String getSurname() {
        return surname;
    }

    /**
     *
     * @param surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
        String query;
        query = "UPDATE user SET mail='"+surname+"' WHERE id="+getUid();

        Log.d("user", query);
        try{
            new DataBaseUpdate().execute(query);
        }catch (Exception e){
            Log.d("user","setting surname"+e.fillInStackTrace());
        }
    }

    public String getMail() {
        return mail;
    }

    /**
     *
     * @param mail
     */
    public void setMail(String mail) {
        this.mail = mail;
        String query;
        query = "UPDATE user SET mail='"+mail+"' WHERE id="+getUid();

        Log.d("user", query);
        try{
            new DataBaseUpdate().execute(query);
        }catch (Exception e){
            Log.d("user","setting mail"+e.fillInStackTrace());
        }
    }
    public ArrayList<Activities> getActivities(){
        return activities;
    }
    public ArrayList<Statistics> getStatistics(){
        return statistics;
    }
}
