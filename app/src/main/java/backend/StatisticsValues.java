package backend;

import java.util.ArrayList;
import java.util.Date;

public abstract class StatisticsValues {
    protected int quality;
    protected Date date;

    public Date getDate() {
        return date;
    }

    public int getQuality() {
        return quality;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}
