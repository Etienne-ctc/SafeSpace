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

    public User(String UID){
        //redo with call back function when it's working
        System.out.println("trying connection");
        try{
            ResultSet result = new DataBaseSelect().execute("SELECT * From user WHERE idUser="+UID).get();
            if (result != null && result.next()) {
                this.UID=result.getString(1);
                this.surname=result.getString(5);
                this.mail=result.getString(2);
                this.name=result.getString(4);
                this.toString();
            }

        }catch(Exception e){
            System.out.println(e.fillInStackTrace());
        }
    }

    public void updateInfo(){
        //this link the values of the user to the database in case it was changed
    }




    public String toString(){
        String str = "This are the info "+UID+" name "+name+" surname "+ surname +" mail "+mail;
        Log.d("User", str);
        return str;
    }
}
