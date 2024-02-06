package backend;

import java.sql.ResultSet;

public class HomeWork extends Activities {
    private Professionnal professionnal;

    public HomeWork(String name, boolean completion, Professionnal pro,String id) {
        super(name,completion,id);
        this.professionnal=pro;
    }
    public HomeWork(String name, boolean completion, Professionnal pro) {
        super(name,completion);
        this.professionnal=pro;
    }


}