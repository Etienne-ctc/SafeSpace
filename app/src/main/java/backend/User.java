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
    protected ArrayList<Appointement> appointements;
    /*
    Type 0 = patient
    Type 1 = pro
    Type 2 = normal user
     */
    public User(String name,String surname,String mail,String mdp,boolean pro){
        this.name=name;
        this.surname=surname;
        this.mail=mail;
        addUser(mdp,pro);
    }

    public User(String UID){
        //redo with call back function when it's working
        System.out.println("trying connection");
        try{
            ResultSet result = new DataBaseSelect().execute("SELECT * From user WHERE id="+UID).get();
            if (result != null && result.next()) {
                this.UID=result.getString(1);
                this.surname=result.getString(2);
                this.mail=result.getString(4);
                this.name=result.getString(3);
            }

        }catch(Exception e){
            System.out.println(e.fillInStackTrace());
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



    public String toString(){
        String str = "This are the info "+UID+" name "+name+" surname "+ surname +" mail "+mail;
        Log.d("User", str);
        return str;
    }
}
