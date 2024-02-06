package backend;

import java.util.ArrayList;
import java.sql.Date;

public abstract class StatisticsValues {
    protected int quality;
    protected Date date;
    protected String comment;
    public String getComment(){
        return comment;
    }
}
