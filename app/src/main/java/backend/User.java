package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class User {
    private String connectionURL="jdbc:mysql://localhost:3306/test";
    protected String name;
    protected String surname;
    protected String mail;
    protected Parameter parameter;
    protected String UID;
    protected ArrayList<Appointement> appointements;

    public User(String UID){
        try(Connection conn = DriverManager.getConnection(connectionURL,"root", "root")){
            String setUserRequest = "SELECT * FROM User WHERE UID="+UID;

        }catch(SQLException e){
            System.out.println("connection didn't work");
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
