import java.util.ArrayList;

public class Statistics {
    private String name;
    private ArrayList<StatisticsValues> values;

    public Statistics (String name){
        this.name=name;
        this.values=new ArrayList<StatisticsValues>();
    }

    public void addValues(StatisticsValues val){
        values.add(val);
    }
    public void removeValues(StatisticsValues val){
        values.remove(val);
    }
    public ArrayList<StatisticsValues> getValues() {
        return values;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValues(ArrayList<StatisticsValues> values) {
        this.values = values;
    }
}
