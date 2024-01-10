import java.util.Date;

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
    public Appointement(Patient patient, Date date, Professionnal professionnal){
        this.date=date;
        this.patient = patient;
        this.professionnal = professionnal;
        this.notes=null;
    }
}
