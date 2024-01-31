package backend;

import java.sql.Date;

public class Sleep extends StatisticsValues{
    private int duration;

    public Sleep(int quality, Date date, int duration){
        this.duration=duration;
        this.date=date;
        this.quality=quality;
    }
    public String toString(){
        return "Sleep duration" + duration + " quality" + quality +" date "+date;
    }
}
