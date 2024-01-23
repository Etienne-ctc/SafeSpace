package backend;

import java.util.ArrayList;

public class Statistics {
    private String name;
    private ArrayList<StatisticsValues> values;

    public Statistics (String name){
        this.name=name;
        this.values=new ArrayList<StatisticsValues>();
        //Fill the stat with it's value using database
        //while is statsvalues in database -> new StatisticsValues(..)
    }

}
