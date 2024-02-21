package backend;

import android.os.AsyncTask;
import android.util.Log;

import java.sql.*;


public class DataBaseSelect extends AsyncTask<String, Void, ResultSet> {
    private String connectionURL="jdbc:postgresql://kandula.db.elephantsql.com/ktmsitiw";
    public DataBaseSelect(){}
    @Override
    protected ResultSet doInBackground(String... queries) {
        try {
            Connection conn = DriverManager.getConnection(connectionURL, "ktmsitiw", "jjWJDuvTMgzTlocK0eGsxMkFfaouE0Ri");
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(queries[0]); // Assuming only one query for simplicity
            conn.close();
            return resultSet;
        } catch (Exception e) {
            Log.e("DatabaseSelect", "Error in database operation", e);
        }
        return null;
    }

}
