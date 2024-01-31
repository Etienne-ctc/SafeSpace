package backend;

import android.os.AsyncTask;
import android.util.Log;

import java.sql.*;


public class DataBaseSelect extends AsyncTask<String, Void, ResultSet> {
    private String connectionURL="jdbc:mysql://192.168.1.131:3306/safespace?connectTimeout=5000";
    public DataBaseSelect(){}
    @Override
    protected ResultSet doInBackground(String... queries) {
        try {
            Connection conn = DriverManager.getConnection(connectionURL, "read", "123");
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(queries[0]); // Assuming only one query for simplicity
            return resultSet;
        } catch (Exception e) {
            Log.e("DatabaseSelect", "Error in database operation", e);
        }
        return null;
    }

}
