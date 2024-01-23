package backend;

import java.util.Date;

public class Mood  extends StatisticsValues{
    private String context;
    private String activity;

    public Mood(int quality, Date date, String context, String activity){
        this.activity=activity;
        this.context=context;
        this.date = date;
        this.quality = quality;
    }

}
