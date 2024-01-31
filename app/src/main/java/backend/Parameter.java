package backend;

public class Parameter {
    private String user_id=null;
    private boolean rdv=false;
    private boolean add_patients=false;
    private boolean recap=false;
    private boolean todo=false;
    private boolean sommeil=false;
    private boolean humeur=false;
    public Parameter(String uid){
        this.user_id=uid;
    }

    public boolean isHumeur() {
        return humeur;
    }

    public void setHumeur(boolean humeur) {
        this.humeur = humeur;
    }

    public boolean isSommeil() {
        return sommeil;
    }

    public void setSommeil(boolean sommeil) {
        this.sommeil = sommeil;
    }

    public boolean isTodo() {
        return todo;
    }

    public void setTodo(boolean todo) {
        this.todo = todo;
    }

    public boolean isRecap() {
        return recap;
    }

    public void setRecap(boolean recap) {
        this.recap = recap;
    }

    public boolean isAdd_patients() {
        return add_patients;
    }

    public void setAdd_patients(boolean add_patients) {
        this.add_patients = add_patients;
    }

    public boolean isRdv() {
        return rdv;
    }

    public void setRdv(boolean rdv) {
        this.rdv = rdv;
    }

    public String getUser_id() {
        return user_id;
    }
    public String toString(){
        return "uid:"+user_id+"rdv"+rdv+"add_patient"+add_patients+"recap"+recap+"to do"+todo+"humeur"+humeur+"sommeil"+sommeil;
    }
}
