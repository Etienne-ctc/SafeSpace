package backend;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class User {
    protected String connectionURL="jdbc:mysql://192.168.1.131:3306/safespace";
    protected String name;
    protected String surname;
    protected String mail;
    protected Parameter parameter;
    protected String UID;
    protected ArrayList<Appointement> appointements;
    public User(){

    }
    public User(String UID){
        //redo with call back function when it's working
        System.out.println("trying connection");
        System.out.println(connectionURL);
        try{
            System.out.println("trying 2");
            Connection conn = DriverManager.getConnection(connectionURL,"root", "root");
            System.out.println("trying 3");
            Statement statement = conn.createStatement();
            String setUserRequest = "SELECT * FROM User WHERE UID="+UID;
            ResultSet resultSet = statement.executeQuery(setUserRequest);
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1)+" ");
                name=resultSet.getString(3);
                surname=resultSet.getString(4);
                mail=resultSet.getString(1);
                this.UID=resultSet.getString(0);
            }
            conn.close();

        }catch(Exception e){
            System.out.println(e.fillInStackTrace());
        }
    }
}
