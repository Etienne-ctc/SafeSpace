package backend;

import java.util.Date;

public class Sleep extends StatisticsValues{
    private int duration;

    public Sleep(int quality, Date date, int duration){
        this.duration=duration;
        this.date=date;
        this.quality=quality;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
