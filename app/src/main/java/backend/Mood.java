package backend;

import java.sql.Date;

public class Mood  extends StatisticsValues{
    private String context;
    private String activity;

    public Mood(int quality, Date date, String context, String activity){
        this.activity=activity;
        this.context=context;
        this.date = date;
        this.quality = quality;
    }
    public String toString(){
        return "Mood activity : " + activity + "context "+ context+ " quality" + quality +" date "+date;
    }
}
