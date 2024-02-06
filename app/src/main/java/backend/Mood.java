package backend;

import java.sql.Date;

public class Mood  extends StatisticsValues{
    private String context;
    private String activity;
    private String commAct;
    public Mood(int quality, Date date, String context, String activity,String comment,String commAct){
        this.activity=activity;
        this.context=context;
        this.date = date;
        this.quality = quality;
        this.comment=comment;
        this.commAct=commAct;
    }
    public String getContext(){
        return context;
    }
    public String getActivity(){
        return activity;
    }
    public String getCommAct(){
        return commAct;
    }
    public String toString(){
        return "Mood activity : " + activity + "context "+ context+ " quality" + quality +" date "+date;
    }

}
