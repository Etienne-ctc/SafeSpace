package backend;

import java.sql.Date;

public class Appointement {
    private Patient patient;
    private Date date;
    private Professionnal professionnal;
    private String notes;

    public Appointement(Patient patient, Date date, Professionnal professionnal, String notes){
        this.date=date;
        this.patient = patient;
        this.professionnal = professionnal;
        this.notes=notes;
    }
    public String toString(){
        return "RDV ::::date : "+ date + " patient :" + patient.name +" pro :" + professionnal.name + "notes "+ notes;
    }
}
