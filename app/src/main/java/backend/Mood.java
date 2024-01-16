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
    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getActivity() {
        return activity;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
