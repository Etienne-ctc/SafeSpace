package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class Professionnal extends User{

    private ArrayList<Patient> patients;
    private ArrayList<HomeWork> myHomeWorks;

    public Professionnal(String UID){
        super(UID);
        this.patients=new ArrayList<Patient>();
        this.myHomeWorks=new ArrayList<HomeWork>();
        try{
            Connection conn = DriverManager.getConnection(connectionURL,"root", "root");
            Statement statement = conn.createStatement();
            String setUserRequest = "SELECT idPatient FROM Patient WHERE idPro="+UID;
            ResultSet resultSet = statement.executeQuery(setUserRequest);
            while (resultSet.next()){
                System.out.println(resultSet.getInt(0)+" ");
                patients.add(new Patient(resultSet.getString(0),this));
            }
            conn.close();

        }catch(Exception e){
            System.out.println(e);
        }

    }
    private void setPatientProfessionnal(Patient patient){

    }
    public void addPatient(String codeQR) {
        //to do
    }
    public void giveHomeWork(Patient patient, HomeWork homeWork){
        //to do
    }
    public void removePatient(Patient patient){
        //to do
    }
    public void addRdv(Date date, Patient patient ){
        //to do
    }
    public void removeRdv(Date date,Patient patient ){
        //to do
    }
    
}
