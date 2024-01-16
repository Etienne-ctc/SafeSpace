package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class User {
    protected String connectionURL="jdbc:mysql://localhost:3306/safespace";
    protected String name;
    protected String surname;
    protected String mail;
    protected Parameter parameter;
    protected String UID;
    protected ArrayList<Appointement> appointements;

    public User(String UID){
        try{
            Connection conn = DriverManager.getConnection(connectionURL,"root", "root");
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
            System.out.println(e);
        }


    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Appointement> getAppointements() {
        return appointements;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public String getMail() {
        return mail;
    }

    public String getSurname() {
        return surname;
    }

    public String getUID() {
        return UID;
    }

    public void setAppointements(ArrayList<Appointement> appointements) {
        this.appointements = appointements;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }
}
