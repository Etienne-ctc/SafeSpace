package backend;

import android.util.Log;

public class Parameter {
    private String user_id=null;
    private boolean rdv=false;
    private boolean add_patients=false;
    private boolean recap=false;
    private boolean todo=false;
    private boolean sommeil=false;
    private boolean humeur=false;
    public Parameter(String uid){
        this.user_id=uid;
    }

    public boolean isHumeur() {
        return humeur;
    }

    /**
     * This set the Humeur value and update it's value in the database too
     * @param humeur
     */
    public void setHumeur(boolean humeur) {
        this.humeur = humeur;
        String query;
        if(humeur){
            query = "UPDATE param SET humeur=true WHERE user_id="+user_id;
        }else{
            query = "UPDATE param SET humeur=false WHERE user_id="+user_id;
        }
        Log.d("Param", query);
        try{
            new DataBaseUpdate().execute(query);
        }catch (Exception e){
            Log.d("Param","setting humeur"+e.fillInStackTrace());
        }
    }

    public boolean isSommeil() {
        return sommeil;
    }

    /**
     * This set the Sommeil value and update it's value in the database too
     * @param sommeil
     */
    public void setSommeil(boolean sommeil) {
        this.sommeil = sommeil;
        String query;
        if(sommeil){
            query = "UPDATE param SET sommeil=true WHERE user_id="+user_id;
        }else{
            query = "UPDATE param SET sommeil=false WHERE user_id="+user_id;
        }
        Log.d("Param", query);
        try{
            new DataBaseUpdate().execute(query);
        }catch (Exception e){
            Log.d("Param","setting sommeil"+e.fillInStackTrace());
        }
    }

    public boolean isTodo() {
        return todo;
    }

    /**
     * This set the to do value and update it's value in the database too
     * @param todo
     */
    public void setTodo(boolean todo) {
        this.todo = todo;
        String query;
        if(todo){
            query = "UPDATE param SET todo=true WHERE user_id="+user_id;
        }else{
            query = "UPDATE param SET todo=false WHERE user_id="+user_id;
        }
        Log.d("Param", query);
        try{
            new DataBaseUpdate().execute(query);
        }catch (Exception e){
            Log.d("Param","setting todo"+e.fillInStackTrace());
        }
    }

    public boolean isRecap() {
        return recap;
    }

    /**
     * This set the recap value and update it's value in the database too
     * @param recap
     */
    public void setRecap(boolean recap) {
        this.recap = recap;
        String query;
        if(recap){
            query = "UPDATE param SET recap=true WHERE user_id="+user_id;
        }else{
            query = "UPDATE param SET recap=false WHERE user_id="+user_id;
        }
        Log.d("Param", query);
        try{
            new DataBaseUpdate().execute(query);
        }catch (Exception e){
            Log.d("Param","setting recap"+e.fillInStackTrace());
        }
    }

    public boolean isAdd_patients() {
        return add_patients;
    }

    /**
     * This set the add_patient value and update it's value in the database too
     * @param add_patients
     */
    public void setAdd_patients(boolean add_patients) {
        this.add_patients = add_patients;
        String query;
        if(add_patients){
            query = "UPDATE param SET add_patients=true WHERE user_id="+user_id;
        }else{
            query = "UPDATE param SET add_patients=false WHERE user_id="+user_id;
        }
        Log.d("Param", query);
        try{
            new DataBaseUpdate().execute(query);
        }catch (Exception e){
            Log.d("Param","setting add_patients"+e.fillInStackTrace());
        }
    }

    public boolean isRdv() {
        return rdv;
    }

    /**
     * This set the rdv value and update it's value in the database too
     * @param rdv
     */
    public void setRdv(boolean rdv) {
        this.rdv = rdv;
        String query;
        if(rdv){
            query = "UPDATE param SET rdv=true WHERE user_id="+user_id;
        }else{
            query = "UPDATE param SET rdv=false WHERE user_id="+user_id;
        }
        Log.d("Param", query);
        try{
            new DataBaseUpdate().execute(query);
        }catch (Exception e){
            Log.d("Param","setting rdv"+e.fillInStackTrace());
        }
    }

    public String getUser_id() {
        return user_id;
    }
    public String toString(){
        return "uid:"+user_id+"rdv"+rdv+"add_patient"+add_patients+"recap"+recap+"to do"+todo+"humeur"+humeur+"sommeil"+sommeil;
    }
}
