import java.util.ArrayList;

public class Professionnal extends User{
    private ArrayList<Patient> patients;
    private ArrayList<HomeWork> myHomeWorks;

    public Professionnal(){
        this.patients=new ArrayList<Patient>();
        this.myHomeWorks=new ArrayList<HomeWork>();
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
    public void addRdv(Date date,Patient patient ){
        //to do
    }
    public void removeRdv(Date date,Patient patient ){
        //to do
    }
    
}
