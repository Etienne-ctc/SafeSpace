package backend;

import android.util.Log;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Statistics {
    private String name;
    private ArrayList<StatisticsValues> values;

    public Statistics (String name,String id){
        this.name=name;
        this.values=new ArrayList<StatisticsValues>();
        try {
            if(name.equals("sleep")){
                ResultSet result = new DataBaseSelect().execute("SELECT valeur, date,duration,comment From "+name+" WHERE user_id=" + id).get();
                while(result != null && result.next()) {
                    values.add(new Sleep(result.getInt(1),result.getDate(2),result.getInt(3),result.getString(4)));
                }
            }
            if(name.equals("mood")){
                ResultSet result = new DataBaseSelect().execute("SELECT valeur, date,context,activity,comment,commAct From "+name+" WHERE user_id=" + id).get();
                while (result != null && result.next()) {
                    values.add(new Mood(result.getInt(1),result.getDate(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6)));
                }
            }

        }catch(Exception e){
            Log.e("statistics","Exception init stats val", e.fillInStackTrace());
        }

    }
    public String toString(){
        for (int j = 0; j < values.size(); j++) {
            Log.d("Statistics",values.get(j).toString());
        }
        return "";
    }
    public void addStatisticsValue(StatisticsValues s){
        values.add(s);
    }

    public void removeStatisticsValue(StatisticsValues stats) {
        values.remove(stats);
    }

    public String getName(){
        return name;
    }
    public ArrayList<StatisticsValues> getValues(){
        return values;
    }
}
