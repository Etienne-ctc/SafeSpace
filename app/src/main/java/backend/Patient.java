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
        super();
        //To redo when database works
        /**
        super(UID);
        this.professionnal=professionnal;
        activities=new ArrayList<Activities>();
        statistics=new ArrayList<Statistics>();

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
//redo when call back works
    /**
    @Override
    protected Void doInBackground(Void... voids) {
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
         }/
        return null;
    }*/
}
