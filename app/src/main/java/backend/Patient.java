package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Patient extends User{
    private ArrayList<Activities> activities;
    private ArrayList<Statistics> statistics;
    private Professionnal professionnal;
    private String QRCode;

    public Patient(String UID,Professionnal professionnal){
        super(UID);
        this.professionnal=professionnal;
        activities=new ArrayList<Activities>();
        statistics=new ArrayList<Statistics>();
        /** Pas sur de ça
        try{
            Connection conn = DriverManager.getConnection(connectionURL,"root", "root");
            Statement statement = conn.createStatement();
            String setUserRequest = "SELECT idPro FROM Patient WHERE idPatient="+UID;
            ResultSet resultSet = statement.executeQuery(setUserRequest);
            while (resultSet.next()){
                System.out.println(resultSet.getInt(0)+" ");
                professionnal =new Professionnal(resultSet.getString(0));
            }
            conn.close();

        }catch(Exception e){
            System.out.println(e);
        }*/
    }
    public Patient(String UID){
        super(UID);
        this.professionnal=null;
        activities=new ArrayList<Activities>();
        statistics=new ArrayList<Statistics>();
    }
    private void generateQRCode(){
    //to do
    }
    public void addActivities(Activities act){
        activities.add(act);
    }
    public void updateActivities(Activities act){
        //to do
    }
    public void addStatistics(String name, StatisticsValues stats){
        //to do
    }

    public void removeStatistics(String name, StatisticsValues stats){
        //to do
    }
}
